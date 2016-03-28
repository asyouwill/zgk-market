/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: shishuo
 * $Id:  UserAccountDAO.java 2015-07-13 09:45:17 $
 */
package cn.thinkjoy.zgk.market.dao;


import cn.thinkjoy.zgk.market.domain.UserInfo;

public interface IUserInfoExDAO {

    long insertUserInfo(UserInfo userInfo);

    void updateUserCanTargetByUid(long uid);

    boolean isPredictByUid(long uid);

}
