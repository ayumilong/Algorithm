/**
 * File Name: LongestSubstringWithoutRepeatingCharacters.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:47:17 PM Sep 15, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.HashMap;

/**
 * @author Yaolin Zhang
 * @time 11:47:17 PM Sep 15, 2015
 */
public class LongestSubstringWithoutRepeatingCharacters {
	/*
	 * Can only process ASCII characters
	 */
	public int lengthOfLongestSubstring1(String s){
		int len = s.length();
		boolean chars[] = new boolean[256];
		int startPos = 0;
		int maxLen = 0;
		for(int i = 0; i < len; ++i){
			if(chars[s.charAt(i)]){
				maxLen = maxLen > i - startPos ? maxLen : i - startPos;
				while(s.charAt(startPos) != s.charAt(i)){
					chars[s.charAt(startPos)] = false;
					++startPos;
				}
				++startPos;
			}else{
				chars[s.charAt(i)] = true;
			}
		}
		return maxLen > len - startPos ? maxLen : len - startPos;
	}
	/*
	 * HashMap, can process any characters
	 */
    public int lengthOfLongestSubstring(String s) {
    		int len = s.length();
    		HashMap<Character, Boolean> map = new HashMap<>();
    		int startPos = 0;
    		int curMax = 0;
    		for(int i = 0; i < len; ++i){
    			if(map.containsKey(s.charAt(i))){
    				curMax = curMax > i - startPos ? curMax : i - startPos;
				while(s.charAt(startPos) != s.charAt(i)){
					map.remove(s.charAt(startPos));
					++startPos;
				}
				++startPos;
    			}else{
    				map.put(s.charAt(i), true);
    			}
    		}
    		return curMax > len - startPos ? curMax : len - startPos;
    }
}

