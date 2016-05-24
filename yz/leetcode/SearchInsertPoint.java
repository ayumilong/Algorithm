/**
 * File Name: SearchInsertPoint.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:35:29 PM Sep 10, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:35:29 PM Sep 10, 2015
 */
public class SearchInsertPoint {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        if(nums[0] > target){
            return 0;
        }
        if(nums[nums.length - 1] < target){
            return nums.length;
        }
        int low = 0;
        int high = nums.length;
        while(low < high){
            int middle = (low + high) / 2;
            if(target == nums[middle]){
                return middle;
            }
            if(target < nums[middle]){
                high = middle;
            }else{
                low = middle + 1;
            }
        }
        return low;
    }
}
