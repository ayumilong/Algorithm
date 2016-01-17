/**
 * File Name: PalindromNumber.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:23:44 PM Jan 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:23:44 PM Jan 4, 2016
 */
public class PalindromNumber {
	public boolean isPalindrome(int x) {
		if(x >= 0){
			int digits = 0;
			int old = x;
			while(x != 0){
				++digits;
				x /= 10;
			}
			int half = 0;
			for(int i = 0; i < digits / 2; ++i){
				half = half * 10 + old % 10;
				old /= 10;
			}
			return digits % 2 == 0 ? half == old : half == old / 10;
		}
		return false;
	}
	
    public boolean isPalindrome1(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)){ //for 10, 110, 1100.......
            return false;
        }
        int palindrome = 0;
        while(x > palindrome){
            palindrome = palindrome * 10 + x % 10;
            x = x / 10;
        }
        return (palindrome == x) || (palindrome / 10 == x);
    }
}
