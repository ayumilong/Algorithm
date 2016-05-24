/**
 * File Name: RomanToInteger.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 6:29:29 PM May 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 6:29:29 PM May 4, 2016
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> charToInt = new HashMap<>();
        charToInt.put('M', 1000);
        charToInt.put('D', 500);
        charToInt.put('C', 100);
        charToInt.put('L', 50);
        charToInt.put('X', 10);
        charToInt.put('V', 5);
        charToInt.put('I', 1);
        int preNum = 0;
        int result = 0;
        for(int i = 0; i < s.length(); ++i){
            int curNum = charToInt.get(s.charAt(i));
            if(preNum < curNum){
                result = result - preNum * 2 + curNum;
            }else{
                result += curNum;
            }
            preNum = curNum;
        }
		return result;
    }
    
    public int romanToInt1(String s) {
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
