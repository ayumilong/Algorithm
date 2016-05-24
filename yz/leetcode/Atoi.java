/**
 * File Name: atoi.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:38:10 PM Aug 26, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 8:38:10 PM Aug 26, 2015
 */
public class Atoi {
	public int myAtoi1(String str) {
		str = str.trim();
		int sign = 1;// whether + or -
		int decimalAsw = 0;
		if(str.length() == 0){
			return 0;
		}
		int i = 0; // start from str[i]
		if (str.charAt(0) == '+') {
			sign = 1;
			i = 1;
		} else if (str.charAt(0) == '-') {
			sign = -1;
			i = 1;
		}
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

			if ((decimalAsw > 214748364 || (decimalAsw == 214748364 && str.charAt(i) > '7'))) {
				if (sign == -1) {
					return Integer.MIN_VALUE;
				} else{
					return Integer.MAX_VALUE;
				}
			}
			decimalAsw = (str.charAt(i) - '0') + decimalAsw * 10;
			++i;
		}
		return decimalAsw * sign;
	}

	public int myAtoi(String str) {
		str = str.trim();
		int number = 0;
		boolean overflow = false;
		int len = str.length();
		if (len == 0) {
			return 0;
		}
		// Deal with '-' or '+'
		int sign = 1;
		int i = 0;
		if (str.charAt(0) == '-') {
			sign = -1;
			i = 1;
		} else if (str.charAt(0) == '+') {
			sign = 1;
			i = 1;
		}

		for (; i < len; ++i) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				break;
			}
			if(number >= 214748364){
                if(number > 214748364 || str.charAt(i) >= '8'){//Overflow
                    overflow = true;
                    break;
                }
            }
			number = number * 10 + str.charAt(i) - '0';
		}
		// Deal with overflow
		if (overflow) {
			return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		return number * sign;
	}
}
