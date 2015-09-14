/**
 * File Name: LengthOfLastWord.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:58:14 PM Aug 18, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:58:14 PM Aug 18, 2015
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s){
		String[] strArray = s.split(" ");
		return (strArray.length == 0) ? 0 : strArray[strArray.length - 1].length();
		//return (s.split(" ").length == 0) ? 0 : s.split(" ")[s.split(" ").length - 1].length(); 
	}
}
