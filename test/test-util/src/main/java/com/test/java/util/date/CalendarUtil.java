package com.test.java.util.date;

import java.util.Calendar;
import java.util.Date;
/**
 * 日期加减工具操作类
 * @author micheal
 *
 */
public class CalendarUtil {
	/**
	 * 日期相加减
	 * @param days >0表示日期相加，<0表示日期相减
	 * @return
	 */
	public static Date addOrsubtractDays(int days){
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		instance.add(Calendar.DATE, days);
		return instance.getTime();
	}
	/**
	 * 日期相加减
	 * @param days >0表示月份相加，<0表示月份相减
	 * @return
	 */
	public static Date addOrsubtractMonth(int days){
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		instance.add(Calendar.MONTH, days);
		return instance.getTime();
	}
}
