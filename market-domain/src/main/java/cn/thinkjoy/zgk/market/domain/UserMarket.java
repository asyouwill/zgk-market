/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: market
 * $Id:  UserMarket.java 2016-03-26 13:36:19 $
 */



package cn.thinkjoy.zgk.market.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.thinkjoy.common.domain.CreateBaseDomain;

public class UserMarket extends CreateBaseDomain{
    private Integer accountId;
    private Integer parentId;
    private String qrcodeUrl;
    private Integer agentLevel;
    private Long updateDate;
    private Integer modifier;

	public UserMarket(){
	}
    public void setAccountId(Integer value) {
        this.accountId = value;
    }

    public Integer getAccountId() {
        return this.accountId;
    }
    public void setParentId(Integer value) {
        this.parentId = value;
    }

    public Integer getParentId() {
        return this.parentId;
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
			.append("ParentId",getParentId())
			.append("QrcodeUrl",getQrcodeUrl())
			.append("AgentLevel",getAgentLevel())
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

