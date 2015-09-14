/**
 * File Name: IntegerToEnglishWords.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:45:24 PM Sep 13, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 1:45:24 PM Sep 13, 2015
 */
public class IntegerToEnglishWords {
	private String transform(int num){
		String dic[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
				"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "", "","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
				"Eighty", "Ninety", "Hundred"
		};
		String result = "";
		int hundred = num / 100;
		if(hundred != 0){
			result += dic[hundred] + " Hundred" + " ";
		}
		num = num % 100;
		int ten = num / 10;
		int digit = num % 10;
		if(ten == 1){
			result += dic[ten * 10 + digit];
		}else{
			result += dic[ten + 20]; //If ten == 0 or digit == 0, then just add a "" string
			result = ten != 0 ? result + " " : result;
			result += dic[digit];
		}
		return result.trim();
	}
    public String numberToWords(int num) {
    		if(num == 0){
    			return "Zero";
    		}
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;
        String result = "";
        int temp = num / billion;
        if(temp != 0){
        		result += transform(temp) + " Billion ";
        }
        num = num % billion;
        
        temp = num / million;
        if(temp != 0){
        		result += transform(temp) + " Million ";
        }
        num = num % million;
        
        temp = num / thousand;
        if(temp != 0){
        		result += transform(temp) + " Thousand ";
        }
        num = num % thousand;
        
        result += transform(num);

    		return result.trim();
    }
}
