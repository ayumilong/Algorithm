/**
 * File Name: ContainsDuplicate.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 4:24:01 PM Sep 6, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 4:24:01 PM Sep 6, 2015
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
    		if(nums == null || nums.length == 0){
    			return false;
    		}
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
        		if(map.containsKey(nums[i])){
        			return true;
        		}else{
        			map.put(nums[i], true);
        		}
        }
    		return false;
    }
}
