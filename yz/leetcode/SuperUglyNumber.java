/**
 * File Name: SuperUglyNumber.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:58:13 PM Jan 6, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:58:13 PM Jan 6, 2016
 */
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes){
		List<LinkedList<Integer>> qs = new ArrayList<>();
		for(int i = 0; i < primes.length; ++i){
			qs.add(new LinkedList<Integer>());
		}
		qs.get(0).add(1);
		int count = 0;
		int result = 0;
		while(count < n){
			result = Integer.MAX_VALUE;
			for(int i = 0; i < primes.length; ++i){
				if(!qs.get(i).isEmpty() && result > qs.get(i).getFirst()){
					result = qs.get(i).getFirst();
				}
			}
			for(int i = 0; i < primes.length; ++i){
				if(!qs.get(i).isEmpty() && result == qs.get(i).getFirst()){
					qs.get(i).removeFirst();
					for(int j = i; j < primes.length; ++j){
						if(result > Integer.MAX_VALUE / primes[i]){
							break;
						}
						qs.get(j).add(primes[j] * result);
					}
					break;
				}
			}
			++count;
		}
		return result;
	}
	
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int results[] = new int[n];
        results[0] = 1;
        int indexes[] = new int[primes.length];
        for(int i = 1; i < n; ++i){
            results[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; ++j){
                if(results[i] > primes[j] * results[indexes[j]]){
                    results[i] = primes[j] * results[indexes[j]];
                }
            }
            for(int j = 0; j < primes.length; ++j){
                if(results[i] == primes[j] * results[indexes[j]]){
                    ++indexes[j];
                }
            }
            
        }
        return results[n - 1];
    }
    
    public int nthSuperUglyNumber1(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        int count = 1;
        while(count < n){
            ++count;
            long cur = pq.poll();
            for(int i = 0; i < primes.length; ++i){
                if(!pq.contains(cur * primes[i])){
                    pq.add(cur * primes[i]);
                }
            }
        }
        
        return pq.poll().intValue();
    }
}
