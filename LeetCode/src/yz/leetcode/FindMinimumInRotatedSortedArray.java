/**
 * File Name: FindMinimumInRotatedSortedArray.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:34:18 PM Sep 10, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:34:18 PM Sep 10, 2015
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int middle = (low + high) / 2;
            if(nums[middle] >= nums[low] && nums[middle] >= nums[high]){
                low = middle + 1;
            }else{
                high = middle;
            }
        }
        return nums[low];
    }
}
