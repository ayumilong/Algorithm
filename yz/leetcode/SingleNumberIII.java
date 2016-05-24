/**
 * File Name: SingleNumberIII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:36:11 PM Dec 2, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:36:11 PM Dec 2, 2015
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int results[] = new int[2];
        int flag = 0;
        for(int i = 0; i < nums.length; ++i){
            flag ^= nums[i];
        }
        flag = flag & (~(flag - 1));
        for(int i = 0; i < nums.length; ++i){
            if((flag & nums[i]) != 0){
                results[0] ^= nums[i];
            }else{
                results[1] ^= nums[i];
            }
        }
        return results;
    }
}
