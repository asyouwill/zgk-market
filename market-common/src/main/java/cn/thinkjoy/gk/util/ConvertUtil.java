package cn.thinkjoy.gk.util;

import org.springframework.util.StringUtils;


public class ConvertUtil {
	
	/**
	 * 字符串转换整型
	 */
	public static Integer stringToInteger(String param) throws Exception{
		if(!StringUtils.isEmpty(param)){
			return Integer.parseInt(param);
		}
		return null;
	}
	
	/**
	 * 整型转换字符
	 */
	public static String integerToString(Integer param) throws Exception{
		return String.valueOf(param);
	}
	
	/**
	 * LONG转换整型
	 */
	public static Integer longToInteger(long param) throws Exception{
		if(!StringUtils.isEmpty(String.valueOf(param))){
			return Integer.parseInt(String.valueOf(param));
		}
		return null;
	}
}
