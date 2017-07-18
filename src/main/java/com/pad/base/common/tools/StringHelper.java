package com.pad.base.common.tools;

/**
 * 字符串处理
 * @author YF
 */
public class StringHelper {
	
	public static String replaceNull(String from){
		return (from==null || "".equals(from))?"":from;
	}
	
	public static String replaceNull(String from,String to){
		return (from==null || "".equals(from))?to:from;
	}
	
	/**
	 * 判断一个字符串是否不为null或""，如果为null或空则返回false，反之true
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str){
		boolean isnotnull = false;
		if(str != null && !"".equals(str.trim()))
		{
			isnotnull = true;
		}
		return isnotnull;
	}
}
