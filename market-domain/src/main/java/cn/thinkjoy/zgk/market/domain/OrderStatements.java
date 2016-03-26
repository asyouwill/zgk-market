/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: market
 * $Id:  OrderStatements.java 2016-03-26 13:36:18 $
 */



package cn.thinkjoy.zgk.market.domain;

import cn.thinkjoy.common.domain.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class OrderStatements extends BaseDomain{
    private String orderNo;
    private String statementNo;
    private Long createDate;
    private Long updateDate;
    private Long createrId;
    private Integer status;
    private String state;
    private Double amount;

	public OrderStatements(){
	}
    public void setOrderNo(String value) {
        this.orderNo = value;
    }

    public String getOrderNo() {
        return this.orderNo;
    }
    public void setStatementNo(String value) {
        this.statementNo = value;
    }

    public String getStatementNo() {
        return this.statementNo;
    }
    public void setCreateDate(Long value) {
        this.createDate = value;
    }

    public Long getCreateDate() {
        return this.createDate;
    }
    public void setUpdateDate(Long value) {
        this.updateDate = value;
    }

    public Long getUpdateDate() {
        return this.updateDate;
    }
    public void setCreaterId(Long value) {
        this.createrId = value;
    }

    public Long getCreaterId() {
        return this.createrId;
    }
    public void setState(String value) {
        this.state = value;
    }

    public String getState() {
        return this.state;
    }
    public void setAmount(Double value) {
        this.amount = value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getAmount() {
        return this.amount;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("OrderNo",getOrderNo())
			.append("StatementNo",getStatementNo())
			.append("Status",getStatus())
			.append("CreateDate",getCreateDate())
			.append("UpdateDate",getUpdateDate())
			.append("CreaterId",getCreaterId())
			.append("State",getState())
			.append("Amount",getAmount())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof OrderStatements == false) return false;
		if(this == obj) return true;
		OrderStatements other = (OrderStatements)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

