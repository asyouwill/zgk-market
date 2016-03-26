package cn.thinkjoy.gk.interceptor;

import cn.thinkjoy.common.exception.BizException;
import cn.thinkjoy.gk.constant.CookieConst;
import cn.thinkjoy.gk.constant.UserRedisConst;
import cn.thinkjoy.gk.constant.ServletPathConst;
import cn.thinkjoy.gk.util.CookieUtil;
import cn.thinkjoy.gk.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER= LoggerFactory.getLogger(LoginInterceptor.class);

	public LoginInterceptor() { }


    @Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String url = request.getServletPath();
		if(!ServletPathConst.MAPPING_URLS.contains(url)){
			return true;
		}
//		System.out.println("===========HandlerInterceptor1 preHandle");

		LOGGER.info("url:"+url);

		String value = CookieUtil.getCookieValue(request);

		LOGGER.info("cookie:"+value);
//		RedisUtil.getInstance().del(key);
		String key = UserRedisConst.USER_KEY+value;

		boolean redisFlag = RedisUtil.getInstance().exists(key);

		LOGGER.info("redis is exists:"+ redisFlag);

		if (StringUtils.isEmpty(value)||!redisFlag) {
//			request.getRequestDispatcher().forward(request, response);
			throw new BizException("1000004","请先登录后再进行操作");
		}

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
