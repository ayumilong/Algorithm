/**
 * File Name: MinimumSizeSubarraySum.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:15:12 AM Sep 12, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;


/**
 * @author Yaolin Zhang
 * @time 11:15:12 AM Sep 12, 2015
 */
public class MinimumSizeSubarraySum {
	/*
	 * Two Pointers
	 */
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int curMin = 0;
        int sum = 0;
    		for(int i = 0; i < nums.length; ++i){
    			sum += nums[i];
    			if(sum >= s){
    				while(sum - nums[start] >= s){
    					sum -= nums[start];
    					++start;
    				}
    				if(curMin == 0 || curMin > (i - start + 1)){
    					curMin = i - start + 1;
    				}
    			}
        }
    		return curMin;
    }
}
