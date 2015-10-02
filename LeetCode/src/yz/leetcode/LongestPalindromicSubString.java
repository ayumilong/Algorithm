/**
 * File Name: LongestPalindromicSubString.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:33:00 PM Sep 16, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 10:33:00 PM Sep 16, 2015
 */
public class LongestPalindromicSubString {
	private int start = 0;
	private int curLen = 1;
	private void getPalindrom(String s, int left, int right){
		while(left >= 0 && right < s.length()){
			if(s.charAt(left) != s.charAt(right)){
				break;
			}
			--left;
			++right;
		}
		if(curLen < right - left - 1){
			curLen = right - left - 1;
			start = left + 1;
		}
	}
	public String longestPalindrome(String s){
		int len = s.length();
		if(len == 0 || len == 1){
			return s;
		}
		for(int i = 0; i < len; ++i){
			getPalindrom(s, i, i);
			getPalindrom(s, i, i + 1);
		}
		return s.substring(start, start + curLen);
	}
	
	private boolean isPalindrom(String s, int start, int end){
		if(start < 0){
			return false;
		}
		while(start < end){
			if(s.charAt(start++) != s.charAt(end--)){
				return false;
			}
		}
		return true;
	}
	public String longestPalindrome3(String s){
		String result = "";
		int curLen = 0;
		for(int i = 0; i < s.length(); ++i){
			if(isPalindrom(s, i - curLen - 1, i)){
				result = s.substring(i - curLen - 1, i + 1);
				curLen += 2;
			}else if(isPalindrom(s, i - curLen, i)){
				result = s.substring(i - curLen, i + 1);
				curLen += 1;
			}
		}
		return result;
	}
	
	public String longestPalindrome2(String s) {
        int len = s.length();
        if(len == 0){
        		return "";
        }
        boolean palindroms[][] = new boolean[len][len];
        char chars[] = s.toCharArray();
        int start = 0;
        int end = 0;
        for(int i = 0; i < len; ++i){
        		palindroms[i][i] = true;
        		if(i != len - 1 && chars[i] == chars[i + 1]){
        			palindroms[i][i + 1] = true;
        			start = i;
        			end = i + 1;
        		}
        }
        for(int i = 2; i < len; ++i){
        		for(int j = 0; j < len - i; ++j){
        			if(palindroms[j + 1][j + i - 1] && chars[j] == chars[j + i]){
        				palindroms[j][j + i] = true;
        				start = j;
        				end = j + i;
        			}
        		}
        }
    		return s.substring(start, end + 1);
    }
	
	public String longestPalindrome1(String s) {
        int len = s.length();
        if(len == 0){
        		return "";
        }
        int palindroms[][] = new int[len][len];
        char chars[] = s.toCharArray();
        int start = 0;
        int end = 0;
        for(int i = 0; i < len; ++i){
        		palindroms[i][i] = 1;
        		if(i != len - 1 && chars[i] == chars[i + 1]){
        			palindroms[i][i + 1] = 2;
        			start = i;
        			end = i + 1;
        		}
        }
        for(int i = 2; i < len; ++i){
        		for(int j = 0; j < len - i; ++j){
        			if(palindroms[j + 1][j + i - 1] != 0 && chars[j] == chars[j + i]){
        				palindroms[j][j + i] = palindroms[j + 1][j + i - 1] + 2;
        				start = j;
        				end = j + i;
        			}
        		}
        }
    		return s.substring(start, end + 1);
    }
}
