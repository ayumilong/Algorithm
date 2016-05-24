/**
 * File Name: EncodeAndDecodeStrings.java
 * Package Name: yz.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:21:42 AM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:21:42 AM Apr 23, 2016
 */
public class EncodeAndDecodeStrings {
	public static void main(String args[]){
		EncodeAndDecodeStrings ed = new EncodeAndDecodeStrings();
		List<String> strs = Arrays.asList("", "", "dgsdfgsfgsdfgsfggsdfgsfg∂");
		System.out.println(ed.encode(strs));
		List<String> strsd = ed.decode(ed.encode(strs));
		for(String s : strsd){
			System.out.println(s);
		}
	}
	
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        int maxLen = 0;
        for(String s : strs){
            if(s.length() > maxLen){
                maxLen = s.length();
            }
        }
        maxLen = (maxLen + "").length(); //The length of the length of maximum string in List<Strign>
        sb.append(maxLen + "#");
        for(String s : strs){
            String sLen = s.length() + "";
            int len = sLen.length();
            while(len < maxLen){
                sLen = '0' + sLen;
                ++len;
            }
            sb.append(sLen + s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> results = new ArrayList<>();
        int start = s.indexOf('#');
        int maxLen = Integer.parseInt(s.substring(0, start));
        for(int i = start + 1; i < s.length();){
            int len = Integer.parseInt(s.substring(i, i + maxLen));
            String cur = s.substring(i + maxLen, i + maxLen + len);
            results.add(cur);
            i += maxLen + len;
        }
        return results;
    }
}
