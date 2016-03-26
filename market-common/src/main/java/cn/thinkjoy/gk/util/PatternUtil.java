package cn.thinkjoy.gk.util;


import cn.thinkjoy.gk.enumerate.PatternEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {
	
    /** 
     * @param patternEnum 正则表达式字符串
     * @param str   要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    public static boolean match(String str, PatternEnum patternEnum){
        Pattern pattern = Pattern.compile(patternEnum.getValue());
        Matcher  matcher = pattern.matcher( str );
        return matcher.matches();
    }
}
