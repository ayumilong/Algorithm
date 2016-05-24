/**
 * File Name: ValidParentheses.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:31:03 PM May 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:31:03 PM May 4, 2016
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0){
            return false;
        }
        Stack<Character> left = new Stack<>();
        HashMap<Character, Character> parens = new HashMap<>();
        parens.put('(', ')');
        parens.put('[', ']');
        parens.put('{', '}');
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(parens.containsKey(c)){
                left.push(c);
            }else{
                if(left.isEmpty() || parens.get(left.pop()) != c){
                    return false;
                }
            }
        }
        return left.isEmpty();
    }
	
    public boolean isValid1(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        Stack<Character> left = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            switch(c){
                case '(':
                case '[':
                case '{':
                    left.push(c);
                    break;
                case ')':
                    if(left.isEmpty() || left.peek() != '('){
                        return false;
                    }
                    left.pop();
                    break;
                case ']':
                    if(left.isEmpty() || left.peek() != '['){
                        return false;
                    }
                    left.pop();
                    break;
                case '}':
                    if(left.isEmpty() || left.peek() != '{'){
                        return false;
                    }
                    left.pop();
                    break;
                default:
                    return false;
            }
        }
        return left.isEmpty();
    }
}
