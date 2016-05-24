/**
 * File Name: Permutation.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:38:19 PM May 17, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:38:19 PM May 17, 2016
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        boolean[] flags = new boolean[nums.length];
        helper(nums, flags, results, new ArrayList<Integer>());
        return results;
    }
    
    private void helper(int[] nums, boolean[] flags, List<List<Integer>> results, List<Integer> one){
        if(one.size() == nums.length){
            results.add(new ArrayList<>(one));
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(flags[i]){
                continue;
            }
            flags[i] = true;
            one.add(nums[i]);
            helper(nums, flags, results, one);
            flags[i] = false;
            one.remove(one.size() - 1);
        }
    }
    
    //Another solution, repeatedly swap two numbers in nums
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
    
    //Permutation II with duplicate numbers: [1,1,2]
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        Arrays.sort(nums);
        boolean[] flags = new boolean[nums.length];
        helper1(nums, flags, results, new ArrayList<>());
        return results;
    }
    
    private void helper1(int[] nums, boolean[] flags, List<List<Integer>> results, List<Integer> one){
        if(one.size() == nums.length){
            results.add(new ArrayList<>(one));
            return;
        }
        for(int i = 0; i < nums.length; ++i){
        		//If current number has been add to list one
        		//Or if the previous number is the same with current number and 
        		//the previous has not been add to list one
            if((i != 0 && !flags[i - 1] && nums[i] == nums[i - 1]) || flags[i]){
                continue;
            }
            flags[i] = true;
            one.add(nums[i]);
            helper(nums, flags, results, one);
            one.remove(one.size() - 1);
            flags[i] = false;
        }
    }
    
    
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        List<Integer> list = new LinkedList<>();
        for(int num : nums){
            list.add(num);
        }
        results.add(list);
        permute1(nums, results, 0);
        return results;
    }
    
    private void permute1(int[] nums, List<List<Integer>> results, int start){
        if(start < nums.length - 1){
            permute(nums, results, start + 1);
        }
        HashSet<Integer> flags = new HashSet<>();
        flags.add(nums[start]);
        for(int i = start + 1; i < nums.length; ++i){
            if(flags.contains(nums[i])){
                continue;
            }
            flags.add(nums[i]);
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
}
