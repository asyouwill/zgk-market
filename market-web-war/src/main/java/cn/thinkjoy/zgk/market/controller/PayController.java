package cn.thinkjoy.zgk.market.controller;

import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.zgk.market.common.ERRORCODE;
import cn.thinkjoy.zgk.market.domain.OrderStatements;
import cn.thinkjoy.zgk.market.service.IOrderService;
import cn.thinkjoy.zgk.market.service.IOrderStatementsService;
import cn.thinkjoy.zgk.market.util.NumberGenUtil;
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

import java.util.HashMap;
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


    /**
     * 支付订单
     * @return
     */
    @RequestMapping(value = "/payOrder",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> payOrder(@RequestParam("orderNo") String orderNo,@RequestParam("amount")String amount,@RequestParam("userId") long userId ){
        Map<String,Object> resultMap=new HashMap<>();
            //参数错误
            if("".equals(orderNo)||orderNo==null||"".equals(amount)||amount==null||userId==0){
                throw  new BizException(ERRORCODE.PARAM_ERROR.getCode(),ERRORCODE.PARAM_ERROR.getMessage());
            }
        try{
            String statemenstNo=NumberGenUtil.genStatementNo();
            OrderStatements orderstatement=new OrderStatements();
            orderstatement.setAmount(Double.valueOf(amount)*100);
            orderstatement.setCreateDate(System.currentTimeMillis());
            orderstatement.setOrderNo(orderNo);
            //0:交易进行中  1：交易成功  2：交易失败
            orderstatement.setStatus(0);
            orderstatement.setStatementNo(statemenstNo);
            orderStatementService.insert(orderstatement);
            Pingpp.apiKey="sk_test_zHq9uHO8efn9SWvvvTaL0iHS";
            String appId="app_1C8484m1mnf1GujL";
            Map<String,Object> chargeParams=new HashMap<>();
            Map<String,String> app=new HashMap<>();
            app.put("id",appId);
            chargeParams.put("order_no",statemenstNo);
            chargeParams.put("amount",Double.valueOf(amount)*100);
            chargeParams.put("app",app);
            chargeParams.put("client_ip","");
            chargeParams.put("subject","");
            chargeParams.put("body","");
            Charge.create(chargeParams);



            resultMap.put("code",200);
            resultMap.put("msg","支付成功");
            return resultMap;
        }catch (Exception e){
            throw new BizException(ERRORCODE.FAIL.getCode(),ERRORCODE.FAIL.getMessage());
        }

    }

}
