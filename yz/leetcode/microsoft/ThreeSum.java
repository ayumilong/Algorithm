/**
 * File Name: ThreeSum.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:05:11 PM May 5, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:05:11 PM May 5, 2016
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i){
            if(nums[i] > 0){
                break;
            }
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                if(nums[low] + nums[high] == target){
                    results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    ++low;
                    while(low < high && nums[low] == nums[low - 1]){
                        ++low;
                    }
                }else if(nums[low] + nums[high] < target){
                    ++low;
                }else{
                    --high;
                }
            }
        }
        return results;
    }
    
    //Leetcode 16. 3Sum Closest
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE - abs(target);
        for(int i = 0; i < nums.length - 2; ++i){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                ans = abs(target - ans) < abs(target - sum) ? ans : sum;
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    ++low;
                }else{
                    --high;
                }
                
            }
        }
        return ans;
    }
    private int abs(int a){
        return a < 0 ? -a : a;
    }
    
    //Leetcode 259 3Sum Smaller
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; ++i){
            int twoSum = target - nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                if(nums[low] + nums[high] < twoSum){
                    count += (high - low);
                    ++low;
                }else{
                    --high;
                }
            }
        }
        return count;
    }
}
