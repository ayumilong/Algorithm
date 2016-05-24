/**
 * File Name: NumberOfIslands.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 3:39:03 PM Feb 28, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 3:39:03 PM Feb 28, 2016
 */
public class NumberOfIslands {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
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
                    		union(fathers, i * cols + j, i * cols + j + 1);
                    }
                }
            }
        }
        for(int i = 0; i < fathers.length; ++i){
        		if(i % cols == 0){
        			System.out.println();
        		}
        		System.out.print(fathers[i] + "(" + i + ")        ");
        }
        System.out.println();
        HashMap<Integer, Boolean> root = new HashMap<>();
        for(int i = 0; i < fathers.length; ++i){
            if(!grid[i / cols][i % cols]){
                continue;
            }
            int cur = find(fathers, i);
            System.out.println(i + "   father: " + cur);
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
