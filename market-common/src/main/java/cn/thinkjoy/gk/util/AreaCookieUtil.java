package cn.thinkjoy.gk.util;

import cn.thinkjoy.gk.constant.DomainConst;
import javax.servlet.http.HttpServletRequest;


public class AreaCookieUtil {

	public static String getAreaCookieValue(HttpServletRequest request){
		String domainValue = DomainUtil.getDomainValue(request);

		if(domainValue.equals(DomainConst.SN_DOMAIN)){
			return DomainConst.SN_DOMAIN_CODE;
		} else if(domainValue.equals(DomainConst.HN_DOMAIN)){
			return DomainConst.HN_DOMAIN_CODE;
		} else if(domainValue.equals(DomainConst.GX_DOMAIN)){
			return DomainConst.GX_DOMAIN_CODE;
		} else if(domainValue.equals(DomainConst.HA_DOMAIN)){
			return DomainConst.HA_DOMAIN_CODE;
		}
		return null;
	}

}
