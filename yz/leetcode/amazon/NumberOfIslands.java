/**
 * File Name: NumberOfIslands.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:46:06 PM Apr 12, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:46:06 PM Apr 12, 2016
 */
public class NumberOfIslands {
	//Union find
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int rows = grid.length;
		int cols = grid[0].length;
		int[] fathers = new int[rows * cols];
		for (int i = 0; i < rows * cols; ++i) {
			if (grid[i / cols][i % cols] == '1') {
				fathers[i] = i;
			}
		}
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (grid[i][j] == '1') {
					// right
					if (j + 1 < cols && grid[i][j + 1] == '1') {
						union(fathers, i * cols + j, i * cols + j + 1);
					}
					// down
					if (i + 1 < rows && grid[i + 1][j] == '1') {
						union(fathers, i * cols + j, (i + 1) * cols + j);
					}
				}
			}
		}
		HashSet<Integer> count = new HashSet<>();
		for (int i = 0; i < fathers.length; ++i) {
			if (grid[i / cols][i % cols] == '0') {
				continue;
			}
			int r = find(fathers, i);
			count.add(r);
		}
		return count.size();
	}

	private int find(int[] fathers, int index) {
		int root = index;
		while(root != fathers[root]){
			root = fathers[root];
		}
		int next = fathers[index];
		while(next != root){
			fathers[index] = root;
			index = next;
			next = fathers[index];
		}
		return root;
	}

	private void union(int[] fathers, int i, int j) {
		int x1 = find(fathers, i);
		int x2 = find(fathers, j);
		if (x1 != x2) {
			fathers[x2] = x1;
		}
	}

	//DFS
	public int numIslands1(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (grid[i][j] == '1') {
					++count;
					dfs(grid, i, j);
				}
			}
		}
		// Should restore the grid here
		return count;
	}

	private void dfs(char[][] grid, int x, int y) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		grid[x][y] = 'Y';
		for (int i = 0; i < 4; ++i) {
			int curX = x + dx[i];
			int curY = y + dy[i];
			if (curX < 0 || curX >= grid.length || curY < 0 || curY >= grid[0].length) {
				continue;
			}
			if (grid[curX][curY] == '1') {
				dfs(grid, curX, curY);
			}
		}
	}
}
