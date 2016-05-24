/**
 * File Name: RemoveDuplicatesFromSortedArray.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:57:34 AM Sep 7, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:57:34 AM Sep 7, 2015
 */
public class RemoveDuplicatesFromSortedArray {
	/*
	 * nums must be a sorted array then can remove duplicate
	 */
    public int removeDuplicates1(int[] nums) {
        if(nums.length == 0){  //nums == null || nums.length == 0
            return 0;
        }
        int flag = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > flag){
                flag = nums[i];
                nums[count] = nums[i];
                count++;
            }
        }
        return count;       
    }
    
    /*
     * General remove duplicates algorithm
     */
    public int removeDuplicates(int[] nums) {
    		if(nums == null || nums.length == 0){
    			return 0;
    		}
    		int i = 1;
    		int j = 1;
    		for(; i < nums.length;){
    			while(j < nums.length && nums[j] == nums[j - 1]){
    				++j;
    			}
    			if(i == j){
    				++i;
    				++j;
    				continue;
    			}
    			if(j == nums.length){
    				return i;
    			}
    			nums[i++] = nums[j++];
    		}
    	
    		return i;
    }
}
