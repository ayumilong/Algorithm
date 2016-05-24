/**
 * File Name: ValidAnagram.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:36:48 PM Apr 13, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:36:48 PM Apr 13, 2016
 */
public class ValidAnagram {
	//Sort
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for(int i = 0; i < sc.length; ++i){
            if(sc[i] != tc[i]){
                return false;
            }
        }
        return true;
    }
    //Easy-version Hash
    public boolean isAnagram2(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        char[] map = new char[26];
        int len = s.length();
        for(int i = 0; i < len; ++i){
            ++map[s.charAt(i) - 'a'];
        }
        for(int i = 0; i < len; ++i){
            if(map[t.charAt(i) - 'a'] == 0){
                return false;
            }
            --map[t.charAt(i) - 'a'];
            
        }
        return true;
    }
	//HashMap
    public boolean isAnagram1(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> chars = new HashMap<>();
        int len = s.length();
        for(int i = 0; i < len; ++i){
            char c = s.charAt(i);
            if(chars.containsKey(c)){
                chars.put(c, chars.get(c) + 1);
            }else{
                chars.put(c, 1);
            }
        }
        for(int i = 0; i < len; ++i){
            char c = t.charAt(i);
            if(!chars.containsKey(c)){
                return false;
            }else{
                if(chars.get(c) == 0){
                    return false;
                }
                chars.put(c, chars.get(c) - 1);
            }
        }
        return true;
    }
}
