/**
 * File Name: SearchForARange.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 4:31:43 PM Sep 12, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 4:31:43 PM Sep 12, 2015
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
    		int[] result = new int[2];
    		int low = 0;
    		int high = nums.length - 1;
    		while(low <= high){
    			int middle = low + (high - low) / 2;
    			if(nums[middle] == target){
    				int i = middle;
    				int j = middle;
    				while(i > low && nums[i - 1] == target){
    					--i;
    				}
    				while(j < high && nums[j + 1] == target){
    					++j;
    				}
    				result[0] = i;
    				result[1] = j;
    				return result;
    			}else if(nums[middle] < target){
    				low = middle + 1;
    			}else{
    				high = middle - 1;
    			}
    		}
    		result[0] = -1;
    		result[1] = -1;
    		return result;
    }
}
