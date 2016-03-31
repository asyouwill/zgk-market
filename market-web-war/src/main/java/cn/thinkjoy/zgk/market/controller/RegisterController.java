package cn.thinkjoy.zgk.market.controller;

import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.zgk.market.common.BaseCommonController;
import cn.thinkjoy.zgk.market.common.ERRORCODE;
import cn.thinkjoy.zgk.market.constant.RedisConst;
import cn.thinkjoy.zgk.market.domain.Province;
import cn.thinkjoy.zgk.market.domain.UserAccount;
import cn.thinkjoy.zgk.market.pojo.UserAccountPojo;
import cn.thinkjoy.zgk.market.service.IProvinceService;
import cn.thinkjoy.zgk.market.service.IUserAccountExService;
import cn.thinkjoy.zgk.market.util.DESUtil;
import cn.thinkjoy.zgk.market.util.RedisUtil;
import com.jlusoft.microschool.core.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by yhwang on 15/9/22.
 * 注册
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseCommonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private IUserAccountExService userAccountExService;
    @Autowired
    private IProvinceService provinceService;

    /**
     * 注册账号
     * @param account
     * @param captcha
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/account",method = RequestMethod.POST)
    @ResponseBody
    public String registerAccount(@RequestParam(value="account",required = false) String account,
                                  @RequestParam(value="captcha",required = false) String captcha,
                                  @RequestParam(value="password",required = false) String password,
                                  @RequestParam(value="provinceId",required = false) String provinceId,
                                  @RequestParam(value="cityId",required = false) String cityId,
                                  @RequestParam(value="countyId",required = false) String countyId,
                                  @RequestParam(value = "sharerId",required = false) Long sharerId,
                                  @RequestParam(value = "shareType",required = false) Integer sharerType) {
        Long  areaId= getAreaId();
        if (StringUtils.isEmpty(account)) {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请输入账号!");
            }
            if (StringUtils.isEmpty(captcha)) {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请输入验证码!");
            }
            if (StringUtils.isEmpty(password)) {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请输入密码!");
            }
            if (StringUtils.isEmpty(provinceId)||"00".equals(provinceId)) {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请选择省份!");
            }
            List<Province> provinceList =provinceService.findList("id", areaId);
            if(provinceList.size()==0)
            {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请选择正确省份!");
            }
            UserAccountPojo userAccountBean = userAccountExService.findUserAccountPojoByPhone(account);
            if (userAccountBean!=null){
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "该账号已被注册!");
            }
            if (!checkCaptcha(account,captcha)){
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "验证码有误!");
            }

            //保存用户
        UserAccount userAccount = new UserAccount();
        userAccount.setAccount(account);
        userAccount.setPassword(password);
        userAccount.setCreateDate(System.currentTimeMillis());
        userAccount.setLastModDate(System.currentTimeMillis());
        userAccount.setUserType(0);
        userAccount.setStatus(0);
        userAccount.setAreaId(areaId);
        userAccount.setCanTargetSchool(true);
        userAccount.setProvinceId(provinceId);
        userAccount.setCityId(cityId);
        userAccount.setCountyId(countyId);

            try{
                boolean flag=userAccountExService.insertUserAccount(userAccount,sharerId,sharerType);
                if (!flag){
                    throw new BizException(ERRORCODE.PARAM_ERROR.getCode(),"账户注册失败");
                }
            }catch(Exception e){
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(),"账户注册失败");
            }

        userAccountBean = userAccountExService.findUserAccountPojoByPhone(account);
        Long id = userAccountBean.getId();
        Map<String, Object> resultMap = new HashMap<>();
        String token = DESUtil.getEightByteMultypleStr(String.valueOf(id), account);
        try {
            /**
             * 将用户信息保存到redis中
             */
            setUserAccountPojo(userAccountBean, DESUtil.encrypt(token, DESUtil.key));

            resultMap.put("token", DESUtil.encrypt(token, DESUtil.key));
        }catch (Exception e){
            e.printStackTrace();
        }
        userAccountBean.setPassword(null);
        userAccountBean.setId(null);
        resultMap.put("userInfo", userAccountBean);
        return "registerSuccess";
    }
    /**
     * 找回密码
     * @param account
     * @param captcha
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/retrievePassword" ,method = RequestMethod.POST)
    @ResponseBody
    public String retrievePassword(@RequestParam(value="account",required = false) String account,
                                   @RequestParam(value="captcha",required = false) String captcha,
                                   @RequestParam(value="password",required = false) String password)
            throws Exception{
        long areaId = getAreaId();
        try{
            if (StringUtils.isEmpty(account)) {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请输入账号!");
            }
            if (StringUtils.isEmpty(captcha)) {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请输入验证码!");
            }
            if (StringUtils.isEmpty(password)) {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请输入密码!");
            }
            UserAccountPojo userAccountBean = userAccountExService.findUserAccountPojoByPhone(account);
            if (userAccountBean==null){
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "该账号尚未注册!");
            }
            if (!checkCaptcha(account,captcha)){
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "验证码有误!");
            }

            //根据账号id查询账号
            UserAccount userAccount = userAccountExService.findUserAccountById((long)userAccountBean.getId());
            userAccount.setPassword(MD5Util.MD5Encode(password));
            userAccount.setLastModDate(System.currentTimeMillis());
            try{
                //更新账号密码
                boolean flag=userAccountExService.updateUserAccount(userAccount);
                if (!flag){
                    throw new BizException(ERRORCODE.PARAM_ERROR.getCode(),"密码重设失败");
                }
            }catch(Exception e){
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(),"密码重设失败");
            }
        }catch (Exception e){
            throw e;
        }finally {

        }
        return "success";
    }

    /**
     * 注册时验证账号是否已经存在，type=0
     * 找回密码时验证账号是否不存在，type=1
     * @param account
     * @return
     */
    @RequestMapping(value = "/confirmAccount",method = RequestMethod.POST)
    @ResponseBody
    public String confirmAccount(@RequestParam(value = "account",required = true) String account,
                                 @RequestParam(value = "type", required = true) int type) throws Exception{
        try {
            if (StringUtils.isEmpty(account)) {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "请输入账号!");
            }
            UserAccountPojo userAccountBean = userAccountExService.findUserAccountPojoByPhone(account);
            if (type==0){
                if (userAccountBean!=null){
                    throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "该账号已经注册!");
                }
            }else if (type==1){
                if (userAccountBean==null){
                    throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "该账号尚未注册!");
                }
            }else {
                throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "类型错误!");
            }
        }catch (Exception e){
            throw e;
        }
        return "success";
    }

    /**
     * 判断验证码是否正确
     * @param account
     * @param captcha
     * @return
     */
    private boolean checkCaptcha(String account,String captcha){
        boolean equals=false;
        String key = RedisConst.USER_CAPTCHA_KEY+account;
        if (RedisUtil.getInstance().get(key)==null){
            throw new BizException(ERRORCODE.PARAM_ERROR.getCode(), "验证码过期或不存在，请重新获取!");
        }
        String cap=RedisUtil.getInstance().get(key).toString();
        if (captcha.equals(cap)){
            RedisUtil.getInstance().del(key);
            equals=true;
        }
        return equals;
    }

}