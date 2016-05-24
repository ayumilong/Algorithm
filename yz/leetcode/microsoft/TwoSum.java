/**
 * File Name: TwoSm.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 5:33:50 PM May 5, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 5:33:50 PM May 5, 2016
 */
public class TwoSum {
	//nums is unsorted
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(map.containsKey(nums[i])){
                int[] results = {map.get(nums[i]), i};
                return results;
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
    
    //numbers is sorted
    public int[] twoSum1(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
            return new int[0];
        }
        int low = 0;
        int high = numbers.length - 1;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                int[] results = {low, high};
                return results;
            }else if(sum < target){
                ++low;
            }else{
                --high;
            }
        }
        return new int[0];
    }
}
