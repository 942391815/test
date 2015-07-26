package com.test.java.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String formatDate(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try{
			return sdf.format(date);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static String formatNowDate(String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try{
			return sdf.format(new Date());
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public static Date stringConvertDate(String date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try{
			return sdf.parse(date);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
