/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: market
 * $Id:  OrderDAO.java 2016-03-26 13:36:17 $
 */
package cn.thinkjoy.zgk.market.dao;


import cn.thinkjoy.common.dao.IBaseDAO;
import cn.thinkjoy.zgk.market.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IOrderDAO extends IBaseDAO<Order> {


    List<Map<String,Object>> queryOrderListByUserId(@Param("userId")long userId, @Param("pageNo")int pageNo, @Param("pageSize")int pageSize);

    Map<String,Object> queryOrderByNo(@Param("orderNo")String orderNo);
}
