/**
 * File Name: BasicCalculatorII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 12:20:46 AM Sep 16, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.Stack;

/**
 * @author Yaolin Zhang
 * @time 12:20:46 AM Sep 16, 2015
 */
public class BasicCalculatorII {
	private int getNextInt(String s, int start, int len) {
		while (start < len && Character.isDigit(s.charAt(start))) {
			++start;
		}
		return start;
	}
	public int calculate(String s){
		s = s.trim();
		int len = s.length();
		int startPos = 0;
		int endPos = getNextInt(s, startPos, len);
		int preNum1 = Integer.parseInt(s.substring(startPos, endPos));
		startPos = endPos;
		char preOp = '?';
		int preNum2 = 0;
		while(startPos < len){
			while(s.charAt(startPos) == ' '){
				++startPos;
			}
			char curOp = s.charAt(startPos);
			switch(curOp){
			case '*':
			case '/':
				++startPos;
				while(s.charAt(startPos) == ' '){
					++startPos;
				}
				endPos = getNextInt(s, startPos, len);
				int curNum = Integer.parseInt(s.substring(startPos, endPos));
				startPos = endPos;
				if(preOp == '?'){
					preNum1 = curOp == '*' ? preNum1 * curNum : preNum1 / curNum;
				}else{
					preNum2 = curOp == '*' ? preNum2 * curNum : preNum2 / curNum;
				}
				break;
			case '+':
			case '-':
				++startPos;
				while(s.charAt(startPos) == ' '){
					++startPos;
				}
				if(preOp != '?'){
					preNum1 = preOp == '+' ? preNum1 + preNum2 : preNum1 - preNum2;
				}
				preOp = curOp;
				endPos = getNextInt(s, startPos, len);
				preNum2 = Integer.parseInt(s.substring(startPos, endPos));
				startPos = endPos;
				break;
			}
		}
		switch(preOp){
		case '+':
		case '-':
			preNum1 = preOp == '+' ? preNum1 + preNum2 : preNum1 - preNum2;
			break;
		}
		return preNum1;
	}

	public int calculate1(String s) {
		int len = s.length();
		Stack<Integer> numbers = new Stack<>();
		Stack<Character> operators = new Stack<>();
		int endPos = 0;
		for (int i = 0; i < len; ++i) {
			while (i < len && s.charAt(i) == ' ') {
				++i;
			}
			if (i == len) {
				break;
			}
			switch (s.charAt(i)) {
			case '+':
			case '-':
				if (numbers.size() >= 2) {
					int a = numbers.pop();
					int b = numbers.pop();
					numbers.push(operators.pop() == '+' ? a + b : b - a);
				}
				operators.push(s.charAt(i));
				break;
			case '*':
			case '/':
				char op = s.charAt(i);
				++i;
				while (i < len && s.charAt(i) == ' ') {
					++i;
				}
				endPos = getNextInt(s, i, len);
				int b = Integer.parseInt(s.substring(i, endPos));
				i = endPos - 1;
				numbers.push(op == '*' ? numbers.pop() * b : numbers.pop() / b);
				break;
			default:
				endPos = getNextInt(s, i, len);
				numbers.push(Integer.parseInt(s.substring(i, endPos)));
				i = endPos - 1;
				break;
			}
		}
		while (!operators.isEmpty()) {
			switch (operators.pop()) {
			case '+':
				numbers.push(numbers.pop() + numbers.pop());
				break;
			case '-':
				numbers.push(-(numbers.pop() - numbers.pop()));
				break;
			}
		}
		return numbers.pop();
	}
}
