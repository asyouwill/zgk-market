package cn.thinkjoy.gk.filter;

import cn.thinkjoy.gk.constant.ServletPathConst;
import cn.thinkjoy.gk.constant.UserRedisConst;
import cn.thinkjoy.gk.util.CookieUtil;
import cn.thinkjoy.gk.util.RedisUtil;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by clei on 15/10/22.
 */
public class LoginFilter implements Filter {

    private FilterConfig filterConfig;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponse hresponse = (HttpServletResponse) response;

        String url = hrequest.getServletPath();
        if(!ServletPathConst.JSP_URLS.contains(url)){
            chain.doFilter(request, response);
        }else {

            String value = CookieUtil.getCookieValue(hrequest);

            String key = UserRedisConst.USER_KEY + value;

            boolean redisFlag = RedisUtil.getInstance().exists(key);

            if (StringUtils.isEmpty(value) || !redisFlag) {
//			request.getRequestDispatcher().forward(request, response);
                hresponse.sendRedirect("/login/login.jsp");
//            throw new BizException("1000004","请先登录后再进行操作");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
