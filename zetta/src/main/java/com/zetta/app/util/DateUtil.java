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
