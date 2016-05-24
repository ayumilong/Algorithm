/**
 * File Name: KClosestNumbersInSortedArray.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:21:42 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:21:42 PM Apr 17, 2016
 */
public class KClosestNumbersInSortedArray {
	//O(lgn + k), only for sorted array
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if(A == null || A.length == 0 || k < 1 || k > A.length){
            return new int[0];
        }
        int[] result = new int[k];
        int low = 0;
        int high = A.length;
        while(low < high){
            int middle = low + (high - low) / 2;
            if(A[middle] == target){
                low = middle;
                high = middle;
                break;
            }else if(A[middle] > target){
                high = middle;
            }else{
                low = middle + 1;
            }
        }
      //low will be the last number in A that less than target
      //high will be the first number equal or greater than target
        low = low - 1;
        for(int i = 0; i < k; ++i){
            if(low >= 0 && high < A.length){
                result[i] = (target - A[low]) <= (A[high] - target) ? A[low--] : A[high++];
            }else if(low >= 0){
                result[i] = A[low--];
            }else{
                result[i] = A[high++];
            }
        }
        return result;
    }
	//Use PriorityQueue, Time: O(nlgk), This will also work for unsorted array
    public int[] kClosestNumbers1(int[] A, int target, int k) {
        if(A == null || A.length == 0 || k < 1){
            return new int[0];
        }
        int[] result = new int[k];
        PriorityQueue<Difference> pq = new PriorityQueue<>(1, new Comparator<Difference>(){
            public int compare(Difference d1, Difference d2){
                if(d1.diff != d2.diff){
                    return d2.diff - d1.diff;
                }else{
                    return d2.num - d1.num;
                }
            }
            
        });
        for(int n : A){
            pq.offer(new Difference(Math.abs(n - target), n));
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i = k - 1; i >= 0; --i){
            result[i] = pq.poll().num;
        }
        return result;
    }
    
    private class Difference{
        int diff;
        int num;
        Difference(int d, int n){
            diff = d;
            num = n;
        }
    }
}
