/**
 * File Name: UglyNumberII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:22:11 PM Dec 31, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:22:11 PM Dec 31, 2015
 */
public class UglyNumberII {
    private int uglyNumbers[] = new int[2000];
    boolean firstTime = true;
    
    public int nthUglyNumber(int n) {
		if(firstTime){
		    firstTime = false;
		    int count = 0;
		    uglyNumbers[0] = 1;
		    int l2 = 0;
		    int l3 = 0;
		    int l5 = 0;
		    for(int i = 1; i < 2000; ++i){
		        int cur2 = 2 * uglyNumbers[l2];
		        int cur3 = 3 * uglyNumbers[l3];
		        int cur5 = 5 * uglyNumbers[l5];
		        int min = cur2;
		        if(min > cur3){
		            min = cur3;
		        }
		        if(min > cur5){
		            min = cur5;
		        }
		        l2 += (min == cur2 ? 1 : 0);
		        l3 += (min == cur3 ? 1 : 0);
		        l5 += (min == cur5 ? 1 : 0);
		        uglyNumbers[++count] = min;
		    }
		}
		return uglyNumbers[n - 1];
	}
    
    public int nthUglyNumber2(int n) {
		if (n == 1) {
			return 1;
		}
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int primes[] = {2, 3, 5};
		Long result = 1L;
		pq.add(1L);
		for(int i = 0; i < n; ++i){
		    result = pq.poll();
		    for(int prime : primes){
		        Long cur = prime * result;
		        if(!pq.contains(cur)){
		            pq.add(cur);
		        }
		    }
		}
		return result.intValue();
	}
    
	public int nthUglyNumber1(int n) {
		if (n == 1) {
			return 1;
		}
		ArrayList<Integer> L2 = new ArrayList<>();
		ArrayList<Integer> L3 = new ArrayList<>();
		ArrayList<Integer> L5 = new ArrayList<>();
		L2.add(1);
		L3.add(1);
		L5.add(1);

		int curL2 = 0;
		int curL3 = 0;
		int curL5 = 0;

		int count = 1;
		while (true) {
			++count;
			int L22 = L2.get(curL2) > Integer.MAX_VALUE / 2 ? Integer.MAX_VALUE : 2 * L2.get(curL2);
			int L23 = Integer.MAX_VALUE;
			for (int i = curL3; i < L3.size(); ++i) {
				if (L3.get(curL3) <= Integer.MAX_VALUE / 2 && 2 * L3.get(i) > L2.get(L2.size() - 1)) {
					L23 = 2 * L3.get(i);
					break;
				}
			}
			int L25 = (L5.get(curL5) > Integer.MAX_VALUE / 2 || 2 * L5.get(curL5) <= L2.get(L2.size() - 1))
					? Integer.MAX_VALUE : 2 * L5.get(curL5);

			int minL2 = Math.min(L22, Math.min(L23, L25));

			int L33 = L3.get(curL3) > Integer.MAX_VALUE / 3 ? Integer.MAX_VALUE : 3 * L3.get(curL3);
			int L35 = (L5.get(curL5) > Integer.MAX_VALUE / 3 || 3 * L5.get(curL5) <= L3.get(L3.size() - 1))
					? Integer.MAX_VALUE : 3 * L5.get(curL5);

			int minL3 = Math.min(L33, L35);

			int minL5 = L5.get(curL5) > Integer.MAX_VALUE / 5 ? Integer.MAX_VALUE : 5 * L5.get(curL5);

			int min = Math.min(minL2, Math.min(minL3, minL5));

			if (count == n) {
				for (int i = 0; i < L2.size(); ++i) {
					System.out.print(L2.get(i) + " ");
				}
				System.out.println();
				for (int i = 0; i < L3.size(); ++i) {
					System.out.print(L3.get(i) + " ");
				}
				System.out.println();
				for (int i = 0; i < L5.size(); ++i) {
					System.out.print(L5.get(i) + " ");
				}
				System.out.println();
				return min;
			}

			if (min == minL2) {
				if (minL2 == L22) {
					++curL2;
				}
				L2.add(minL2);
			} else if (min == minL3) {
				if (minL3 == L33) {
					++curL3;
				}
				L3.add(minL3);
			} else if (min == minL5) {
				++curL5;
				L5.add(minL5);
			}
		}
	}
}
