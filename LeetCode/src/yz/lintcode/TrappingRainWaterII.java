/**
 * File Name: TrappingRainWaterII.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:09:07 PM Mar 3, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:09:07 PM Mar 3, 2016
 */
public class TrappingRainWaterII {

    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    private class Point{
        int x;
        int y;
        int height;
        Point(int i, int j, int h){
            x = i;
            y = j;
            height = h;
        }
    }
    public int trapRainWater(int[][] heights) {
        // write your code here
        //ayumi_Long
        if(heights == null || heights.length < 3 || heights[0] == null || heights[0].length < 3){
            return 0;
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(1, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				// TODO Auto-generated method stub
				return p1.height - p2.height;
			}
			
		});
		int count = 0;
		int rows = heights.length;
		int cols = heights[0].length;
		//First and last row
		for(int i = 0; i < cols; ++i){
		    pq.offer(new Point(0, i, heights[0][i]));
		    heights[0][i] = -1;
		    pq.offer(new Point(rows - 1, i, heights[rows - 1][i]));
		    heights[rows - 1][i] = -1;
		}
		//First and last column
		for(int i = 0; i < rows; ++i){
		    pq.offer(new Point(i, 0, heights[i][0]));
		    heights[i][0] = -1;
		    pq.offer(new Point(i, cols - 1, heights[i][cols - 1]));
		    heights[i][cols - 1] = -1;
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while(!pq.isEmpty()){
		    Point cur = pq.poll();
		    for(int i = 0; i < 4; ++i){
		    		int x = cur.x + dx[i];
		    		int y = cur.y + dy[i];
		    		if(x == -1 || x == rows || y == -1 || y == cols){
			    	    continue;
			    	}
		        if(heights[x][y] != -1){
		            if(heights[x][y] < cur.height){
		                count += cur.height - heights[x][y];
		                pq.offer(new Point(x, y, cur.height));
		            }else{
		                pq.offer(new Point(x, y, heights[x][y]));
		            }
		            heights[x][y] = -1;
		        }
		    }
		}
		return count;
    }
}
