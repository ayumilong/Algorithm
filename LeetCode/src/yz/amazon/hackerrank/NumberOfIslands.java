/**
 * File Name: NumberOfIslands.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 3:02:01 PM Apr 3, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 3:02:01 PM Apr 3, 2016
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        // Write your code here
        //ayumi_Long
        //Union find
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == '1'){
                    ++count;
                    removeIsland(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }
    
    private void removeIsland(char[][] grid, int x, int y, int rows, int cols){
        grid[x][y] = '0';
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 4; ++i){
            int xi = x + dx[i];
            int yi = y + dy[i];
            if(xi >= 0 && xi < rows && yi >= 0 && yi < cols && grid[xi][yi] == '1'){
                removeIsland(grid, xi, yi, rows, cols);
            }
        }
    }
    
    public int numIslands1(boolean[][] grid) {
        // Write your code here
        //ayumi_Long
        //Union find
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[] fathers = new int[rows * cols];
        for(int i = 0; i < rows; ++i){
        		for(int j = 0; j < cols; ++j){
        			if(grid[i][j]){
        				fathers[i * cols + j] = i * cols + j;
        			}
        		}
        }
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j]){
                    //bottom
                    if(i != rows - 1 && grid[i + 1][j]){
                        fathers[(i + 1) * cols + j] = i * cols + j;
                    }
                    //right
                    if(j != cols - 1 && grid[i][j + 1]){
                    		union(fathers, i * cols + j + 1, i * cols + j);
                    }
                }
            }
        }
        HashMap<Integer, Boolean> root = new HashMap<>();
        for(int i = 0; i < fathers.length; ++i){
            if(!grid[i / cols][i % cols]){
                continue;
            }
            int cur = find(fathers, i);
            if(!root.containsKey(cur)){
                root.put(cur, true);
            }
        }
        return root.size();
    }
    
    private int find(int[] fathers, int index){
    		int pre = index;
        while(fathers[index] != index){
            index = fathers[index];
        }
        int cur = pre;
        while(fathers[cur] != cur){
        		pre = cur;
        		cur = fathers[cur];
        		fathers[pre] = index;
        }
        return index;
    }
    
    private void union(int[] fathers, int i, int j){
    		int x1 = find(fathers, i);
    		int x2 = find(fathers, j);
    		if(x1 != x2){
    			fathers[x2] = x1;
    		}
    }
}
