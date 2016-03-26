package cn.thinkjoy.gk.common;

import cn.thinkjoy.gk.util.CookieUtil;
import cn.thinkjoy.gk.util.DomainUtil;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseCommonController {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

//	protected HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

//	protected HttpServletResponse response =  ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();

	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
							 HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	public String getDomainValue(){
		return DomainUtil.getDomainValue(request);
	}

	public String getCookieValue(){
		return CookieUtil.getCookieValue(request);
	}

	public String getCookieName(){
		return CookieUtil.getCookieName(request);
	}

}