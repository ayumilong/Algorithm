/**
 * File Name: TotalOccuranceOfTarget.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:14:33 PM Jan 12, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 11:14:33 PM Jan 12, 2016
 */
public class TotalOccuranceOfTarget {
    public int binarySearch(int[] nums, int target, boolean reverse) {
        int low = 0;
        int high = nums.length;
        while (low < high){
            int middle = (low + high) / 2;
            if (nums[middle] > target){
                high = middle;
            } else if (nums[middle] < target){
                low = middle + 1;
            } else {
                if (reverse){
                    if (middle == nums.length - 1 || nums[middle + 1] > target){
                        return middle;
                    } else {
                        low = middle + 1;
                    }
                } else {
                    if (middle == 0 || nums[middle - 1] < target){
                        return middle;
                    } else {
                        high = middle;
                    }
                }
            }
        }
        return -1;
    }

    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0){
            return 0;
        }
        int first = binarySearch(A, target, false);
        if (first == -1){
            return 0;
        }
        int last = binarySearch(A, target, true);
        return last - first + 1;
    }
}
