/**
 * File Name: LongestCommonSubstring.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:09:26 PM Jan 26, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 11:09:26 PM Jan 26, 2016
 */
public class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        if(A == null || B == null){
            return 0;
        }
        char[] ca = A.toCharArray();
        char[] cb = B.toCharArray();
        int aLen = ca.length;
        int bLen = cb.length;
        if(aLen == 0 || bLen == 0){
            return 0;
        }
        
        int[][] lcs = new int[aLen + 1][bLen + 1];
        for(int i = 1; i <= aLen; ++i){
            for(int j = 1; j <= bLen; ++j){
                lcs[i][j] = lcs[i - 1][j - 1];
                lcs[i][j] += ((A.substring(i - lcs[i][j] - 1, i - 1).equals(B.substring(j - lcs[i][j] - 1, j - 1)) && ca[i - 1] == cb[j - 1]) ? 1 : 0);
                lcs[i][j] = lcs[i][j] > lcs[i][j - 1] ? lcs[i][j] : lcs[i][j - 1];
                lcs[i][j] = lcs[i][j] > lcs[i - 1][j] ? lcs[i][j] : lcs[i - 1][j];
            }
        }
        return lcs[aLen][bLen];
    }
}
