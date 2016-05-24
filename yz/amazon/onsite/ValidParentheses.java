/**
 * File Name: ValidParentheses.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:25:29 PM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:25:29 PM Apr 14, 2016
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if(s == null || s.length() % 2 != 0){
            return false;
        }
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> parentheses = new HashMap<>();
		parentheses.put('(', ')');
		parentheses.put('[', ']');
		parentheses.put('{', '}');

		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if(parentheses.containsKey(c)){
				stack.push(c);
			}else if(stack.empty() || parentheses.get(stack.pop()) != c){
			    return false;
			}
		}
		return stack.empty();
	}
	//Traditional way
    public boolean isValid1(String s) {
        if(s == null || s.length() % 2 != 0){
            return false;
        }
        Stack<Character> left = new Stack<>();
        HashMap<Character, Character> parens = new HashMap<>();
        parens.put('(', ')');
        parens.put('[', ']');
        parens.put('{', '}');
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            switch(c){
                case '(': case '[': case '{':
                    left.push(c);
                    break;
                case ')': case ']': case '}':
                    if(left.isEmpty() || parens.get(left.pop()).charValue() != c){
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return left.isEmpty();
    }
}
