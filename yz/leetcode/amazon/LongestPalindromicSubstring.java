/**
 * File Name: LongestPalindromicSubstring.java
 * Package Name: yz.amazon.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:52:32 PM Apr 16, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

/**
 * @author Yaolin Zhang
 * @time 8:52:32 PM Apr 16, 2016
 */
public class LongestPalindromicSubstring {
	//Expand Around Center, Time: O(n2), Space: O(1)
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        char[] cs = s.toCharArray();
        int max = 1;
        int start = 0;
        for(int i = 0; i < cs.length; ++i){
            int len1 = isPalindrome(cs, i, i);
            int len2 = isPalindrome(cs, i, i + 1);
            int len = len1 > len2 ? len1 : len2;
            if(len > max){
            		max = len;
            		start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + max);
    }
    //Compute the length of palindrome centered in cs[i] and cs[j]
    private int isPalindrome(char[] cs, int i, int j){
        while(i >= 0 && j < cs.length && cs[i] == cs[j]){
        		--i;
        		++j;
        }
        return j - i - 1;
    }
	//DP solution, Time: O(n2), Space: O(n)
    public String longestPalindrome1(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        char[] cs = s.toCharArray();
        int len = cs.length;
        //boolean[][] isP = new boolean[len][len];//False is a substring
        boolean[][] isP = new boolean[len][2];
        int maxLen = 1;
        int start = 0;
        for(int i = 1; i < len; ++i){
            for(int j = 0; j < i; ++j){
                if(cs[j] == cs[i] && !isP[j + 1][(i - 1) % 2]){
                    isP[j][i % 2] = false; //Restore it to false
                    if(i - j + 1 > maxLen){
                        maxLen = i - j + 1;
                        start = j;
                    }
                }else{
                    isP[j][i % 2] = true; //s.substring(j, i + 1) is not a palindrom
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
