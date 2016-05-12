package com.test.java.tools;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static final int DAY = 24*3600*1000;
	public static final int HOUR = 3600*1000;
	public static final int MINUTES = 60*1000;
	public static final int SECONDS = 1000;
	/**
	 * ʱ��ļ��
	 * @param before
	 * @param after
	 */
	public static String convertTime(Date before,Date after){
		String value = "";
		Calendar instanceBefore = Calendar.getInstance();
		instanceBefore.setTime(before);
		Calendar instanceAfter = Calendar.getInstance();
		instanceAfter.setTime(after);
		long time = instanceAfter.getTimeInMillis()-instanceBefore.getTimeInMillis();
		if(time>DAY){
			value = value+time/DAY+"��";
			time = time%DAY;
		}
		if(time>HOUR){
			value = value+time/HOUR+"Сʱ";
			time = time%HOUR;
		}
		if(time>MINUTES){
			value = value+time/MINUTES+"����";
			time = time%MINUTES;
		}
		if(time>SECONDS){
			value = value+time/SECONDS+"��";
			time = time%SECONDS;
		}
		return value;
	}
}
