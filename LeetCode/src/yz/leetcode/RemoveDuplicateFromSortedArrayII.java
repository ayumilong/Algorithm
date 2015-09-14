/**
 * File Name: RemoveDuplicateFromSortedArrayII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:37:40 PM Sep 10, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:37:40 PM Sep 10, 2015
 */
public class RemoveDuplicateFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int count = 1;
        boolean isDouble = false;
        for(int i = 1; i < nums.length; i++){
            if((!isDouble) && nums[i] == nums[i - 1]){
                isDouble = true;
                nums[count++] = nums[i];
                continue;
            }
            if(nums[i] != nums[i - 1]){
                isDouble = false;
                nums[count++] = nums[i];
            }
        }
        return count;          
    }
}
