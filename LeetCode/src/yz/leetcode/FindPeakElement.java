/**
 * File Name: FindPeakElement.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:31:03 PM Jan 13, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:31:03 PM Jan 13, 2016
 */
public class FindPeakElement {
    public int findPeakElement(int[] A) {
        if (A == null || A.length == 0){
            return -1;
        }
        int low = 0;
        int high = A.length;
        while (low < high){
            int middle = (low + high) / 2;
            double left = (middle - 1) < 0 ? Double.NEGATIVE_INFINITY : A[middle - 1];
            double right = (middle + 1) > A.length - 1 ? Double.NEGATIVE_INFINITY : A[middle + 1];
            System.out.println(left + " " + right);
            if (A[middle] > left && A[middle] > right){
                return middle;
            }
            if (A[middle] > left){ // A[middle] < A[middle + 1] is definitely true
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return -1;
    }
}
