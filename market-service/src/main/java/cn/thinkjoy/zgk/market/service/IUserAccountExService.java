/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: shishuo
 * $Id:  UserAccountService.java 2015-07-13 09:45:17 $
 */

package cn.thinkjoy.zgk.market.service;


import cn.thinkjoy.zgk.market.domain.UserAccount;
import cn.thinkjoy.zgk.market.pojo.UserAccountPojo;

public interface IUserAccountExService {

    UserAccountPojo findUserAccountPojoByToken(String token);

    UserAccountPojo findUserAccountPojoById(Long id);

    UserAccountPojo findUserAccountPojoByPhone(String phone, long areaId);

    int findUserAccountCountByPhone(String phone, long areaId);

    boolean insertUserAccount(UserAccount userAccount,Long sharerId,Integer sharerType);

    boolean updateUserAccount(UserAccount userAccount);

    UserAccount findUserAccountById(long id);

}
