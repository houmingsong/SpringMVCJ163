package com.lovo.mvc.util;

import java.sql.Date;

/**
 * 日期转换类
 * @author Administrator
 *
 */
public class DateChange {
	/**
	 * 将字符串转换为日期类型
	 * @param str 字符串
	 * @return 日期类型
	 */
	public static Date getDate(String str){
		if(str != null && str.matches("\\d{4}-\\d{2}-\\d{2}")){
			return Date.valueOf(str);
		}
		
		return null;
	}
}
