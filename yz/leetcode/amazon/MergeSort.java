/**
 * File Name: MergeSort.java
 * Package Name: yz.amazon.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:53:50 PM Apr 18, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

/**
 * @author Yaolin Zhang
 * @time 7:53:50 PM Apr 18, 2016
 */
public class MergeSort {
    public static int[] Puzzle(int[] a) {
        mergeSort(a);
        return a;
    }
    
    public static void mergeSort(int[] a){
      int jump = 1;
      while(jump < a.length){
        for(int i = 0; i < a.length - jump; i += jump * 2){
          merge(a, i, i + jump - 1, i + jump, i + 2 * jump - 1);
        }
        jump *= 2;
      }
    }
    
    public static void merge(int[] a, int s1, int e1, int s2, int e2){
      if(s1 == e1){
        if(a[s1] > a[s2]){
          swap(a, s1, s2);
        }
        return;
      }
      e2 = e2 < a.length ? e2 : a.length - 1;
      int[] b = new int[e2 - s1 + 1];
      int i = 0;
      int start = s1;
      while(s1 <= e1 || s2 <= e2){
          if(s1 > e1){
            b[i++] = a[s2++];  
          }else if(s2 > e2){
            b[i++] = a[s1++];  
          }else{
            if(a[s1] <= a[s2]){
                b[i++] = a[s1++];
            }else{
                b[i++] = a[s2++];
            }
          }
      }
      for(i = 0; i < b.length; ++i){
          a[start + i] = b[i];
      }
    }
    
    public static void swap(int[] a, int i, int j){
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
}
