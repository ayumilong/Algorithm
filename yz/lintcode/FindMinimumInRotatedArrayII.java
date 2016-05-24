/**
 * File Name: FindMinimumInRotatedArrayII.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:56:24 PM Jan 14, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 7:56:24 PM Jan 14, 2016
 */
public class FindMinimumInRotatedArrayII {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
	private int findMin(int[] num, int low, int high){
	    if(low > high){
	        return Integer.MAX_VALUE;
	    }
		if(low == high){
			return num[low];
		}
		int left = findMin(num, low, (low + high) / 2);
		int right = findMin(num, (low + high) / 2 + 1, high);
		return left > right ? right : left;
	}
	
    public int findMin(int[] num) {
        if(num == null || num.length == 0){
            return Integer.MAX_VALUE;
        }
        return findMin(num, 0, num.length - 1);
    }
    
    public int findMin1(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low < high) {
            int middle = low + (high - low) / 2;

            if (nums[middle] > nums[high]) {
                low = middle + 1;
            } else if (nums[middle] < nums[high]) {
                high = middle;
            } else {
                high--;
            }
        }

        return nums[low];
    }
}
