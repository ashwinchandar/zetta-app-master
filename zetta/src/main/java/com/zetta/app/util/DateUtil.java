package com.zetta.app.util;
 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;  

public class DateUtil {
	public static Date getDateFromString(String incomingDate) { 
		Date date=null;
		try { 
			if(incomingDate!=null && !incomingDate.trim().isEmpty()) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");  
				date=dateFormat.parse(incomingDate.trim());
				System.out.println(date);	 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date;
		  
	}
	
	public static String getDatetoString(String incomingDate) { 
		String date=null;
		try { 
			if(incomingDate!=null && !incomingDate.trim().isEmpty()) {
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm a");  
                date = dateFormat.format(getDateFromString(incomingDate));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date; 
	}
	
	 
	/*public static Date getDateFromString(String incomingDate) { 
		Date date=null;
		try { 
			if(incomingDate!=null && !incomingDate.trim().isEmpty()) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
				date=dateFormat.parse(incomingDate.trim());
				System.out.println(date);	 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date;
		  
	}
	public static String getDatetoString(String incomingDate) { 
		String date=null;
		try { 
			if(incomingDate!=null && !incomingDate.trim().isEmpty()) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd HH:mm");  
				Date dDate=dateFormat.parse(incomingDate); 
                date = dateFormat.format(dDate);
				System.out.println("datetostring: "+date);	 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date; 
	}*/
	
	
}

/*public class TimeUtil {
public static void main(String args[]) {
		System.out.println(getDatetoString("2018-12-20 12:48:49.558+05:30"));
	}
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