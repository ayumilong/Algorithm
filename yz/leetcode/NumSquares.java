/**
 * File Name: NumSquares.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:55:44 PM Jan 6, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 7:55:44 PM Jan 6, 2016
 */
public class NumSquares {
    private int numSquares(int n, int[] counts){
        int sqrt = (int)Math.sqrt(n);
        if(sqrt * sqrt == n){
            counts[n] = 1;
            return 1;
        }
        int count = n;
        int root = 2;
        for(int i = root * root; i < n; ++root, i = root * root){
            if(counts[i] == 0){
                counts[i] = numSquares(i, counts);
            }
            if(counts[n - i] == 0){
                counts[n - i] = numSquares(n - i, counts);
            }
            if(count > counts[i] + counts[n - i]){
                count = counts[i] + counts[n - i];
            }
        }
        return count;
    }
    
    public int numSquares(int n) {
        int counts[] = new int[n + 1];
        return numSquares(n, counts);
    }
}
