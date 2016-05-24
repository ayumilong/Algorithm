/**
 * File Name: ReverseWordsInAStringII.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:00:32 AM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

/**
 * @author Yaolin Zhang
 * @time 12:00:32 AM Apr 14, 2016
 */
public class ReverseWordsInAStringII {
	public String reverseWords(String s){
		StringBuffer sb = new StringBuffer();
		int len = s.length();
		for(int i = len - 1; i >= 0; --i){
			while(i >= 0 && s.charAt(i) == ' '){
				--i;
			}
			if(i == -1){
				break;
			}
			int end = i + 1;
			while(i >= 0 && s.charAt(i) != ' '){
				--i;
			}
			sb.append(s.substring(i + 1, end) + " ");
		}
		if(sb.length() == 0){
			return "";
		}
		return sb.substring(0, sb.length() - 1);
	}
	
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0){
            return;
        }
        reverse(s, 0, s.length - 1);
        int start = 0;
        for(int i = 0; i < s.length; ++i){
            if(s[i] == ' '){
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        reverse(s, start, s.length - 1);
    }
    
    private void reverse(char[] s, int start, int end){
        while(start < end){
            char c = s[start];
            s[start++] = s[end];
            s[end--] = c;
        }
    }
}
