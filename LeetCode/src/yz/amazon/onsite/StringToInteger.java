/**
 * File Name: StringToInteger.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:05:18 PM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

/**
 * @author Yaolin Zhang
 * @time 8:05:18 PM Apr 14, 2016
 */
public class StringToInteger {
	public int myAtoi(String str) {
		str = str.trim();
		char[] cs = str.toCharArray();
		if (cs.length == 0) {
			return 0;
		}
		int start = 0;
		int sign = 1;
		if (cs[0] == '-' || cs[0] == '+') {
			sign = (cs[0] == '-') ? -1 : 1;
			++start;
		}
		int val = 0;
		boolean overflow = false;
		for (int i = start; i < cs.length; ++i) {
			if (cs[i] >= '0' && cs[i] <= '9') {
				if (val > (Integer.MAX_VALUE - (cs[i] - '0')) / 10) {// Overflow
					overflow = true;
					val = Integer.MAX_VALUE;
					break;
				}
				val = val * 10 + (cs[i] - '0');
			} else {
				break;
			}
		}
		return sign == -1 ? (overflow ? Integer.MIN_VALUE : -val) : val;
	}
}
