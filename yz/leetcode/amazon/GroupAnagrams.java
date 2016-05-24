/**
 * File Name: GroupAnagrams.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 1:39:37 AM Apr 15, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 1:39:37 AM Apr 15, 2016
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return results;
        }
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sort = String.valueOf(c);
            if(anagrams.containsKey(sort)){
                anagrams.get(sort).add(s);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(s);
                anagrams.put(sort, temp);
            }
        }
        for(List<String> l : anagrams.values()){
            Collections.sort(l);
            results.add(l);
        }
        return results;
    }
    
    public static void main(String args[]){
    		int[] nums = {1, -5, -1, 2, -3, 0};
    		seperatePositiveAndNegative(nums);
    		System.out.println(Arrays.toString(nums));
    }
    
    public static void seperatePositiveAndNegative(int[] nums){
    		if(nums == null || nums.length == 0){
    			return;
    		}
    		for(int i = 0; i < nums.length; ++i){
    			if(nums[i] >= 0){
    				continue;
    			}
    			int j = i - 1;
    			int cur = nums[i];
    			while(j >= 0 && nums[j] >= 0){
    				nums[j + 1] = nums[j];
    				--j;
    			}
    			nums[j + 1] = cur;
    		}
    }
}
