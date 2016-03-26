package cn.thinkjoy.gk.util;

import cn.thinkjoy.gk.constant.CookieConst;
import cn.thinkjoy.gk.constant.DomainConst;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class CookieUtil {
	
	/**
	 * 生成cookie
	 * @param name cookie的名称
	 * @param value cookie的值
	 * @param expiry cookie的有效期
	 * @return
	 */
	public static final Cookie addCookie(String name, String value, int expiry){
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain("*");
		cookie.setPath("/");
		cookie.setMaxAge(expiry);
		return cookie;
	}

	/**
	 * 生成cookie
	 * @param name cookie的名称
	 * @param value cookie的值
	 * @param expiry cookie的有效期
	 * @return
	 */
	public static final Cookie addCookie(String domain, String name, String value, int expiry){
		Cookie cookie = new Cookie(name, value);
		if(!"*".equals(domain)) {
			cookie.setDomain(domain);
		}
		cookie.setPath("/");
		cookie.setMaxAge(expiry);
		return cookie;
	}

	/**
	 * 获取用户cookie信息
	 * 
	 * @return String
	 */
	public static String getCookieValue(Cookie[] cookies, String name) {
		String value = null;
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(name)) {
					value = cookies[i].getValue();
				}
			}
		}
		return value;
	}

	public static String getCookieValue(HttpServletRequest request){
		String domainValue = DomainUtil.getDomainValue(request);
		if(domainValue.equals(DomainConst.SN_DOMAIN)){
			return CookieUtil.getCookieValue(request.getCookies(), CookieConst.SN_USER_COOKIE_NAME);
		} else if(domainValue.equals(DomainConst.HN_DOMAIN)){
			return CookieUtil.getCookieValue(request.getCookies(), CookieConst.HN_USER_COOKIE_NAME);
		} else if(domainValue.equals(DomainConst.GX_DOMAIN)){
			return CookieUtil.getCookieValue(request.getCookies(), CookieConst.GX_USER_COOKIE_NAME);
		} else if(domainValue.equals(DomainConst.HA_DOMAIN)){
			return CookieUtil.getCookieValue(request.getCookies(), CookieConst.HA_USER_COOKIE_NAME);
		}
		return null;
	}

	public static String getCookieName(HttpServletRequest request){
		String domainValue = DomainUtil.getDomainValue(request);
		if(domainValue.equals(DomainConst.SN_DOMAIN)){
			return CookieConst.SN_USER_COOKIE_NAME;
		} else if(domainValue.equals(DomainConst.HN_DOMAIN)){
			return CookieConst.HN_USER_COOKIE_NAME;
		} else if(domainValue.equals(DomainConst.GX_DOMAIN)){
			return CookieConst.GX_USER_COOKIE_NAME;
		} else if(domainValue.equals(DomainConst.HA_DOMAIN)){
			return CookieConst.HA_USER_COOKIE_NAME;
		}
		return null;
	}

}
