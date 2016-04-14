/**
 * File Name: MaximumSubarrayIII.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:05:42 PM Jan 31, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 8:05:42 PM Jan 31, 2016
 */
public class MaximumSubarrayIII {
    public int maxSubArray(int[] nums, int k) {
        int len = nums.length;
        int[][] max = new int[k + 1][len];
        int sum = 0;
        for(int j = 1; j <= k; ++j){
            sum += nums[j - 1];
            max[j][j - 1] = sum;
        }
        for(int i = 1; i < len; ++i){
            max[1][i] = Math.max(max[1][i - 1] + nums[i], nums[i]);
        }
        for(int i = 2; i <= k; ++i){
            for(int j = i; j < len; ++j){
                int curMax = max[i][j - 1] + nums[j];
                for(int m = i - 2; m < j; ++m){
                    if(curMax < max[i - 1][m] + nums[j]){
                        curMax = max[i - 1][m] + nums[j];
                    }
                }
                max[i][j] = curMax;
            }
        }
        for(int i = 0; i <= k; ++i){
        		for(int j = 0; j < len; ++j){
        			System.out.print(max[i][j] + " ");
        		}
        		System.out.println();
        }
        int result = max[k][k - 1];
        for(int i = k; i < len; ++i){
            if(result < max[k][i]){
                result = max[k][i];
            }
        }
        return result;
    }

    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
	/*
	 * Slow
	 */
    public int maxSubArray1(int[] nums, int k) {
        if(nums == null || nums.length < k){
            return Integer.MIN_VALUE;
        }
        return helper(nums, 0, nums.length, k);
    }
    
    private int helper(int[] nums, int start, int end, int k){
        int len = end - start;
        System.out.println(start + "  " + end + "  " + k);
        int[] leftMax = new int[len];
        int minSum = 0;
        int sum = 0;
        int curMax = Integer.MIN_VALUE;
        int index = 0;
        for(int i = start; i < end; ++i){
            sum += nums[i];
            curMax = (curMax > sum - minSum) ? curMax : sum - minSum;
            leftMax[index++] = curMax;
            minSum = minSum < sum ? minSum : sum;
        }
        if(k == 1){
            return curMax;
        }
        curMax = Integer.MIN_VALUE;
        for(int i = start; i < end - k + 1; ++i){
            int temp = helper(nums, i + 1, end, k - 1) + leftMax[i - start];
            if(curMax < temp){
                curMax = temp;
            }
        }
        return curMax;
    }

}
