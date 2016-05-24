/**
 * File Name: ReformatDate.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:27:46 PM May 3, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yaolin Zhang
 * @time 9:27:46 PM May 3, 2016
 */
public class ReformatDate {
	public static void main(String[] args) throws ParseException{
		String[] dates = {"3rd Oct 2016", "31th Jan 2052", "30th April 2009", "1st January 2011"};
		String[] newDates = formatDate1(dates);
		for(String date : newDates){
			System.out.println(date);
		}
	}
	
	public static String[] formatDate1(String[] dates){
		String[] newDates = new String[dates.length];
		SimpleDateFormat dstFormatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sourceFormatter = new SimpleDateFormat("dd MMM yyyy");
		for(int i = 0; i < dates.length; ++i){
			String curDate = dates[i].replaceFirst("st|nd|rd|th", "");
			newDates[i] = dstFormatter.format(sourceFormatter.parse(curDate, new ParsePosition(0)));
		}
		return newDates;
	}
	
	public static String[] formatDate(String[] dates){
		String[] newDates = new String[dates.length];
		String[] patterns = {"dd'st' MMM yyyy","dd'nd' MMM yyyy","dd'rd' MMM yyyy","dd'th' MMM yyyy"};
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0; i < dates.length; ++i){
			ParsePosition position = new ParsePosition(0);
			for(String pattern : patterns){
				SimpleDateFormat curFormat = new SimpleDateFormat(pattern);
				Date cur = curFormat.parse(dates[i], position);
				if(cur != null){
					newDates[i] = formatter.format(cur);
					break;
				}
			}
		}
		return newDates;
	}
}
