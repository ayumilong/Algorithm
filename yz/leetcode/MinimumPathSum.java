/**
 * File Name: MinimumPathSum.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:05:24 PM Jan 22, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 10:05:24 PM Jan 22, 2016
 */
public class MinimumPathSum {
	/*
	 * O(n*n) time and O(n) space
	 */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[] row = new int[cols];
        row[0] = grid[0][0];
        for(int j = 1; j < cols; ++j){
        		row[j] = row[j - 1] + grid[0][j];
        }
        
        for(int i = 1; i < rows; ++i){
            row[0] += grid[i][0];
            for(int j = 1; j < cols; ++j){
                row[j] = row[j - 1] < row[j] ? row[j - 1] + grid[i][j] : row[j] + grid[i][j];
            }
        }
        return row[cols - 1];
    }
	/*
	 * O(n*n) time and space
	 */
    public int minPathSum1(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] pathSums = new int[rows][cols];
        pathSums[0][0] = grid[0][0];
        for(int i = 1; i < rows; ++i){
            pathSums[i][0] = pathSums[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < cols; ++j){
            pathSums[0][j] = pathSums[0][j - 1] + grid[0][j];
        }
        for(int i = 1; i < rows; ++i){
            for(int j = 1; j < cols; ++j){
                pathSums[i][j] = Math.min(pathSums[i - 1][j], pathSums[i][j - 1]) + grid[i][j];
            }
        }
        return pathSums[rows - 1][cols - 1];
    }
}
