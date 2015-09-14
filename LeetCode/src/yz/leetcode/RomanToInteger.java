/**
 * File Name: RomanToInteger.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:16:26 PM Aug 28, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 7:16:26 PM Aug 28, 2015
 */
public class RomanToInteger {
	public int romanToInt(String s) {
        int len = s.length();
        int result = 0;
        for(int i = 0; i < len; ++i){
        		switch(s.charAt(i)){
        			case 'M':
        				result += 1000;
        				break;
        			case 'D':
        				result += 500;
        				break;
        			case 'C':
        				if(i + 1 < len && s.charAt(i + 1) == 'D'){
        					result += 400;
        					++i;
        				}else if(i + 1 < len && s.charAt(i + 1) == 'M'){
        					result += 900;
        					++i;
        				}else{
        					result += 100;
        				}
        				break;
        			case 'L':
        				result += 50;
        				break;
        			case 'X':
        				if(i + 1 < len && s.charAt(i + 1) == 'L'){
        					result += 40;
        					++i;
        				}else if(i + 1 < len && s.charAt(i + 1) == 'C'){
        					result += 90;
        					++i;
        				}else{
        					result += 10;
        				}
        				break;
        			case 'V':
        				result += 5;
        				break;
        			case 'I':
        					if(i + 1 < len && s.charAt(i + 1) == 'V'){
        						result += 4;
        						++i;
        					}else if(i + 1 < len && s.charAt(i + 1) == 'X'){
        						result += 9;
        						++i;
        					}else{
        						result += 1;
        					}
        				break;
        		}
        }
		return result;
    }
}
