/**
 * File Name: PalindromPartitioningII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:50:08 PM Jan 23, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 11:50:08 PM Jan 23, 2016
 */
public class PalindromPartitioningII {
	/*
	 * O(n*n)
	 */
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] cs = s.toCharArray();
        int len = cs.length;
        boolean[][] isP = new boolean[len][len];
        int[] bestCuts = new int[len];
        bestCuts[0] = 0;
        for(int i = 0; i < len; ++i){
            int curBest = i;
            for(int j = 0; j <= i; ++j){
                if(cs[i] == cs[j] && (j + 1 > i - 1 || isP[j + 1][i - 1])){
                    isP[j][i] = true;
                    curBest = j == 0 ? 0 : curBest < bestCuts[j - 1] + 1 ? curBest : bestCuts[j - 1] + 1;
                }
            }
            bestCuts[i] = curBest;
        }
        return bestCuts[len - 1];
    }
	/*
	 * O(n*n)
	 */
    public int minCut2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        boolean[][] isP = new boolean[len][len];
        for(int i = 0; i < len - 1; ++i){
            isP[i][i] = true;
            isP[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        isP[len - 1][len - 1] = true;
        
        for(int i = 2; i < len; ++i){
            for(int j = 0; i + j < len; ++j){
                isP[j][i + j] = isP[j + 1][i + j - 1] && s.charAt(j) == s.charAt(i + j);
            }
        }
        int[] bestCuts = new int[len + 1];
        bestCuts[0] = -1;
        bestCuts[1] = 0;
        for(int i = 1; i < len; ++i){
            int curBest = bestCuts[i] + 1;
            for(int j = i - 1; j >= 0; --j){
                if(isP[j][i]){
                    curBest = curBest < bestCuts[j] + 1 ? curBest : bestCuts[j] + 1;
                }
            }
            bestCuts[i + 1] = curBest;
        }
        return bestCuts[len];
    }
	
	/*
	 * O(n*n*n)
	 */
    private boolean isPalindrome(String s){
		int len = s.length();
		int left = (len - 1) / 2;
		int right = len / 2;
		while(left >= 0 && s.charAt(left) == s.charAt(right)){
			--left;
			++right;
		}
		return left == -1;
	}
    public int minCut1(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        
        int[] bestCuts = new int[len + 1];
        bestCuts[0] = -1;
        bestCuts[1] = 0;
        for(int i = 1; i < len; ++i){
            int curBest = bestCuts[i] + 1;
            for(int j = i - 1; j >= 0; --j){
                int cur = 0;
                if(isPalindrome(s.substring(j, i + 1))){
                    cur = bestCuts[j] + 1;
                    curBest = curBest < cur ? curBest : cur;
                }
            }
            bestCuts[i + 1] = curBest;
        }
        return bestCuts[len];
    }
}
