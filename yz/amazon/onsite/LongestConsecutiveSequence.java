/**
 * File Name: LongestConsecutiveSequence.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 5:01:45 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 5:01:45 PM Apr 17, 2016
 */
public class LongestConsecutiveSequence {
	//O(n)
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int max = 0;
        for(int n : nums){
        		if(!set.contains(n)){
                continue;
            }
            int left = n - 1;
            while(set.contains(left)){
                set.remove(left);
                --left;
            }
            int right = n + 1;
            while(set.contains(right)){
                set.remove(right);
                ++right;
            }
            int cur = right - left - 1;
            max = max > cur ? max : cur;
        }
        return max;
    }
	//Union Find
    public int longestConsecutive1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> fathers = new HashMap<>();
        for(int n : nums){
            fathers.put(n, n);
        }
        for(int n : nums){
            if(fathers.containsKey(n - 1)){
                union(fathers, n, n - 1);
            }
            if(fathers.containsKey(n + 1)){
                union(fathers, n, n + 1);
            }
        }
        
        HashMap<Integer, Integer> count = new HashMap<>();
        for(Map.Entry<Integer, Integer> e : fathers.entrySet()){
            int cur = find(fathers, e.getKey());
            Integer pre = count.get(cur);
            count.put(cur, pre == null ? 1 : pre + 1);
        }
        int max = 0;
        for(Integer n : count.values()){
            max = max > n ? max : n;
        }
        return max;
    }
    
    private int find(HashMap<Integer, Integer> fathers, int key){
        int root = key;
        while(root != fathers.get(root)){
            root = fathers.get(root);
        }
        int next = fathers.get(key);
        while(key != root){
            fathers.put(key, root);
            key = next;
            next = fathers.get(key);
        }
        return key;
    }
    
    private void union(HashMap<Integer, Integer> fathers, int key1, int key2){
        int f1 = find(fathers, key1);
        int f2 = find(fathers, key2);
        if(f1 != f2){
            fathers.put(f2, f1);
        }
    }
    //Sort, O(nlgn)
    public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        for(int i = 0; i < nums.length; ++i){
            int j = i + 1;
            int dup = 0;
            while(j < nums.length && (nums[j] == nums[j - 1] + 1 || nums[j] == nums[j - 1])){
                if(nums[j] == nums[j - 1]){
                    ++dup;
                }
                ++j;
            }
            max = max > (j - i - dup) ? max : (j - i - dup);
            i = j - 1;
        }
        return max;
    }
}
