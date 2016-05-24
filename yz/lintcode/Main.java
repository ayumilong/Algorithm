/**
 * File Name: Main.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:57:04 PM Jan 12, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


/**
 * @author Yaolin Zhang
 * @time 10:57:04 PM Jan 12, 2016
 */
public class Main {
	private static final char SS = 0x20;
	private static final int MA = 1;
	public static void main(String[] args){
		System.out.println(SS + MA + "=A");
		String s1 = "eat";
		String s2 = "tae";
		ScrambleString ss = new ScrambleString();
		ss.isScramble(s1, s2);
		System.out.println(Long.MAX_VALUE);
		StringBuffer sb = new StringBuffer();
	}
	
	   public static String add(String s1, String s2){
	        String result = "";
	        int carry = 0;
	        int index1 = s1.length() - 1;
	        int index2 = s2.length() - 1;
	        while(index1 >= 0 || index2 >= 0 || carry > 0){
	        		int cur = 0;
	            if(index1 >= 0){
	            		cur = s1.charAt(index1) - '0';
	            		--index1;
	            }
	            if(index2 >= 0){
	            		cur += s2.charAt(index2) - '0';
	            		--index2;
	            }
	            cur += carry;
	            carry = cur / 10;
	            result = (cur % 10) + result;
	        }
	        return result;
	    }
	    
	    public static String multiply(String s1, String s2){
	        int len = s1.length();
	        int index = s2.length() - 1;
	        String result = "";
	        String zeroes = "";
	        while(index >= 0){
	            int carry = 0;
	            int first = s2.charAt(index) - '0';
	            String curResult = "";
	            for(int i = len - 1; i >= 0; --i){
	                int cur = first * (s1.charAt(i) - '0') + carry;
	                carry = cur / 10;
	                cur = cur % 10;
	                curResult = cur + curResult;
	            }
	            if(carry > 0){
	                curResult = carry + curResult;
	            }
	            result = add(result, curResult + zeroes);
	            zeroes += "0";
	            --index;
	        }
	        return result;
	    }
}
