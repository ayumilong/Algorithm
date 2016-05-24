/**
 * File Name: MaxPointsOnALine.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:55:58 PM Jan 9, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import java.util.Map.Entry;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 6:55:58 PM Jan 9, 2016
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        int max = 0;
    		HashMap<Double, Integer> slopes = new HashMap<>();
    		for(int i = 0; i < points.length; ++i){
    			slopes.clear();
    			slopes.put(Double.NEGATIVE_INFINITY, 0);
    			int duplicate = 0;
    			for(int j = 0; j < points.length; ++j){
    				if(points[i].x == points[j].x && points[i].y == points[j].y){
    					++duplicate;
    					continue;
    				}
    				System.out.println(i + " test " + j);
    				double slope = (points[i].x == points[j].x) ? Double.POSITIVE_INFINITY : ((double)(points[i].y - points[j].y)) / (points[i].x - points[j].x);
    				slopes.put(slope, slopes.get(slope) == null ? 1 : slopes.get(slope) + 1);
    				System.out.println(slope);
    			}
    			for(Entry<Double, Integer> curSlope : slopes.entrySet()){
    				if(max < duplicate + curSlope.getValue()){
    					max = duplicate + curSlope.getValue();
    				}
    			}
    		}
    		return max;
    }
}
