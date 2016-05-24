/**
 * File Name: PermutationsII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:43:07 PM Jan 10, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:43:07 PM Jan 10, 2016
 */
public class PermutationsII {
    private void getPermutes(int[] nums, List<List<Integer>> results, List<Integer> list, int[] flags, int start){
        if(start == nums.length){
            results.add(new LinkedList<>(list));
            return;
        }
        int count = 0;
        HashSet<Integer> numbers = new HashSet<>();
        for(int i = 0; i < nums.length; ++i){
            if(flags[i] == 1){//Has add it
                continue;
            }
            ++count;
            if(numbers.contains(nums[i])){
                continue;
            }    
            numbers.add(nums[i]);
            list.add(nums[i]);
            flags[i] = 1;
            getPermutes(nums, results, list, flags, start + 1);
            flags[i] = 0;
            list.remove(list.size() - 1);
            if(count == nums.length - start){
                return;
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
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
