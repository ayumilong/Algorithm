/**
 * File Name: KthLargestElementInAnArray.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:00:49 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

/**
 * @author Yaolin Zhang
 * @time 11:00:49 PM Apr 17, 2016
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        while(k >= 1 && start < end){
            int middle = partition(nums, start, end);
            if(end - middle + 1 == k){
                return nums[middle];
            }else if(end - middle + 1 > k){
                start = middle + 1;
            }else{
                k -= (end - middle + 1);
                end = middle - 1;
            }
        }
        return nums[start];
    }
    
    private int partition(int[] nums, int start, int end){
        int cur = nums[start];
        while(start < end){
            while(start < end && nums[end] > cur){
                --end;
            }
            nums[start] = nums[end];
            while(start < end && nums[start] <= cur){
                ++start;
            }
            nums[end] = nums[start];
        }
        nums[start] = cur;
        return start;
    }
}
