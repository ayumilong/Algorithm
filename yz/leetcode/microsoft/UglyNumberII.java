/**
 * File Name: UglyNumberII.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 3:46:17 PM May 7, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 3:46:17 PM May 7, 2016
 */
public class UglyNumberII {
	//DP
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        int[] indexes = {0, 0, 0};
        int[] primes = {2, 3, 5};
        uglyNumbers[0] = 1;
        for(int i = 1; i < n; ++i){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < indexes.length; ++j){
                int cur = uglyNumbers[indexes[j]] * primes[j];
                min = min < cur ? min : cur;
            }
            uglyNumbers[i] = min;
            for(int j = 0; j < indexes.length; ++j){
                if(min == uglyNumbers[indexes[j]] * primes[j]){
                    ++indexes[j];
                }
            }
        }
        return uglyNumbers[n - 1];
    }
	
	//Use PriorityQueue and HashSet
    public int nthUglyNumber1(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int primes[] = { 2, 3, 5 };
        pq.offer(1L);
        int count = 1;
        HashSet<Long> uniqe = new HashSet<>();
        while(count < n){
            ++count;
            long cur = pq.poll();
            for(int p : primes){
                if(uniqe.add(cur * p)){
                    pq.add(cur * p);
                }
            }
        }
        return pq.poll().intValue();
    }
    
    //DP
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglyNumbers = new int[n];
        int[] indexes = new int[primes.length];
        uglyNumbers[0] = 1;
        for(int i = 1; i < n; ++i){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < indexes.length; ++j){
                int cur = uglyNumbers[indexes[j]] * primes[j];
                min = min < cur ? min : cur;
            }
            uglyNumbers[i] = min;
            for(int j = 0; j < indexes.length; ++j){
                if(min == uglyNumbers[indexes[j]] * primes[j]){
                    ++indexes[j];
                }
            }
        }
        return uglyNumbers[n - 1];       
    }
}
