/**
 * File Name: LongestCommonPrefix.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 2:18:07 PM Aug 29, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 2:18:07 PM Aug 29, 2015
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0){
        		return "";
        }
        String prefix = strs[0];
        int preLen = prefix.length();
        int i = 0;
        for(; i < preLen; ++i){
        		boolean isCommon = true;
        		for(int j = 1; j < len; ++j){
        			if(i == strs[j].length() || strs[j].charAt(i) != prefix.charAt(i)){
        				isCommon = false;
        				break;
        			}
        		}
        		if(!isCommon){
        			break;
        		}
        }  
		return prefix.substring(0, i);
    }
}
