/**
 * File Name: RotateArray.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:41:42 PM May 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

/**
 * @author Yaolin Zhang
 * @time 11:41:42 PM May 4, 2016
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
	
	
	
	
    public void rotate1(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        k = k % nums.length;
        int count = 0;
        for(int i = 0; i < k; ++i){
            count += rotate(nums, i, k);
            if(count == nums.length){
                break;
            }
        }
    }
    private int rotate(int[] nums, int start, int k){
        int i = start;
        int pre = nums[start];
        int count = 1;
        while((i = (i + k) % nums.length) != start){
            ++count;
            int temp = nums[i];
            nums[i] = pre;
            pre = temp;
        }
        nums[start] = pre;
        return count;
    }
    private int getGcd(int n1, int n2){
		if(n2 == 0){
			return n1;
		}
		return getGcd(n2, n1 % n2);
	}
}
