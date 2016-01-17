/**
 * File Name: SingleNumberII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:51:55 PM Dec 2, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 8:51:55 PM Dec 2, 2015
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for(int i = 0; i < nums.length; ++i){
            twos |= (ones & nums[i]);
            ones ^= nums[i];
            threes = (ones & twos);
            ones &= ~threes;
            twos &= ~threes;
            //System.out.println(Integer.toBinaryString(ones) + " " + 
            //Integer.toBinaryString(twos) + " " + Integer.toBinaryString(threes));
        }
        return ones;
    }
}
