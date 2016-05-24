/**
 * File Name: FindPeakElement.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:35:34 PM Jan 13, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 8:35:34 PM Jan 13, 2016
 */
public class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length < 3){
            return -1;
        }
        int low = 1;
        int high = A.length - 1;
        while (low < high){
            int middle = (low + high) / 2;
            if (A[middle] > A[middle - 1] && A[middle] > A[middle + 1]){
                return middle;
            }
            if (A[middle] > A[middle - 1]){ // A[middle] < A[middle + 1] is definitely true
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return -1;
    }
}
