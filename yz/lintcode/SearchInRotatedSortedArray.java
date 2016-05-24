/**
 * File Name: SearchInRotatedSortedArray.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:44:03 PM Jan 13, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 9:44:03 PM Jan 13, 2016
 */
public class SearchInRotatedSortedArray {

    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
        int low = 0;
        int high = A.length;
        while(low < high){
            int middle = (low + high) / 2;
            if(A[middle] == target){
                return middle;
            }
            //Think A as XY, which X is a ascending sequence and Y is another ascending sequence and all X's numbers are bigger than Y's
            if(A[middle] > A[high - 1]){ //middle is in X
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
        return A[low] == target ? low : -1;
    }

    public int binarySearch(int[] A, int target, int low, int high){
        while(low < high){
            int middle = (low + high) / 2;
            if(A[middle] == target){
                return middle;
            }
            if(A[middle] > target){
                high = middle;
            }else{
                low = middle + 1;
            }
        }
        return -1;
    }
     
    public int search1(int[] A, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
        int low = 0;
        int high = A.length - 1;
        while(low < high){
            int middle = (low + high) / 2;
            if(A[middle] > A[high]){
                low = middle + 1;
            }else{
                high = middle;
            }
        }
        int start = low;
        if(A[start] == target){
            return start;
        }
        if(A[start] > target){
            return -1;
        }
        if(A[A.length - 1] < target){
            low = 0;
            high = start;
        }else{
            low = start;
            high = A.length;
        }
        return binarySearch(A, target, low, high);
    }
}
