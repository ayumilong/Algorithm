/**
 * File Name: SetMatrixZeroes.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 3:45:48 PM Sep 12, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 3:45:48 PM Sep 12, 2015
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0){
        		return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowOneZero = false;
        boolean colOneZero = false;
        for(int i = 0; i < rows; ++i){
        		for(int j = 0; j < cols; ++j){
        			if(matrix[i][j] == 0){
        				matrix[i][0] = 0;
        				matrix[0][j] = 0;
        				if(i == 0){
        					rowOneZero = true;
        				}
        				if(j == 0){
        					colOneZero = true;
        				}
        			}
        		}
        }
        for(int i = 1; i < rows; ++i){
        		if(matrix[i][0] == 0){
        			for(int j = 0; j < cols; ++j){
        				matrix[i][j] = 0;
        			}
        		}
        }
        for(int j = 1; j < cols; ++j){
        		if(matrix[0][j] == 0){
        			for(int i = 0; i < rows; ++i){
        				matrix[i][j] = 0;
        			}
        		}
        }
        if(rowOneZero){       		
        		for(int j = 0; j < cols; ++j){
    				matrix[0][j] = 0;
    			}
        }
        if(colOneZero){
        		for(int i = 0; i < rows; ++i){
        			matrix[i][0] = 0;
        		}
        }
    }
}
