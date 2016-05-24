/**
 * File Name: SpiralMatrix.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:05:20 PM Apr 1, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:05:20 PM Apr 1, 2016
 */


public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
	    // @Lu
	    List<Integer> list = new ArrayList<>();
	    if(matrix == null || matrix.length == 0){
	        return list;
	    }
	    int top = 0;
	    int bottom = matrix.length - 1;
	    int left = 0;
	    int right = matrix[0].length - 1;
	    while(top <= bottom && left <= right){
	            for(int i = left; i <= right; i++){
	                list.add(matrix[top][i]);
	            }
	            for(int i = top + 1; i <= bottom; i++){
	                list.add(matrix[i][right]);
	            }
	            if(top == bottom || left == right){
	                break;
	            }
	            for(int i = right - 1; i >= left; i--){
	                list.add(matrix[bottom][i]);
	            }
	            for(int i = bottom - 1; i >= top + 1;i--){
	                list.add(matrix[i][left]);
	            }
	            top++;
	            bottom--;
	            left++;
	            right--;
	    }
	    return list;
	}
    public List<Integer> spiralOrder1(int[][] matrix) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return result;
        }
        int startX = 0;
        int startY = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while(rows > 0 & cols > 0){
            int i = startX;
            int j = startY;
            int endX = i + rows;
            int endY = j + cols;
            
            while(j < endY){
                result.add(matrix[i][j++]);
            }
            --j;
            ++i;
            while(i < endX){
                result.add(matrix[i++][j]);
            }
            if(rows == 1 || cols == 1){
                break;
            }
            --i;
            --j;
            while(j > startY){
                result.add(matrix[i][j--]);
            }
            while(i > startX){
                result.add(matrix[i--][j]);
            }
            rows -= 2;
            cols -= 2;
            ++startX;
            ++startY;
        }
        return result;
    }
}
