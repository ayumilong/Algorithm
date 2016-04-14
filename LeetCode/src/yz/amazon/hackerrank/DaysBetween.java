/**
 * File Name: DaysBetween.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:51:24 PM Apr 4, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:51:24 PM Apr 4, 2016
 */
public class DaysBetween {
	public static void main(String args[]) throws Exception{
		Scanner scan = new Scanner(System.in);
		int year1 = scan.nextInt();
		int month1 = scan.nextInt();
		int day1 = scan.nextInt();
		int year2 = scan.nextInt();
		int month2 = scan.nextInt();
		int day2 = scan.nextInt();
		
		System.out.println(DaysBetweenTwoDates(year1, month1, day1, year2, month2, day2));
		
		scan.close();
	}
	
    static int DaysBetweenTwoDates(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {
        int days = 0;
        if(year1 == year2){
            if(month1 == month2){
                return day2 - day1;
            }else{
                for(int i = month1 + 1; i < month2; ++i){
                    days += DaysInMonth(i, year1);
                }
                days += (DaysInMonth(month1, year1) - day1) + day2;
                return days;
            }
        }else{
            days += DaysInYear(year1, month1 + 1, 12) + DaysInMonth(month1, year1) - day1;
            int count = leapYearCount(year1 + 1, year2 - 1);
            days += (365 * (year2 - year1 - 1)) + count;
            days += DaysInYear(year2, 1, month2 - 1) + day2;
            return days;
        }

    }
    
    static int leapYearCount(int startYear, int endYear){
    		int count = 0;
    		for(int year = startYear; year <= endYear; ++year){
    			if((year % 4 ==0 && year % 100 != 0) || year % 400 == 0){
    				++count;
    			}
    		}
    		return count;
    }

    static int DaysInYear(int year, int startMonth, int endMonth) throws Exception{
        int days = 0;
        for(int i = startMonth; i <= endMonth; ++i){
            days += DaysInMonth(i, year);
        }
        return days;
    }

    // Do not edit below this line. It is only shown so you can see the function signature.
    // The implementation of the function is hidden.
    // Month should be in 1 and 12
    static int DaysInMonth(int month, int year) throws Exception {
    		if(month < 1 || month > 12 || year < 0){
    			return 0;
    		}
    		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    		if(((year % 4 ==0 && year % 100 != 0) || year % 400 == 0) && month == 2){
    			return 29;
    		}
    		return months[month - 1];
    }
}
