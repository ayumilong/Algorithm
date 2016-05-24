/**
 * File Name: SearchA2DMatrix.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:37:32 PM Sep 12, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:37:32 PM Sep 12, 2015
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
        		return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows - 1;
        //Search a suitable row
        while(low <= high){
        		int middle = low + (high - low) / 2;
        		if(matrix[middle][0] > target){
        			high = middle - 1;
        		}else if(matrix[middle][cols - 1] < target){
        			low = middle + 1;
        		}else{
        			low = middle;
        			break;
        		}
        }
        int correctRow = low;
        if(correctRow == rows || matrix[correctRow][0] > target){
        		return false;
        }
        low = 0;
        high = cols - 1;
        while(low <= high){
        		int middle = low + (high - low) / 2;
        		if(matrix[correctRow][middle] == target){
        			return true;
        		}else if(matrix[correctRow][middle] > target){
        			high = middle - 1;
        		}else{
        			low = middle + 1;
        		}
        }
    		return false;
    }
    
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length == 0){
        		return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows - 1;
        //Search a suitable row
        while(low <= high){
        		int middle = low + (high - low) / 2;
        		if(matrix[middle][cols - 1] == target){
        			return true;
        		}else if(matrix[middle][cols - 1] > target){
        			high = middle - 1;
        		}else{
        			low = middle + 1;
        		}
        }
        int correctRow = low;
        if(correctRow == rows || matrix[correctRow][0] > target){
        		return false;
        }
        low = 0;
        high = cols - 1;
        while(low <= high){
        		int middle = low + (high - low) / 2;
        		if(matrix[correctRow][middle] == target){
        			return true;
        		}else if(matrix[correctRow][middle] > target){
        			high = middle - 1;
        		}else{
        			low = middle + 1;
        		}
        }
    		return false;
    }
}
