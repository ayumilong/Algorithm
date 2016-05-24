/**
 * File Name: FactorialTrailingZeros.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:55:13 PM Jan 6, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:55:13 PM Jan 6, 2016
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5){
            n = n / 5;
            count += n;
        }
        return count;
    }	
	
    public int trailingZeroes1(int n) {
        int base = 5;
        int count = 0;
        while(base <= n){
            count += n / base;
            if(base > Integer.MAX_VALUE / 5){
                break;
            }
            base *= 5;
        }
        return count;
    }
}
