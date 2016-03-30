package cn.thinkjoy.zgk.market.controller;

import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.zgk.market.common.ERRORCODE;
import cn.thinkjoy.zgk.market.domain.OrderStatements;
import cn.thinkjoy.zgk.market.service.IOrderService;
import cn.thinkjoy.zgk.market.service.IOrderStatementsService;
import cn.thinkjoy.zgk.market.util.IPUtil;
import cn.thinkjoy.zgk.market.util.NumberGenUtil;
import cn.thinkjoy.zgk.market.util.StaticSource;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wpliu on 16/3/26.
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    private Logger logger= LoggerFactory.getLogger(PayController.class);
  @Autowired
  private IOrderService orderService;

  @Autowired
  private IOrderStatementsService orderStatementService;


    public static final String  CURRENCY ="cny";
    /**
     * 支付订单
     * @return
     */
    @RequestMapping(value = "/payOrder",method = RequestMethod.POST)
    @ResponseBody
    public Charge payOrder(@RequestParam(value = "orderNo",required = true) String orderNo,
                                       @RequestParam(value = "amount",required = true)String amount,
                                       @RequestParam(value = "userId",required = true)long userId,
                                       @RequestParam(value = "channel",required = true)String channel ,
                                       @RequestParam(value = "subject",required = true)String subject,
                                       @RequestParam(value = "body",required = true)String body,
                                       HttpServletRequest request){
        Map<String,Object> resultMap=new HashMap<>();
            //参数错误
          if("".equals(orderNo)||orderNo==null||"".equals(amount)||amount==null||userId==0){
                throw  new BizException(ERRORCODE.PARAM_ERROR.getCode(),ERRORCODE.PARAM_ERROR.getMessage());
            }
        try{
//            Pingpp.apiKey="sk_test_zHq9uHO8efn9SWvvvTaL0iHS";
//            String appId="app_1C8484m1mnf1GujL";
            Pingpp.apiKey=StaticSource.getSource("apiKey");
            String statemenstNo=NumberGenUtil.genStatementNo();
            OrderStatements orderstatement=new OrderStatements();
            orderstatement.setAmount(Double.valueOf(amount)*100);
            orderstatement.setCreateDate(System.currentTimeMillis());
            orderstatement.setOrderNo(orderNo);
            //0:交易进行中  1：交易成功  2：交易失败
            orderstatement.setStatus(0);
            orderstatement.setStatementNo(statemenstNo);
            orderStatementService.insert(orderstatement);
            Map<String,Object> chargeParams=new HashMap<>();
            Map<String,String> app=new HashMap<>();
            app.put("id", StaticSource.getSource("appId"));
            chargeParams.put("order_no",statemenstNo);
            chargeParams.put("amount",Double.valueOf(amount)*100);
            chargeParams.put("app",app);
            chargeParams.put("channel",channel);
            chargeParams.put("client_ip", IPUtil.getRemortIP(request));
            chargeParams.put("subject",subject);
            chargeParams.put("body",body);
            chargeParams.put("currency",CURRENCY);
            Charge charge=Charge.create(chargeParams);
            //to do 插入流水凭证

            return charge;
        }catch (Exception e){
            throw new BizException(ERRORCODE.FAIL.getCode(),ERRORCODE.FAIL.getMessage());
        }

    }

    /**
     * 订单回调函数
     * @return
     */
    @RequestMapping(value = "/callBack",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> callBack(@RequestParam("orderNo") String orderNo,
                                       @RequestParam("amount")String amount,
                                       @RequestParam("userId")long userId,
                                       @RequestParam("channel")String channel ){

        Map<String,Object> resultMap=new HashMap<>();
        return  resultMap;

    }

    /**
     * 获取用户交易流水
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "getTradeInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getPayList(@RequestParam("userId")long userId,
                                               @RequestParam("pageNo")int pageNo,
                                               @RequestParam("pageSize")int pageSize){

        List<Map<String,Object>> resultMap=new ArrayList<>();
//        resultMap=orderStatementService.queryPage();
        return  resultMap;
    }



    /**
     * 退款函数
     * @return
     */
    @RequestMapping(value = "/refunds",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> refunds(@RequestParam("orderNo") String orderNo,
                                       @RequestParam("amount")String amount,
                                       @RequestParam("userId")long userId,
                                       @RequestParam("channel")String channel ){

                //TO DO
        return  null;
    }




}
