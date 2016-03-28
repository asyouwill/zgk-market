package cn.thinkjoy.zgk.market.common;


import cn.thinkjoy.zgk.market.pojo.UserAccountPojo;

/**
 * 用户上下文
 * <p/>
 * 创建时间: 14-9-1 下午11:21<br/>
 *
 * @author qyang
 * @since v0.0.1
 * @author Michael
 * @since v0.0.10
 */
public class UserContext {
    private static ThreadLocal<UserAccountPojo> context = new ThreadLocal<UserAccountPojo>();

    public static UserAccountPojo getCurrentUser(){
        return context.get();
    }

    public static void setCurrentUser(UserAccountPojo user){
        context.set(user);
    }
}
