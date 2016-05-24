/**
 * File Name: WeekdayOfADate.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:57:14 PM Apr 19, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 8:57:14 PM Apr 19, 2016
 */
public class WeekdayOfADate {
	public static void main(String args[]) throws Exception{
		Scanner scan = new Scanner(System.in);
		WeekdayOfADate wo = new WeekdayOfADate();
		int year1 = scan.nextInt();
		int month1 = scan.nextInt();
		int day1 = scan.nextInt();
		int year2 = scan.nextInt();
		int month2 = scan.nextInt();
		int day2 = scan.nextInt();
		int day = scan.nextInt();
		System.out.println(wo.findWeekday(year1, month1, day1, day, year2, month2, day2));
		scan.close();
	}
	// y1, m1 and d1 represent a date including year, month and day
	// "day" is the weekday of this date
	// Output the weekday of date represent by y2, m2 and d2
	// Leap year: (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)
	public int findWeekday(int year1, int month1, int day1, int day, int year2, int month2, int day2) throws Exception {
		if (year1 < year2) {
			int days = DaysBetween.DaysBetweenTwoDates(year1, month1, day1, year2, month2, day2);
			return (day + days) % 7;
		}else{
			int days = DaysBetween.DaysBetweenTwoDates(year2, month2, day2, year1, month1, day1);
			return (days - day) % 7;
		}
	}
}
