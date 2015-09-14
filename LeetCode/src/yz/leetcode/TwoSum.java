/**
 * File Name: TwoSum.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:56:19 AM Sep 12, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.HashMap;

/**
 * @author Yaolin Zhang
 * @time 10:56:19 AM Sep 12, 2015
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    		HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
        		if(map.containsKey(target - nums[i])){
        			int result[] = {map.get(target - nums[i]) + 1, i + 1};
        			return result;
        		}else{
        			map.put(nums[i], i);
        		}
        }
    		return new int[0];
    }
}
