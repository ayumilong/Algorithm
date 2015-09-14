/**
 * File Name: RemoveElement.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:04:50 PM Sep 6, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 10:04:50 PM Sep 6, 2015
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
    		if(nums == null || nums.length == 0){
    			return 0;
    		}
    		int i = 0;
    		for(int j = nums.length - 1; i <= j; ++i){
    			if(nums[i] == val){
    				while(i < j && nums[j] == val){
    					--j;
    				}
    				if(i == j){
    					return i;
    				}
    				int temp = nums[i];
    				nums[i] = nums[j];
    				nums[j] = temp;
    				--j;
    			}
    		}
    		return i;
    }
}
