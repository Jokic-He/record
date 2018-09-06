package com.sunwin.sys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class EmptyUtils {
	
	/**
	 * @author: 李正�?
	 * @date: 2016�?12�?3�?
	 * @version: 1.0
	 * @description:�?查字符串是否为空,不为空返回true,否则返回false
	 */
	public static boolean checkStrNotNull(String str){
		if(str != null && !"null".equals(str) && !"".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	/**
	 * @author: 李正�?
	 * @date: 2016�?12�?3�?
	 * @version: 1.0
	 * @description: �?查字List集合是否为空,不为空返回true,否则返回false
	 */
	public static boolean checkListNotNull(List<?> list){
		if(null != list && list.size() > 0 && !list.isEmpty()){
			return true;
		}
		return false;
	}

	/**
	 * @author: 李正�?
	 * @date: 2016�?12�?3�?
	 * @version: 1.0
	 * @description: �?查字Set集合是否为空,不为空返回true,否则返回false
	 */
	public static boolean checkSetNotNull(Set<?> set){
		if(null != set && set.size() > 0 && !set.isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * @author: 李正�?
	 * @date: 2017�?6�?19�?
	 * @version: 1.0
	 * @description: 格式化日期为指定类型的字符串
	 */
	public static String formatDate(Date date , String formtter) {
		date = date == null ? new Date() : date;
		formtter = formtter == null || "".equals(formtter.trim()) ? "yyyy-MM-dd HH:mm:ss" : formtter;
		SimpleDateFormat sdf = new SimpleDateFormat(formtter);
		return sdf.format(date);
	}
	
}
