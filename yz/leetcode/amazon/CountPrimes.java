/**
 * File Name: CountPrimes.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:46:08 PM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

/**
 * @author Yaolin Zhang
 * @time 8:46:08 PM Apr 14, 2016
 */
public class CountPrimes {
	//Sieve of Eratosthenes
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        boolean[] notPrimes = new boolean[n + 1];
        int count = n - 2;
        for(int i = 2; i < n; ++i){
            if(notPrimes[i]){
                --count;
                continue;
            }
            if(i > n / i){
                continue;
            }
            for(int j = i * i; j < n; j += i){
                notPrimes[j] = true;
            }
        }
        return count;
    }
}
