package com.test.java.date.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期操作工具类
 * @author micheal
 *
 */
public class DateUtil {
	/**
	 * 日期转换为指定的类型
	 * @param date
	 * @param pattern example yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public static String formatDate(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try{
			return sdf.format(date);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 日期转换为指定的类型
	 * @param date
	 * @param pattern example yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public static String formatNowDate(String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try{
			return sdf.format(new Date());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 日期字符串转换为日期
	 * @param date
	 * @param pattern example yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public static Date stringConvertDate(String date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try{
			return sdf.parse(date);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 日期比较大小方法
	 * @param date
	 * @param date
	 * @return
	 */
	public boolean isBig(Date one, Date two){
		if(one==null || two==null){
			throw new RuntimeException("日期比较不能为空!");
		}
		return one.getTime()>two.getTime();
	}
}
