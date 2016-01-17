/**
 * File Name: CountPrimes.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:56:39 PM Jan 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:56:39 PM Jan 4, 2016
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n > 1){
        		boolean primes[] = new boolean[n];
        		int count = n - 2;
        		for(int i = 2; i < n; ++i){
        		    if(primes[i]){
        		        --count;
        		        continue;
        		    }
        		    if(i > Math.sqrt(n - 1)){
        		        continue;
        		    }
        			for(int j = i * i; j < n; j += i){
        				primes[j] = true;
        			}
        		}
        		return count;
        }
    		return 0;
    }
}
