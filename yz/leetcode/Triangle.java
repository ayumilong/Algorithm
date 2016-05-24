/**
 * File Name: Triangle.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:56:19 PM Jan 22, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:56:19 PM Jan 22, 2016
 */
public class Triangle {
	/*
	 * top-down
	 */
    public int minimumTotal(int[][] triangle) {
        if(triangle == null || triangle.length == 0){
            return 0;
        }
        int rows = triangle.length;
        int[] pathSums = new int[rows];
        pathSums[0] = triangle[0][0];
        
        for(int i = 1; i < rows; ++i){
            int temp1 = pathSums[0];
            int temp2 = pathSums[i - 1];
            pathSums[0] = temp1 + triangle[i][0];
            pathSums[i] = temp2 + triangle[i][i];
            for(int j = 1; j < i; ++j){
                int temp = pathSums[j];
                pathSums[j] = Math.min(temp1, pathSums[j]) + triangle[i][j];
                temp1 = temp;
            }
        }
        int min = pathSums[0];
        for(int i = 1; i < rows; ++i){
            if(min > pathSums[i]){
                min = pathSums[i];
            }
        }
        return min;
    }
	/*
	 * Bottom-up
	 */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        if(triangle.get(0) == null || triangle.get(0).size() == 0){
        		return 0;
        }
        int rows = triangle.size();
        int minSums[] = new int[rows];
        for(int i = 0; i < rows; ++i){
            minSums[i] = triangle.get(rows - 1).get(i);
        }
        for(int i = rows - 2; i >= 0; --i){//The ith row has i + 1 numbers
            for(int j = 0; j <= i; ++j){//The (i+1)th row has i + 2 numbers
                int temp = minSums[j] < minSums[j + 1] ? minSums[j] : minSums[j + 1];
                minSums[j] = temp + triangle.get(i).get(j);
            }
        }
        
        return minSums[0];
    }
}
