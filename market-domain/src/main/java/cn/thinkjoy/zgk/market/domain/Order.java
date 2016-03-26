/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: market
 * $Id:  Order.java 2016-03-26 13:36:17 $
 */



package cn.thinkjoy.zgk.market.domain;

import cn.thinkjoy.common.domain.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Order extends BaseDomain{
    private Integer userId;
    private Long productId;
    private String orderNo;
    private Integer channle;
    private Integer status;
    private Long createDate;
    private Long updateDate;
    private String state;
    private Double amount;
    private Integer productNumber;
    private Double productPrice;

	public Order(){
	}
    public void setUserId(Integer value) {
        this.userId = value;
    }

    public Integer getUserId() {
        return this.userId;
    }
    public void setProductId(Long value) {
        this.productId = value;
    }

    public Long getProductId() {
        return this.productId;
    }
    public void setOrderNo(String value) {
        this.orderNo = value;
    }

    public String getOrderNo() {
        return this.orderNo;
    }
    public void setChannle(Integer value) {
        this.channle = value;
    }

    public Integer getChannle() {
        return this.channle;
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
    public void setState(String value) {
        this.state = value;
    }

    public String getState() {
        return this.state;
    }
    public void setAmount(Double value) {
        this.amount = value;
    }

    public Double getAmount() {
        return this.amount;
    }
    public void setProductNumber(Integer value) {
        this.productNumber = value;
    }

    public Integer getProductNumber() {
        return this.productNumber;
    }
    public void setProductPrice(Double value) {
        this.productPrice = value;
    }

    public Double getProductPrice() {
        return this.productPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("ProductId",getProductId())
			.append("Status",getStatus())
			.append("OrderNo",getOrderNo())
			.append("Channle",getChannle())
			.append("CreateDate",getCreateDate())
			.append("UpdateDate",getUpdateDate())
			.append("State",getState())
			.append("Amount",getAmount())
			.append("ProductNumber",getProductNumber())
			.append("ProductPrice",getProductPrice())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Order == false) return false;
		if(this == obj) return true;
		Order other = (Order)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

