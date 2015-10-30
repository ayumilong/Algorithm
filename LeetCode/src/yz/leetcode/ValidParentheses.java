/**
 * File Name: ValidParentheses.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:44:39 PM Oct 15, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:44:39 PM Oct 15, 2015
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null) {
			return true;
		}
		int len = s.length();
		if (len % 2 != 0) {
			return false;
		}

		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> parentheses = new HashMap<>();
		parentheses.put('(', ')');
		parentheses.put('[', ']');
		parentheses.put('{', '}');

		for (int i = 0; i < len; ++i) {
			char c = s.charAt(i);
			if(parentheses.containsKey(c)){
				stack.push(c);
			}else{
				if(stack.empty() || parentheses.get(stack.pop()) != c){
					return false;
				}
			}
		}
		return stack.empty();
	}
}
