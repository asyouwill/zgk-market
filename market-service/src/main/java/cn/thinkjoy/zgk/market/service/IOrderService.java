/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: market
 * $Id:  OrderService.java 2016-03-26 13:36:17 $
 */

package cn.thinkjoy.zgk.market.service;
import cn.thinkjoy.common.dao.IBaseDAO;
import cn.thinkjoy.common.domain.BaseDomain;
import cn.thinkjoy.common.service.IBaseService;
import cn.thinkjoy.common.service.IPageService;

import java.util.List;
import java.util.Map;

public interface IOrderService<D extends IBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T>,IPageService<D, T>{

    List<Map<String,Object>> queryOrderListByUserId(long userId, int pageNo, int pageSize);

    Map<String,Object> queryOrderByNo(String orderNo);
}
