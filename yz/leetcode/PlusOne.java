/**
 * File Name: PlusOne.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 4:47:24 PM Sep 6, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;


/**
 * @author Yaolin Zhang
 * @time 4:47:24 PM Sep 6, 2015
 */
public class PlusOne {
	public int[] plusOne2(int[] digits) {
	    if(digits == null){
	        return new int[0];
	    }

	    for(int i = digits.length - 1; i >= 0; i--){
	        if(digits[i] != 9){
	            digits[i]++;
	            return digits;
	        }else{
	            digits[i] = 0;
	        }
	    }

	    int[] result = new int[digits.length + 1];
	    result[0] = 1;

	    return result;
	}
	
	public int[] plusOne1(int[] digits){
		if(digits == null){
	        return new int[0];
	    }
		int pos = digits.length - 1;
		while(pos >= 0 && digits[pos] == 9){
			digits[pos] = 0;
			--pos;
		}
		if(pos == -1){
			int result[] = new int[digits.length + 1];
    			result[0] = 1;
    			return result;			
		}else{
			++digits[pos];
			return digits;
		}
	}
	
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
        		return null;
        }
        int carry = 0;
        
        int temp = digits[digits.length - 1] + 1;
        digits[digits.length - 1] = temp % 10;
        carry = temp / 10;
        
        for(int i = digits.length - 2; i >= 0 ; --i){
        		if(carry == 0){
        			break;
        		}
        		temp = digits[i] + carry;
        		digits[i] = temp % 10;
        		carry = temp / 10;
        }
        if(carry == 0){
        		return digits;
        }else{
        		int result[] = new int[digits.length + 1];
        		result[0] = 1;
        		for(int i = 0; i < digits.length; ++i){
        			result[i + 1] = digits[i];
        		}
        		return result;
        }
    }
}
