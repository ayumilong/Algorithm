/**
 * File Name: ReverseArrayExceptSpecialChars.java
 * Package Name: yz.geeksforgeeks
 * Project Name: LeetCode
 * Purpose: http://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
 * Created Time: 8:27:24 PM Oct 27, 2015
 * Author: Yaolin Zhang
 */
package yz.geeksforgeeks;

/**
 * @author Yaolin Zhang
 * @time 8:27:24 PM Oct 27, 2015
 */
public class ReverseArrayExceptSpecialChars {
	public void reverse(char[] str) {
		int len = str.length;
		for (int i = 0, j = len - 1; i < j;) {
			if (!Character.isAlphabetic(str[i])) {
				++i;
			} else if (!Character.isAlphabetic(str[j])) {
				--j;
			} else {
				char temp = str[i];
				str[i] = str[j];
				str[j] = temp;
				++i;
				--j;
			}
		}
	}
}
