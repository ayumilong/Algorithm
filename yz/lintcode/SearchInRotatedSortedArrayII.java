/**
 * File Name: SearchInRotatedSortedArrayII.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:26:26 PM Jan 14, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 9:26:26 PM Jan 14, 2016
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0){
            return false;
        }
        int low = 0;
        int high = A.length;
        while(low < high){
            int middle = (low + high) / 2;
            if(A[middle] == target){
                return true;
            }
            if(A[middle] == A[high - 1]){
                --high;
            }else if(A[middle] > A[high - 1]){ //middle is in X
                if(target >= A[low] && target <= A[middle]){
                    high = middle;
                }else{
                    low = middle + 1;
                }
            }else{//middle is in Y
                if(target >= A[middle] && target <= A[high - 1]){
                    low = middle + 1;
                }else{
                    high = middle;
                }
            }
        }
        return false;
    }
}
