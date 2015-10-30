/**
 * File Name: BasicCalculator.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:47:26 PM Oct 17, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 9:47:26 PM Oct 17, 2015
 */
public class BasicCalculator {
	// Assume s is a valid expression
	public int calculate(String s) {
		Stack<Integer> operators = new Stack<>();
		int len = s.length();
		int curNum = 0;
		int result = 0;
		int sign = 1;
		operators.push(sign); //Special case to normal case.     1-(2-3)  -> +(1-(2-3)) -> 1 - 2 + 3
		for (int i = 0; i < len; ++i) {
			switch (s.charAt(i)) {
			case ' ':
				break;
			case '(':
				operators.push(sign);
				break;
			case ')':
				operators.pop();
				break;
			case '+':
			case '-':
				result += curNum * sign;
				curNum = 0;
				sign = s.charAt(i) == '-' ? operators.peek() * -1 : operators.peek();
				break;
			default:
				curNum = curNum * 10 + s.charAt(i) - '0';
				break;
			}
		}
		return result + curNum * sign;
	}
}
