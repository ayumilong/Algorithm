/**
 * File Name: TwoSumIIInputArrayIsSorted.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:56:17 PM Apr 13, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

/**
 * @author Yaolin Zhang
 * @time 11:56:17 PM Apr 13, 2016
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
            return new int[0];
        }
        int low = 0;
        int high = numbers.length - 1;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[]{low + 1, high + 1};
            }else if(sum < target){
                ++low;
            }else{
                --high;
            }
        }
        return new int[0];
    }
}
