/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: market
 * $Id:  UserMarket.java 2016-03-27 17:47:13 $
 */



package cn.thinkjoy.zgk.market.domain;

import cn.thinkjoy.common.domain.CreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserMarket extends CreateBaseDomain{
    private Long accountId;
    private Long sharerId;
    private Integer sharerType;
    private String qrcodeUrl;
    private Integer agentLevel;
    private Integer fromType;
    private Long updateDate;
    private Integer modifier;

	public UserMarket(){
	}
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    public Long getAccountId() {
        return this.accountId;
    }
    public void setSharerId(Long value) {
        this.sharerId = value;
    }

    public Long getSharerId() {
        return this.sharerId;
    }
    public void setSharerType(Integer value) {
        this.sharerType = value;
    }

    public Integer getSharerType() {
        return this.sharerType;
    }
    public void setQrcodeUrl(String value) {
        this.qrcodeUrl = value;
    }

    public String getQrcodeUrl() {
        return this.qrcodeUrl;
    }
    public void setAgentLevel(Integer value) {
        this.agentLevel = value;
    }

    public Integer getAgentLevel() {
        return this.agentLevel;
    }
    public void setFromType(Integer value) {
        this.fromType = value;
    }

    public Integer getFromType() {
        return this.fromType;
    }
    public void setUpdateDate(Long value) {
        this.updateDate = value;
    }

    public Long getUpdateDate() {
        return this.updateDate;
    }
    public void setModifier(Integer value) {
        this.modifier = value;
    }

    public Integer getModifier() {
        return this.modifier;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("AccountId",getAccountId())
			.append("SharerId",getSharerId())
			.append("SharerType",getSharerType())
			.append("QrcodeUrl",getQrcodeUrl())
			.append("AgentLevel",getAgentLevel())
			.append("FromType",getFromType())
			.append("CreateDate",getCreateDate())
			.append("UpdateDate",getUpdateDate())
			.append("Creator",getCreator())
			.append("Modifier",getModifier())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserMarket == false) return false;
		if(this == obj) return true;
		UserMarket other = (UserMarket)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

