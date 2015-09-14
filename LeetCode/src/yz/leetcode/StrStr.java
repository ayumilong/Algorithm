/**
 * File Name: StrStr.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:23:28 PM Aug 29, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.Arrays;

/**
 * @author Yaolin Zhang
 * @time 9:23:28 PM Aug 29, 2015
 */
public class StrStr {
	/*
	 * Common method, 2-level for-loop
	 */
	public int strStr(String haystack, String needle) {
		int hayLen = haystack.length();
		int needleLen = needle.length();
		if (needleLen == 0) {
			return 0;
		}

		/*
		for (int i = 0; i < hayLen - needleLen + 1; ++i) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				boolean find = true;
				for (int j = 1; j < needleLen; ++j) {
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						find = false;
						break;
					}
				}
				if (find) {
					return i;
				}
			}
		}
		*/
		int i = 0;
		int j = 0;
		while(i < hayLen - needleLen + 1 && j < needleLen){
			if(haystack.charAt(i) == needle.charAt(j)){
				++i;
				++j;
			}else{
				i = i - j + 1;
				j = 0;
			}
		}
		if(j == needleLen){
			return i - j;
		}
		return -1;
	}

	/*
	 * KMP
	 */
	public void partialMatch(String s, int[] table, int len) {
		table[0] = -1;
		int i = -1; //Prefix
		int j = 0;  //Surfix
		while(j < len - 1){
			if(i == -1 || s.charAt(j) == s.charAt(i)){
				++i;
				++j;
				if(s.charAt(j) != s.charAt(i)){
					table[j] = i;
				}else{
					table[j] = table[i]; //Back trace
					//table[j] = i;
				}
			}else{
				i = table[i];
			}
		}
	}

	public int strStrKMP(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len2 == 0) {
			return 0;
		}
		if (len1 < len2) {
			return -1;
		}
		int[] table = new int[len2];
		partialMatch(needle, table, len2);
		System.out.println(Arrays.toString(table));
		/*
		int m = 0;
		int i = 0;
		while (m + i < len1) {
			if (haystack.charAt(m + i) == needle.charAt(i)) {
				++i;
				if (i == len2) {
					return m;
				}
			} else {
				if (table[i] > -1) {
					m = m + i - table[i];
					i = table[i];
				} else {
					m = m + i + 1;
					i = 0;
				}
			}
		}
		*/
		int i = 0;
		int j = 0;
		while(i < len1 && j < len2){
			if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
				++i;
				++j;
			}else{
				j = table[j];
			}
		}
		if(j == len2){
			return i - j;
		}
		return -1;
	}
}
