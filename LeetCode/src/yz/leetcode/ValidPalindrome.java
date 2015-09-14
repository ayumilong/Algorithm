/**
 * File Name: ValidPalindrome.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 3:24:56 PM Aug 29, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 3:24:56 PM Aug 29, 2015
 */
public class ValidPalindrome {
	public boolean isPalindrome0(String s) {
        
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i))){
            ++i;
        }
        if(i == s.length()){
            return true;
        }
        while(!Character.isLetterOrDigit(s.charAt(j))){
            --j;
        }
        if(s.charAt(i) != s.charAt(j)){
            return false;
        }
        ++i;
        --j;
        }
        return true;      
    }
	
    public boolean isPalindrome(String s) {
    		s = s.trim().toLowerCase();
        int len = s.length();
        for(int i = 0, j = len - 1; i < j; ++i, --j){
        		while(i < len && !Character.isLetterOrDigit(s.charAt(i))){
        			++i;
        		}
        		if(i == len){
        			return true;
        		}
        		while(!Character.isLetterOrDigit(s.charAt(j))){
        			--j;
        		}
        		if(s.charAt(i) != s.charAt(j)){
        			return false;
        		}
        }
    		return true;
    }
}
