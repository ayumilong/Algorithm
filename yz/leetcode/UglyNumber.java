/**
 * File Name: UglyNumber.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:26:15 PM Dec 11, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:26:15 PM Dec 11, 2015
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num == 0){
            return false;
        }
        while(num % 2 == 0){
            num /= 2;
        }
        while(num % 3 == 0){
            num /= 3;
        }
        while(num % 5 == 0){
            num /= 5;
        }
        return num == 0 || num == 1;
    }
}
