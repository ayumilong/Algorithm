/**
 * File Name: MedianOfTwoSortedArray.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 3:22:34 PM Jan 31, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 3:22:34 PM Jan 31, 2016
 */
public class MedianOfTwoSortedArray {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if(A.length == 0 && B.length == 0){
            return 0.0;
        }
        double k1 = findKth(A, B, (A.length + B.length) / 2 + 1);
        double k2 = k1;
        if((A.length + B.length) % 2 == 0){//Even number
            k2 = findKth(A, B, (A.length + B.length) / 2);
        }
        return (k1 + k2) / 2;
    }
    
    private double findKth(int[] A, int[] B, int k){
        int aLen = A.length;
        int bLen = B.length;
        int aStart = 0;
        int bStart = 0;
        while(k != 1 && aStart < aLen && bStart < bLen){
            int aValue = (aStart + k / 2 > aLen) ? A[aLen - 1] : A[aStart + k / 2 - 1];
            int bValue = (bStart + k / 2 > bLen) ? B[bLen - 1] : B[bStart + k / 2 - 1];
            if(aValue < bValue){
                aStart += k / 2;
            }else{
                bStart += k / 2;
            }
            k = k - k / 2;
        }
        if(aStart >= aLen){
            return B[bStart + k - (aLen - aStart) - 1]; //Will only throw (aLen - aStart) numbers
        }
        if(bStart >= bLen){
            return A[aStart + k - (bLen - bStart) - 1];
        }
        return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
    }
}
