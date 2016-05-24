/**
 * File Name: SearchForARange.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:56:34 PM Jan 13, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 9:56:34 PM Jan 13, 2016
 */
public class SearchForARange {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int binarySearch(int[] A, int target, boolean reverse){
        int low = 0;
        int high = A.length;
        while(low < high){
            int middle = (low + high) / 2;
            if(A[middle] == target){
                if(reverse){
                    if(middle == A.length - 1 || A[middle + 1] > target){
                        return middle;
                    }else{
                    		low = middle + 1;
                    }
                } else{
                    if(middle == 0 || A[middle - 1] < target){
                        return middle;
                    }else{
                    		high = middle;
                    }
                }
            }else if(A[middle] > target){
                high = middle;
            }else{
                low = middle + 1;
            }
        }
        return -1;
    } 
     
     
    public int[] searchRange(int[] A, int target) {
        if(A == null || A.length == 0){
            return new int[]{-1, -1};
        }
        int first = binarySearch(A, target, false);
        int last = binarySearch(A, target, true);
        return new int[]{first, last};
    }
}
