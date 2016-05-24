/**
 * File Name: CountPrimes.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:41:08 AM May 7, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

/**
 * @author Yaolin Zhang
 * @time 12:41:08 AM May 7, 2016
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        for(int i = 2; i * i < n; ++i){
            if(notPrimes[i]){
                continue;
            }
            for(int j = i * i; j < n; j += i){
                notPrimes[j] = true;
            }
        }
        int count = 0;
        for(int i = 2; i < n; ++i){
            if(!notPrimes[i]){
                ++count;
            }
        }
        return count;
    }
}
