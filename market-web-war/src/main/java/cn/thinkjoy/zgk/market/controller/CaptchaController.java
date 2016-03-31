package cn.thinkjoy.zgk.market.controller;

import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.push.domain.sms.SMSCheckCode;
import cn.thinkjoy.push.service.sms.SMSService;
import cn.thinkjoy.zgk.market.common.BaseCommonController;
import cn.thinkjoy.zgk.market.common.ERRORCODE;
import cn.thinkjoy.zgk.market.constant.CaptchaTimeConst;
import cn.thinkjoy.zgk.market.constant.RedisConst;
import cn.thinkjoy.zgk.market.service.IUserAccountExService;
import cn.thinkjoy.zgk.market.util.CaptchaUtil;
import cn.thinkjoy.zgk.market.util.RedisUtil;
import cn.thinkjoy.zgk.market.util.StaticSource;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/captcha")
public class CaptchaController extends BaseCommonController {

    private static final Logger LOGGER= LoggerFactory.getLogger(CaptchaController.class);

    @Autowired
    private SMSService smsService;

    @Autowired
    private IUserAccountExService userAccountExService;

    @RequestMapping(value = "/captcha")
    @ResponseBody
    public String captcha(@RequestParam(value="account",required=false) String account,@RequestParam(value="type",required=false) Integer type) throws Exception {

        long areaId= getAreaId();
        JSONObject result = new JSONObject();
        try{
            if(StringUtils.isEmpty(account)){
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "账号不能为空!");
            }

            if(type==null){
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "类型不能为空!");
            }

            int count = userAccountExService.findUserAccountCountByPhone(account,areaId);

            //type=0为注册，type=1找回密码
            if(type==0) {
                if (count > 0) {
                    throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "手机号已存在!");
                }
            }else if(type==1){
                if (count < 0) {
                    throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "手机号不存在!");
                }
            }else{
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "类型错误!");
            }

            long time = CaptchaTimeConst.CAPTCHA_TIME;
            String timeKey  = RedisConst.CAPTCHA_AUTH_TIME_KEY+account;
            if(!RedisUtil.getInstance().exists(timeKey)){

                String bizTarget = StaticSource.getSource("smsbizTarget");

                String randomString = CaptchaUtil.getRandomNumString(6);

                System.out.println(account);
                System.out.println(randomString);
                SMSCheckCode smsCheckCode=new SMSCheckCode();
                smsCheckCode.setPhone(account);
                smsCheckCode.setBizTarget(bizTarget);
                smsCheckCode.setCheckCode(randomString);

                boolean smsResult =smsService.sendSMS(smsCheckCode,false);

                while(!smsResult) {
                    smsResult = smsService.sendSMS(smsCheckCode,false);
                }
                String userCaptchaKey = RedisConst.USER_CAPTCHA_KEY+account;
                RedisUtil.getInstance().set(userCaptchaKey,randomString);
                RedisUtil.getInstance().expire(userCaptchaKey, 600, TimeUnit.SECONDS);
                RedisUtil.getInstance().set(timeKey, String.valueOf(System.currentTimeMillis()));
                RedisUtil.getInstance().expire(timeKey, 60, TimeUnit.SECONDS);
            }else{
                time = time - ((System.currentTimeMillis() - Long.valueOf(RedisUtil.getInstance().get(timeKey).toString()))/1000);
            }

            result.put("time", time);
        } catch(Exception e){
            throw e;
        }
//		finally{
//			request.setAttribute("result", obj.toString());
//		}
        return result.toJSONString();
    }

}
