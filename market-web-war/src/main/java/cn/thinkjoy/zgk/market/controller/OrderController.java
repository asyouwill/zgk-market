package cn.thinkjoy.zgk.market.controller;

import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.zgk.market.common.ERRORCODE;
import cn.thinkjoy.zgk.market.domain.Order;
import cn.thinkjoy.zgk.market.service.IOrderService;
import cn.thinkjoy.zgk.market.util.NumberGenUtil;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wpliu on 16/3/27.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    private Logger logger= LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private IOrderService orderService;
    /**
     * 提交订单
     * @return
     */
    @RequestMapping(value = "/commitOrder",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> commitOrder(@RequestBody Order order){
        Map<String,Object> resultMap=new HashMap<>();

        //参数错误
        if(order==null){
            throw new BizException(ERRORCODE.PARAM_ERROR.getCode(),ERRORCODE.PARAM_ERROR.getMessage());
        }
        try{
            order.setOrderNo(NumberGenUtil.genOrderNo());
            orderService.insert(order);
            resultMap.put("code",200);
            resultMap.put("msg","下单成功");
        }catch (Exception e){
            logger.error("用户" + order.getUserId() + ",提交订单异常:" + e);
            throw new BizException(ERRORCODE.FAIL.getCode(),ERRORCODE.FAIL.getMessage());
        }finally {
            return resultMap;
        }
    }

    /**
     *获取用户订单数据
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getUserOrderList",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getUserOrderList(@RequestParam("userId")long userId,
                                                     @RequestParam("pageNo")int pageNo,
                                                     @RequestParam("pageSize")int pageSize){
        List<Map<String,Object>> result=new ArrayList<>();
        result=orderService.queryOrderListByUserId(userId, pageNo, pageSize);
        return  result;
    }


    /**
     * 获取订单详情
     * @param orderNo
     * @return
     */
    public Map<String,Object> getOrderInfo(@RequestParam("orderNo")String orderNo){

        Map<String,Object> resultMap=new HashMap<>();
        resultMap=orderService.queryOrderByNo(orderNo);
        return  resultMap;
    }

}
