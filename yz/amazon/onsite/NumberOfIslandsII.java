/**
 * File Name: NumberOfIslandsII.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:51:41 PM Apr 12, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:51:41 PM Apr 12, 2016
 */
public class NumberOfIslandsII {
	private class Point{
		int x;
		int y;
		Point(int a, int b){
			x = a;
			y = b;
		}
	}
	private int find(int[] fathers, int index){
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
	
	private boolean union(int[] fathers, int i, int j){
		int ri = find(fathers, i);
		int rj = find(fathers, j);
		if(ri != rj){
			fathers[rj] = ri;
			return true;
		}
		return false;
	}
	
	public List<Integer> numIslands2(int m, int n, Point[] operators){
		List<Integer> result = new LinkedList<>();
		if(operators == null || operators.length == 0){
			return result;
		}
		int count = 0;
		int[] fathers = new int[m * n];
		for(int i = 0; i < m * n; ++i){
			fathers[i] = -1;
		}
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(Point p : operators){
			++count;
			fathers[p.x * n + p.y] = p.x * n + p.y;
			for(int i = 0; i < 4; ++i){
				int x = dx[i] + p.x;
				int y = dy[i] + p.y;
				if(x < 0 || x >= m || y < 0 || y >= n){
					continue;
				}
				if(fathers[x * n + y] != -1 && union(fathers, p.x * n + p.y, x * n + y)){
					--count;
				}
			}
			result.add(count);
		}
		return result;
	}
}
