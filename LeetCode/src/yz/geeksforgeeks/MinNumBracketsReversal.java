/**
 * File Name: MinNumBracketsReversal.java
 * Package Name: yz.geeksforgeeks
 * Project Name: LeetCode
 * Purpose: http://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
 * Created Time: 7:22:13 PM Oct 29, 2015
 * Author: Yaolin Zhang
 */
package yz.geeksforgeeks;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:22:13 PM Oct 29, 2015
 */
public class MinNumBracketsReversal {
	public int reverseBrackets(String brackets){
		int len = brackets.length();
		int result = 0;
		if(len % 2 == 0){
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < len; ++i){
				char c = brackets.charAt(i);
				switch(c){
				case '{':
					stack.push(c);
					break;
				case '}':
					if(!stack.isEmpty()){
						stack.pop();
					}else{
						++result;
						stack.push('{');
					}
					break;
				default:
						return -1;
				}
			}
			return result + stack.size() / 2;
		}
		
		return -1;
	}
}
