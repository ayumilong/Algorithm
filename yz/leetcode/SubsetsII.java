/**
 * File Name: SubsetsII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 5:10:21 PM Jan 10, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 5:10:21 PM Jan 10, 2016
 */
public class SubsetsII {
    private void subsets(int[] nums, List<List<Integer>> results, List<Integer> list, int start){
        if(start == nums.length){
            results.add(new LinkedList<>(list));
            return;
        }
        list.add(nums[start]);
        subsets(nums, results, list, start + 1);
        list.remove(list.size() - 1);
        while(start < nums.length - 1 && nums[start] == nums[start + 1]){
            ++start;
        }
        subsets(nums, results, list, start + 1);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        subsets(nums, results, list, 0);
        return results;
    }
	
    private void subsets1(int[] nums, List<List<Integer>> results, List<Integer> list, int start){
        results.add(new LinkedList<>(list));
        for(int i = start; i < nums.length; ++i){
            if(i != start && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            subsets1(nums, results, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        subsets1(nums, results, list, 0);
        return results;
    }
}
