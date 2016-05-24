/**
 * File Name: StringToInteger.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:53:00 PM Apr 30, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

/**
 * @author Yaolin Zhang
 * @time 10:53:00 PM Apr 30, 2016
 */
public class StringToInteger {
	private static int TEST = 3;
	
    public int myAtoi(String str) {
        if(str == null){
            return 0;
        }
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        int sign = 1;
        int start = 0;
        char first = str.charAt(0);
        if(first == '+' || first == '-'){
            start = 1;
            sign = first == '-' ? -1 : 1;
        }
        int num = 0;
        for(int i = start; i < str.length(); ++i){
            first = str.charAt(i);
            if(first < '0' || first > '9'){
                break;
            }
            if(num > Integer.MAX_VALUE / 10 || (num == 214748364 && (first - '0') > 7)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (first - '0');
        }
        return sign * num;
    }
}
