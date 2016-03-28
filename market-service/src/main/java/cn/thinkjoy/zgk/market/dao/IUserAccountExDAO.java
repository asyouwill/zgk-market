/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: shishuo
 * $Id:  UserAccountDAO.java 2015-07-13 09:45:17 $
 */
package cn.thinkjoy.zgk.market.dao;


import cn.thinkjoy.zgk.market.pojo.UserAccountPojo;
import cn.thinkjoy.zgk.market.pojo.UserInfoPojo;

import java.util.Map;

public interface IUserAccountExDAO {

    UserAccountPojo findUserAccountPojo(Map<String, Object> params);

    int findUserAccountCount(Map<String, Object> params);

    UserInfoPojo getUserInfoPojoById(Map<String, Object> params);

    UserInfoPojo findOldUserAccountPojo(Map<String, Object> params);

}
