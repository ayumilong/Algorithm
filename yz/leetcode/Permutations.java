/**
 * File Name: Permutations.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:31:30 PM Jan 10, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:31:30 PM Jan 10, 2016
 */
public class Permutations {
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        List<Integer> list = new LinkedList<>();
        for(int num : nums){
            list.add(num);
        }
        results.add(list);
        permute(nums, results, 0);
        
        return results;
    }
    
    private void permute(int[] nums, List<List<Integer>> results, int start){
        if(start < nums.length - 1){
            permute(nums, results, start + 1);
        }
        for(int i = start + 1; i < nums.length; ++i){
            swap(nums, start, i);
            List<Integer> list = new LinkedList<>();
            for(int num : nums){
                list.add(num);
            }
            results.add(list);
            permute(nums, results, start + 1);
            swap(nums, start, i);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
	
    private void getPermutes(int[] nums, List<List<Integer>> results, List<Integer> list, int[] flags, int start){
        if(start == nums.length){
            results.add(new LinkedList<>(list));
            return;
        }
        int count = 0;
        for(int i = 0; i < nums.length; ++i){
            if(flags[i] == 1){//Has add it
                continue;
            }
            list.add(nums[i]);
            flags[i] = 1;
            getPermutes(nums, results, list, flags, start + 1);
            flags[i] = 0;
            list.remove(list.size() - 1);
            if(++count == nums.length - start){
                return;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if(nums == null || nums.length == 0){
        		return results;
        }
        List<Integer> list = new LinkedList<>();
        int[] flags = new int[nums.length];
        getPermutes(nums, results, list, flags, 0);
        return results;
    }
}
