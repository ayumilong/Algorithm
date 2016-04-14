/**
 * File Name: ValidateStatement.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:25:57 PM Apr 3, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 1:25:57 PM Apr 3, 2016
 */
public class ValidateStatement {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		scan.nextLine();
		ValidateStatement vs = new  ValidateStatement();
		for(int i = 0; i < cases; ++i){
			String statement = scan.nextLine();
			System.out.println(vs.isValid(statement));
		}
		scan.close();
	}
	
	public boolean isValid(String s){
		int len = s.length();
		Stack<Character> left = new Stack<>();
		for(int i = 0; i < len; ++i){
			char c = s.charAt(i);
			if(c == '(' || c == '['){
				left.add(c);
			}else if(c == ')'){
				if(left.isEmpty() || left.pop() != '('){
					return false;
				}
			}else if(c == ']'){
				if(left.isEmpty() || left.pop() != '['){
					return false;
				}
			}else if(c < '0' || c > '9'){
				return false;
			}
		}
		return left.isEmpty();
	}
}
