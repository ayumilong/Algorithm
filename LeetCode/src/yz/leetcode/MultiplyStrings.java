/**
 * File Name: MultiplyStrings.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:28:24 PM Sep 15, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 8:28:24 PM Sep 15, 2015
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2){
		int len1 = num1.length();
		int len2 = num2.length();
		int result[] = new int[len1 + len2];
		for(int i = len1 - 1; i >= 0; --i){
			int a = num1.charAt(i) - '0';
			for(int j = len2 - 1; j >= 0; --j){
				int b = num2.charAt(j) - '0';
				int c = result[i + j + 1] + a * b;
				result[i + j + 1] = c % 10;
				result[i + j] = c / 10 + result[i + j];
			}
		}
		int i = 0;
		StringBuffer strResult = new StringBuffer();
		while(i < result.length && result[i] == 0){
			++i;
		}
		while(i < result.length){
			strResult.append(result[i++]);
		}
		return strResult.length() == 0 ? "0" : strResult.toString();
	}
	
	private String multiplyBySingle(String num, int digit, int trailingZero){
		int len = num.length();
		if(len == 0){
			return "";
		}
		StringBuffer result = new StringBuffer();
		int carry = 0;
		for(int i = len - 1; i >= 0; --i){
			int cur = (num.charAt(i) - '0') * digit + carry;
			carry = cur / 10;
			result.insert(0, (cur % 10));
		}
		if(carry > 0){
			result.insert(0, carry);
		}
		for(int i = 0; i < trailingZero; ++i){
			result.append(0);
		}
		return result.toString();
	}
	
	private StringBuffer addTwoString(String num1, String num2){
		if(num1.equals("")){
			return new StringBuffer(num2);
		}
		if(num2.equals("")){
			return new StringBuffer(num1);
		}
		StringBuffer result = new StringBuffer();
		int len1 = num1.length();
		int len2 = num2.length();
		int i = 1;
		int carry = 0;
		while(i <= len1 && i <= len2){
			int cur = num1.charAt(len1 - i) + num2.charAt(len2 - i) + carry - '0' - '0';
			carry = cur / 10;
			result.insert(0, (cur % 10));
			++i;
		}
		if(i > len1){
			if(carry == 1){
				while(i <= len2){
					int cur = num2.charAt(len2 - i) + carry - '0';
					carry = cur / 10;
					result.insert(0, (cur % 10));
					++i;
				}
			}else{
				result.insert(0, num2.substring(0, len2 - i + 1));
			}
		}else if(i > len2){
			if(carry == 1){
				while(i <= len1){
					int cur = num1.charAt(len1 - i) + carry - '0';
					carry = cur / 10;
					result.insert(0, (cur % 10));
					++i;
				}
			}else{
				result.insert(0, num1.substring(0, len1 - i + 1));
			}
		}
		if(carry > 0){
			result.insert(0, carry);
		}
		
		return result;
	}
	
    public String multiply1(String num1, String num2) {
    		if(num1.equals("0") || num2.equals("0")){
    			return "0";
    		}
        int len2 = num2.length();
        StringBuffer result = new StringBuffer();
        for(int i = 1; i <= len2; ++i){
        		String midResult = multiplyBySingle(num1, num2.charAt(len2 - i) - '0', i - 1);
        		result = addTwoString(result.toString(), midResult);
        }
        
        return result.toString();
    }
}
