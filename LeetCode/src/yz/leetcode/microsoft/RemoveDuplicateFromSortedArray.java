/**
 * File Name: RemoveDuplicateFromSortedArray.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:09:59 PM May 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

/**
 * @author Yaolin Zhang
 * @time 9:09:59 PM May 4, 2016
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] > nums[count]){
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }
}
