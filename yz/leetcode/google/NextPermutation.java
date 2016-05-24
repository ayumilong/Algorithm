/**
 * File Name: NextPermutation.java
 * Package Name: yz.leetcode.google
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:40:14 PM May 17, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.google;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:40:14 PM May 17, 2016
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        int i = nums.length - 2;
        for(; i >= 0; --i){
            if(nums[i] < nums[i + 1]){
                break;
            }
        }
        if(i == -1){//5,4,3,2,1
            Arrays.sort(nums);
        }else{
            reverse(nums, i + 1);
            findAndSwap(nums, i);
        }
    }
    
    //nums is in descending order from start to nums.length - 1
    private void reverse(int[] nums, int start){//Reverse the right descending order part of an array
        int end = nums.length - 1;
        while(start < end){
            swap(nums, start, end);
            ++start;
            --end;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void findAndSwap(int[] nums, int i){//Do binary search and swap
        int low = i + 1;
        int high = nums.length;
        while(low < high){
            int middle = low + (high - low) / 2;
            if(nums[middle] == nums[i]){
                low = middle + 1; //Return the index of the first number greater than nums[i]
                break;
            }
            if(nums[middle] > nums[i]){
                high = middle;
            }else{
                low = middle + 1;
            }
        }
        //2,2,1,2,2,3,4,5,7 - low will be 4 and should be 5 (index)
        while(low < nums.length && nums[low] == nums[i]){//[2,2,7,5,4,3,2,2,1], find the first index of number greater than nums[i]
            ++low;
        }
        swap(nums, i, low);
    }
}
