/*
 * Copyright (c) 2013-2014, thinkjoy Inc. All Rights Reserved.
 *
 * Project Name: shishuo
 * $Id:  UserExam.java 2015-10-23 14:44:11 $
 */



package cn.thinkjoy.zgk.market.domain;

import cn.thinkjoy.common.domain.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserExam extends BaseDomain {
    private Integer scores;
    private Integer ranking;
    private Integer isSurvey;
    private Integer isReported;

	public UserExam(){
	}
    public void setScores(Integer value) {
        this.scores = value;
    }

    public Integer getScores() {
        return this.scores;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public void setIsSurvey(Integer value) {
        this.isSurvey = value;
    }

    public Integer getIsSurvey() {
        return this.isSurvey;
    }
    public void setIsReported(Integer value) {
        this.isReported = value;
    }

    public Integer getIsReported() {
        return this.isReported;
    }

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Scores",getScores())
			.append("IsSurvey",getIsSurvey())
			.append("IsReported",getIsReported())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserExam == false) return false;
		if(this == obj) return true;
		UserExam other = (UserExam)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

