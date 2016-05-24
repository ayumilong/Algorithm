/**
 * File Name: strStr.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:33:21 PM May 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

/**
 * @author Yaolin Zhang
 * @time 9:33:21 PM May 4, 2016
 */
public class strStr {
    public int strStr(String src, String dst) {
        if(src == null || dst == null){
            return -1;
        }
        for(int i = 0; i < src.length() - dst.length() + 1; ++i){
            int j = 0;
            while(j < dst.length() && src.charAt(i + j) == dst.charAt(j)){
                ++j;
            }
            if(j == dst.length()){
                return i;
            }
        }
        return -1;
    }
    
    /*
     * Rabin-Karp Algorithm using Rolling Hash
     */
    public int strStr1(String src, String dst) {
        if(src.length() < dst.length()){
            return -1;
        }
        long dstHash = hash(dst);
        long srcHash = hash(src.substring(0, dst.length()));
        for(int i = 0; i < src.length() - dst.length(); ++i){
            if(srcHash == dstHash){
                return i;
            }
            srcHash = 31 * (srcHash - src.charAt(i) * (long)Math.pow(31, dst.length() - 1)) + src.charAt(i + dst.length());
        }
        if(srcHash == dstHash){
            return src.length() - dst.length();
        }
        return -1;
    }
    
    private long hash(String s){
        long value = 0L;
        for(int i = 0; i < s.length(); ++i){
            value = value * 31 + s.charAt(i);
        }
        return value;
    }
}
