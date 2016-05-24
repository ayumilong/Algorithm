/**
 * File Name: BitwiseAndOfNumbersRange.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:35:17 PM Dec 1, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 10:35:17 PM Dec 1, 2015
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        int i = 31;
        for(; i >= 0; --i){
            if((n & (1 << i)) != (m & (1 << i))){
                break;
            }
            result |= (n & (1 << i));
        }
        return result;
    }
    public int rangeBitwiseAnd1(int m, int n) {
        int i = 0;
        for(; m != n; ++i){
            m >>= 1;
            n >>= 1;
        }
        return m << i;
    }
}
