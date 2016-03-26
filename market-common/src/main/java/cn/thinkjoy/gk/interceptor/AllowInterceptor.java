package cn.thinkjoy.gk.interceptor;

import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.gk.constant.AllowConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AllowInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER= LoggerFactory.getLogger(AllowInterceptor.class);

	public AllowInterceptor() { }


    @Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

		String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";

		LOGGER.info("当前访问url:"+url);

		if(!AllowConst.MAPPING_URLS.contains(url)){

			throw new BizException("1000001","非法操作!");
		}
		response.addHeader("Access-Control-Allow-Origin",url);

		response.addHeader("Access-Control-Allow-Headers","X-Requested-With");

		response.addHeader("Access-Control-Allow-Headers","GET,POST,OPTIONS");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
//		System.out.println("===========HandlerInterceptor1 postHandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("===========HandlerInterceptor1 afterCompletion");
	}

}
