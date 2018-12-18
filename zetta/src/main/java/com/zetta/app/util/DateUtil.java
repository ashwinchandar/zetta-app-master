package com.zetta.app.util;
 
import java.text.SimpleDateFormat;
import java.util.Date;  

public class DateUtil {

	public static Date getDateFromString(String incomingDate) { 
		Date date=null;
		try { 
			if(incomingDate!=null && !incomingDate.trim().isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				date=sdf.parse(incomingDate.trim());
				System.out.println(date);	 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date;
		  
	}
}

/*public class TimeUtil {

	private static Long second = 1000L;
	private static Long minute = 60 * second;
	private static Long hour = 60 * minute;
	private static Long day = 24 * hour;
	private static Long year = 365 * day;

	public static String numDaysAgo(Timestamp timestamp) {
		Long diffMills = System.currentTimeMillis() - timestamp.getTime();
		if (year > diffMills && diffMills > day) {
			int daysDiff = (int) (diffMills / day);
			return daysDiff + " 天前";
		} else if (day > diffMills && diffMills > hour) {
			int hoursDiff = (int) (diffMills / hour);
			return hoursDiff + " 小时前";
		} else if (hour > diffMills && diffMills > minute) {
			int minutesDiff = (int) (diffMills / minute);
			return minutesDiff + " 分钟前";
		} else if (minute > diffMills && diffMills > second) {
			int secondsDiff = (int) (diffMills / second);
			return secondsDiff + " 秒前";
		} else if (second > diffMills) {
			return "刚才";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date(timestamp.getTime());
		return simpleDateFormat.format(date);
	}

	public static String dateFormat(Timestamp timestamp) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date(timestamp.getTime());
		return simpleDateFormat.format(date);
	}

}*/