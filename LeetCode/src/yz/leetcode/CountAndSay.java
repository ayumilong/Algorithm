/**
 * File Name: CountAndSay.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 12:52:28 PM Aug 29, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 12:52:28 PM Aug 29, 2015
 */
public class CountAndSay {
	public String countAndSay0(int n){
		StringBuilder result = new StringBuilder("1");
		for(int i = 1; i < n; ++i){
			StringBuilder temp = new StringBuilder();
			int len = result.length();
			temp.append("1" + result.charAt(0));
			for(int j = 1; j < len; ++j){
				int tempLen = temp.length();
				if(result.charAt(j) == result.charAt(j - 1)){
					temp.setCharAt(tempLen - 2, (char)(temp.charAt(tempLen - 2) + 1));
				}else{
					temp.append("1" + result.charAt(j));
				}
			}
			result = temp;
		}
		return result.toString();
	}
	
	public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        for(int i = 1; i < n; ++i){
        		StringBuilder temp = new StringBuilder();
        		int len = result.length();
        		for(int j = 0; j < len;){
        			int k = j + 1;
        			int repeat = 1;
        			while(k < len && result.charAt(k) == result.charAt(j)){
        				++k;
        				++repeat;
        			}
        			temp.append(repeat);
        			temp.append(result.charAt(j));
        			j += repeat;
        		}
        		result = temp;
        }
		return result.toString();
    }
}
