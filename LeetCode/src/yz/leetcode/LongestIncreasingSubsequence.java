/**
 * File Name: LongestIncreasingSubsequence.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 4:45:17 PM Jan 17, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 4:45:17 PM Jan 17, 2016
 */
public class LongestIncreasingSubsequence {
	/*
	 * DP O(n*n)
	 */
    public int lengthOfLIS1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int greater[] = new int[nums.length];
        int max = 0;
        for(int i = nums.length - 2; i >= 0; --i){
            int curMax = -1;
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[j] > nums[i]){
                    curMax = curMax > greater[j] ? curMax : greater[j];
                }
            }
            greater[i] = curMax + 1;
            max = max > greater[i] ? max : greater[i];
        }
        return max + 1;
    }
}
