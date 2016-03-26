package cn.thinkjoy.gk.enumerate;

/**
 * Created by clei on 15/1/29.
 */
public enum PatternEnum {
    /**
     * 手机正则
     */
    PHONE("/^13[0-9]{9}$|14[0-9]{9}$|13[0-9]{9}$|17[0-9]{9}$|15[0-9]{9}$|18[0-9]{9}$|17[0-9]{9}$/"),
    /**
     * 邮箱
     */
    MAIL("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"),
    /**
     * HTTP网址
     */
    HTTP("http://(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*");

    private String value;

    PatternEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
