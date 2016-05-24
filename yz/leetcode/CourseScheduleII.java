/**
 * File Name: CourseScheduleII.java
 * Package Name: yz.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:17:00 PM May 20, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:17:00 PM May 20, 2016
 */
public class CourseScheduleII {
	
	public static void main(String[] args){
		int numCourses = 5;
		int[][] prerequisites = {{1,0}, {1,2}, {2,3}, {2,4}};
		
		CourseScheduleII cs = new CourseScheduleII();
		int[] result = cs.findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(result));
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
		int[] inDegree = new int[numCourses];
		for (int[] edge : prerequisites) {
			if (graph.get(edge[1]) == null) {
				graph.put(edge[1], new HashSet<>());
			}
			if (graph.get(edge[1]).add(edge[0])) {
				++inDegree[edge[0]];
			}
		}
		System.out.println(Arrays.toString(inDegree));
		int[] flag = new int[numCourses];
		int[] courses = new int[numCourses];
		int[] index = new int[1];
		for (int i = 0; i < numCourses; ++i) {
			if (inDegree[i] != 0 || flag[i] == 2) {
				continue;
			}
			if (!dfs(graph, flag, i, courses, index, inDegree)) {
				return new int[0];
			}
		}
		return index[0] == numCourses ? courses : new int[0];
	}

	private boolean dfs(HashMap<Integer, HashSet<Integer>> graph, int[] flag, int n, int[] courses, int[] index,
			int[] inDegree) {
		if (inDegree[n] == 0) {
			courses[index[0]++] = n;
		}
		if (flag[n] == 2) {
			return true;
		} else if (flag[n] == 1) {
			return false;
		}
		flag[n] = 1;

		HashSet<Integer> children = graph.get(n);
		if (children == null) {
			flag[n] = 2;
			return true;
		}
		for (Integer c : children) {
			--inDegree[c];
			if (!dfs(graph, flag, c, courses, index, inDegree)) {
				return false;
			}
		}
		flag[n] = 2;
		return true;
	}

}
