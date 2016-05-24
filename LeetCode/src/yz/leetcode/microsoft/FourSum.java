/**
 * File Name: FourSum.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 5:30:35 PM May 6, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 5:30:35 PM May 6, 2016
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; ++i){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; ++j){
                if(j != i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int twoSum = target - nums[i] - nums[j];
                int low = j + 1;
                int high = nums.length - 1;
                while(low < high){
                    if(nums[low] + nums[high] == twoSum){
                        results.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        ++low;
                        while(low < high && nums[low] == nums[low - 1]){
                            ++low;
                        }
                    }else if(nums[low] + nums[high] < twoSum){
                        ++low;
                    }else{
                        --high;
                    }
                }
            }
        }
        return results;
    }
}
