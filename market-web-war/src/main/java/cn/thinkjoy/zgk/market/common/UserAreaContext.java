package cn.thinkjoy.zgk.market.common;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 2016/1/7.
 */
@Component
public class UserAreaContext {


    private static ThreadLocal<String> context = new ThreadLocal<String>();

    public static String getCurrentUserArea(){
        return context.get();
    }

    public static void setCurrentUserArea(String area){
        //缓存记录
//        SessionCacheFactory.getInstance().put(user.getName(), user);
        context.set(area);
    }

    /**
     * 应该显示调用
     */
    public static void removeCurrentUseraArea() {
        context.remove();
    }
}
