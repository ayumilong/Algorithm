/**
 * File Name: ReverseString.java
 * Package Name: yz.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:19:46 AM Apr 26, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 11:19:46 AM Apr 26, 2016
 */
public class ReverseString {
	public String reverseString(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		char[] cs = s.toCharArray();
		int left = 0;
		int right = cs.length - 1;
		while(left < right){
			char temp = cs[left];
			cs[left] = cs[right];
			cs[right] = temp;
			++left;
			--right;
		}
		return String.valueOf(cs);
	}
}
