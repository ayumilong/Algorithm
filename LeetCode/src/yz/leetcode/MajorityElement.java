/**
 * File Name: MajorityElement.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:54:15 PM Sep 9, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.Arrays;

/**
 * @author Yaolin Zhang
 * @time 8:54:15 PM Sep 9, 2015
 */
public class MajorityElement {
	/*
	 * Sort
	 */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    /*
     * Bit Manipulation
     */
    public int majorityElement1(int [] nums){
    		int[] count = new int[32];
    		for(int i = 0; i < 32; ++i){
    			for(int j = 0; j < nums.length; ++j){
    				if((nums[j] & (1 << i)) != 0){
    					++count[i];
    				}
    			}
    		}
    		int majority = 0;
    		for(int i = 0; i < 32; ++i){
    			if(count[i] > nums.length / 2){
    				majority |= (1 << i);
    			}
    		}
    		return majority;
    }
    
    /*
     * Moore Voting 
     */
    public int majorityElement2(int [] nums){
    		int majority = nums[0];
    		int count = 1;
    		for(int i = 1; i < nums.length; ++i){
    			if(nums[i] != majority){
    				if(count == 0){
    					majority = nums[i];
    					count = 1;
    				}else{
    					--count;
    				}
    			}else{
    				++count;
    			}
    		}
    		return majority;
    }
    
    /*
     * Divide and Conquer
     */
    private int findMajority(int [] nums, int start, int end){
    		if(start == end - 1){
    			return nums[start];
    		}
    		int left = findMajority(nums, start, start + (end - start) / 2);
    		int right = findMajority(nums, start + (end - start) / 2, end);
    		if(left == right){
    			return left;
    		}else{
    			int leftCount = 0;
    			int rightCount = 0;
    			for(int i = start; i < end; ++i){
    				if(nums[i] == left){
    					++leftCount;
    				}else if(nums[i] == right){
    					++rightCount;
    				}
    			}
    			return (leftCount > rightCount) ? left : right;
    		}
    }
    
    public int majorityElement3(int [] nums){
    		return findMajority(nums, 0, nums.length);
    }
}
