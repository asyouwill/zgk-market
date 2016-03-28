/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: shishuo
 * $Id:  UserAccountServiceImpl.java 2015-07-13 09:45:17 $
 */
package cn.thinkjoy.zgk.market.service.impl;


import cn.thinkjoy.zgk.market.dao.*;
import cn.thinkjoy.zgk.market.domain.*;
import cn.thinkjoy.zgk.market.pojo.UserAccountPojo;
import cn.thinkjoy.zgk.market.pojo.UserInfoPojo;
import cn.thinkjoy.zgk.market.service.IUserAccountExService;
import cn.thinkjoy.zgk.market.util.MatrixToImageWriter;
import cn.thinkjoy.zgk.market.util.StaticSource;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service("UserAccountExServiceImpl")
public class UserAccountExServiceImpl implements IUserAccountExService {

    @Autowired
    private IUserAccountExDAO userAccountExDAO;

    @Autowired
    private IUserAccountDAO userAccountDAO;

    @Autowired
    private IUserInfoDAO userInfoDAO;

    @Autowired
    private IUserExamDAO userExamDAO;

    @Autowired
    private IUserInfoExDAO userInfoExDAO;

    @Autowired
    private IUserVipDAO userVipDAO;
    @Autowired
    private IUserMarketDAO userMarketDAO;

    @Override
    public UserAccountPojo findUserAccountPojoByToken(String token) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("token",token);
        return userAccountExDAO.findUserAccountPojo(params);
    }

    @Override
    public UserAccountPojo findUserAccountPojoById(Long id) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("id",id);
        return userAccountExDAO.findUserAccountPojo(params);
    }

    @Override
    public UserAccountPojo findUserAccountPojoByPhone(String account) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("account",account);
        return  userAccountExDAO.findUserAccountPojo(params);

    }

    @Override
    public int findUserAccountCountByPhone(String account,long areaId) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("account",account);
        params.put("areaId",areaId);
        return userAccountExDAO.findUserAccountCount(params);
    }

    @Override
    public boolean insertUserAccount(UserAccount userAccount,Long sharerId,Integer sharerType) {
        boolean flag;
        userAccountDAO.insert(userAccount);
        long id = userAccount.getId();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        String account = userAccount.getAccount();
        userInfo.setName("gk-" + account.substring(0, 3) + "****" + account.substring(account.length() - 4, account.length()));
        userInfo.setToken(UUID.randomUUID().toString());
        userInfo.setProvinceId(userAccount.getProvinceId());
        userInfo.setCityId(userAccount.getCityId());
        userInfo.setCountyId(userAccount.getCountyId());
        userInfoExDAO.insertUserInfo(userInfo);
        UserVip userVip = new UserVip();
        userVip.setId(id);
        userVip.setStatus(0);
        userVip.setCreateDate(System.currentTimeMillis());
        userVipDAO.insert(userVip);
        UserExam userExam = new UserExam();
        userExam.setId(id);
        userExam.setIsReported(0);
        userExam.setIsSurvey(0);
        userExamDAO.insert(userExam);
        try{
        UserMarket userMarket = new UserMarket();
        userMarket.setAccountId(id);
        Integer agentLevel = 0;
        if(sharerType == 0){//供货商
            agentLevel =1;
        }else if(sharerType == 1){//普通用户
            UserMarket userMarket1 = (UserMarket)userMarketDAO.findOne("accountId", sharerId, null, null);
            if(userMarket1 !=null){
                agentLevel = userMarket1.getAgentLevel()+1;
            }
        }
        userMarket.setAgentLevel(agentLevel);
        userMarket.setCreateDate(System.currentTimeMillis());
        userMarket.setCreator(id);
        userMarket.setFromType(1);//微信
        userMarket.setSharerId(sharerId);
        String uploadUrl = StaticSource.getSource("uploadUrl");
        String loginUrl = StaticSource.getSource("loginUrl")+"?sharerId="+id+"&sharerType="+1;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = multiFormatWriter.encode(loginUrl, BarcodeFormat.QR_CODE, 400, 400,hints);
        File file = new File("/Users/yhwang/zgk",id+".jpg");
        MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        RestTemplate template = new RestTemplate();
        param.add("file", file);
        param.add("productCode", "gk360");
        param.add("bizSystem", "gk360");
        param.add("spaceName", "gk360");
        param.add("userId", "gk360");
        param.add("dirId", "0");
        template.getMessageConverters().add(new FastJsonHttpMessageConverter());
        String imgUrl = template.postForObject(uploadUrl, param, String.class);
        userMarket.setQrcodeUrl(imgUrl);//二维码地址
        userMarketDAO.insert(userMarket);
            flag = true;
    }catch(Exception e){
            flag = false;
        e.printStackTrace();
    }
    return flag;
}

    @Override
    public boolean updateUserAccount(UserAccount userAccount){
        boolean flag = false;
        userAccountDAO.update(userAccount);
        flag = true;
        return flag;
    }

    @Override
    public UserAccount findUserAccountById(long id){
        return userAccountDAO.fetch(id);
    }

    @Override
    public UserInfoPojo getUserInfoPojoById(long id){
        Map<String,Object> params = new HashMap<>();
        params.put("id",id);
        return userAccountExDAO.getUserInfoPojoById(params);
    }

    @Override
    public UserInfoPojo findOldUserAccountPojoById(long id) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("id",id);
        return userAccountExDAO.findOldUserAccountPojo(params);
    }

    @Override
    public UserInfoPojo findOldUserAccountPojoByPhone(String phone) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("account",phone);
        return userAccountExDAO.findOldUserAccountPojo(params);
    }

}
