/**
 * File Name: FirstPositionOfTarget.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:57:21 PM Jan 12, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 10:57:21 PM Jan 12, 2016
 */
public class FirstPositionOfTarget {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length;
        while (low < high){
            int middle = (low + high) / 2;
            if (nums[middle] > target){
                high = middle;
            } else if (nums[middle] < target){
                low = middle + 1;
            } else {
                if (middle == 0 || nums[middle - 1] < target){
                    return middle;
                } else {
                    high = middle;
                }
            }
        }
        return -1;
    }
}
