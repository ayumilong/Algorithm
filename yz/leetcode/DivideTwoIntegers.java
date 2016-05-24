/**
 * File Name: DivideTwoIntegers.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:49:04 PM Jan 7, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:49:04 PM Jan 7, 2016
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		if (divisor == 1) {
			return dividend;
		}
		int result = 0;
		boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		long divid = Math.abs((long) dividend);
		long divis = Math.abs((long) divisor);
		for(int i = 30; i >= 0; --i){//30 only for -2147483648, which is 32 ones
			if((divis << i) <= divid){
				result |= (1 << i);
				divid -= (divis << i);
			}
		}

		return negative ? -result : result;
	}

	public int divide1(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		if (divisor == 1) {
			return dividend;
		}
		int result = 0;
		boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		long divid = Math.abs((long) dividend);
		long divis = Math.abs((long) divisor);
		while (divid >= divis) {
			for (long i = divis, cnt = 1; divid >= i; i <<= 1, cnt <<= 1) {
				divid -= i;
				result += cnt;
			}
		}

		return negative ? -result : result;
	}
}
