/**
 * File Name: ContainisDuplicateII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:17:45 PM Sep 9, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:17:45 PM Sep 9, 2015
 */
public class ContainisDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    		if(nums == null || k < 1){
    			return false;
    		}
    		HashMap<Integer, Integer> map = new HashMap<>();
    		for(int i = 0; i < nums.length; ++i){
    			Integer preIndex = map.put(nums[i], i);
    			if(preIndex != null){
    				if(i - preIndex <= k){
    					return true;
    				}
    			}
    		}
    		return false;
    }
}
