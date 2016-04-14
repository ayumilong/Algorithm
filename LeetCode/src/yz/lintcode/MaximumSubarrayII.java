/**
 * File Name: MaximumSubarrayII.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:35:13 PM Jan 31, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:35:13 PM Jan 31, 2016
 */
public class MaximumSubarrayII {

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int len = nums.size();
        
        int[] leftMax = new int[len];
        int minSum = nums.get(0);
        int sum = minSum;
        leftMax[0] = sum;
        int curMax = sum;
        for(int i = 1; i < len; ++i){
            sum += nums.get(i);
            leftMax[i] = (sum > sum - minSum) ? sum : sum - minSum;
            minSum = minSum < sum ? minSum : sum;
            
            if(leftMax[i] > curMax){
                curMax = leftMax[i];
            }else{
                leftMax[i] = curMax;
            }
        }
        
        int[] rightMax = new int[len];
        minSum = nums.get(len - 1);
        sum = minSum;
        rightMax[len - 1] = sum;
        curMax = sum;
        for(int i = len - 2; i >= 0; --i){
            sum += nums.get(i);
            rightMax[i] = (sum > sum - minSum) ? sum : sum - minSum;
            minSum = minSum < sum ? minSum : sum;
            
            if(rightMax[i] > curMax){
                curMax = rightMax[i];
            }else{
                rightMax[i] = curMax;
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len - 1; ++i){
            if(max < leftMax[i] + rightMax[i + 1]){
                max = leftMax[i] + rightMax[i + 1];
            }
        }
        
        for(int i = 0; i < len; ++i){
        		System.out.print(leftMax[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < len; ++i){
    			System.out.print(rightMax[i] + " ");
        }
        System.out.println();
        return max;
    }

}