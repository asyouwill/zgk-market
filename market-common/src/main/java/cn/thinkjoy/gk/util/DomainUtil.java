package cn.thinkjoy.gk.util;

import cn.thinkjoy.gk.constant.DomainConst;

import javax.servlet.http.HttpServletRequest;


public class DomainUtil {

	public static String getDomainValue(HttpServletRequest request){
		StringBuffer url = request.getRequestURL();
		if(url.indexOf(DomainConst.SN_DOMAIN)>-1){
			return DomainConst.SN_DOMAIN;
		} else if(url.indexOf(DomainConst.HN_DOMAIN)>-1){
			return DomainConst.HN_DOMAIN;
		} else if(url.indexOf(DomainConst.GX_DOMAIN)>-1){
			return DomainConst.GX_DOMAIN;
		} else if(url.indexOf(DomainConst.HA_DOMAIN)>-1){
			return DomainConst.HA_DOMAIN;
		} else {
			return DomainConst.SN_DOMAIN;
		}
	}

}
