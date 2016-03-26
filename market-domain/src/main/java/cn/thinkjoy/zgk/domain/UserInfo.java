/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: gk
 * $Id:  UserInfo.java 2015-09-28 18:43:26 $
 */





package cn.thinkjoy.zgk.domain;

import cn.thinkjoy.common.domain.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserInfo extends BaseDomain {
    /** 预留 */
    private String token;
    /** 用户名 */
    private String name;
    /** 头像 */
    private String icon;
    /** 省份Id */
    private String provinceId;
    /** 城市Id */
    private String cityId;
    /** 区域Id */
    private String countyId;
    /** 学校名称 */
    private String schoolName;
    /** 生日 */
    private Long birthdayDate;
    /** 性别，0女，1男 */
    private Integer sex;
    /** 科类，0文科，1理科 */
    private Integer subjectType;
    /** 邮箱 */
    private String mail;
    /** QQ号 */
    private String qq;

    public UserInfo(){
    }
    public void setToken(String value) {
        this.token = value;
    }

    public String getToken() {
        return this.token;
    }
    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }
    public void setIcon(String value) {
        this.icon = value;
    }

    public String getIcon() {
        return this.icon;
    }
    public void setProvinceId(String value) {
        this.provinceId = value;
    }

    public String getProvinceId() {
        return this.provinceId;
    }
    public void setCityId(String value) {
        this.cityId = value;
    }

    public String getCityId() {
        return this.cityId;
    }
    public void setCountyId(String value) {
        this.countyId = value;
    }

    public String getCountyId() {
        return this.countyId;
    }
    public void setSchoolName(String value) {
        this.schoolName = value;
    }

    public String getSchoolName() {
        return this.schoolName;
    }
    public void setBirthdayDate(Long value) {
        this.birthdayDate = value;
    }

    public Long getBirthdayDate() {
        return this.birthdayDate;
    }
    public void setSex(Integer value) {
        this.sex = value;
    }

    public Integer getSex() {
        return this.sex;
    }
    public void setSubjectType(Integer value) {
        this.subjectType = value;
    }

    public Integer getSubjectType() {
        return this.subjectType;
    }
    public void setMail(String value) {
        this.mail = value;
    }

    public String getMail() {
        return this.mail;
    }
    public void setQq(String value) {
        this.qq = value;
    }

    public String getQq() {
        return this.qq;
    }

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("Id",getId())
                .append("Token",getToken())
                .append("Name",getName())
                .append("Icon",getIcon())
                .append("ProvinceId",getProvinceId())
                .append("CityId",getCityId())
                .append("CountyId",getCountyId())
                .append("SchoolName",getSchoolName())
                .append("BirthdayDate",getBirthdayDate())
                .append("Sex",getSex())
                .append("SubjectType",getSubjectType())
                .append("Mail",getMail())
                .append("Qq",getQq())
                .toString();
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof UserInfo == false) return false;
        if(this == obj) return true;
        UserInfo other = (UserInfo)obj;
        return new EqualsBuilder()
                .append(getId(), other.getId())
                .isEquals();
    }
}

