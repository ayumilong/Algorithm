/**
 * File Name: JumpGameII.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:27:50 PM Apr 11, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:27:50 PM Apr 11, 2016
 */
public class JumpGameII {
	public static void main(String args[]){
		JumpGameII jg = new JumpGameII();
		int[] nums = {6,2,6,1,7,9,3,5,3,7,2,8,9,4,7,7,2,2,8,4,6,6,1,3};
		System.out.println(jg.jump(nums));
	}
	private class GeneralTreeNode {
		public int val;
		public int index;
		public List<GeneralTreeNode> children;
		public GeneralTreeNode(int v, int i){
			val = v;
			index = i;
		}
	}
	//Tree
	public int jump(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		GeneralTreeNode root = new GeneralTreeNode(nums[0], 0);
		Queue<GeneralTreeNode> nodes = new LinkedList<>();
		nodes.offer(root);
		while(!nodes.isEmpty()){
			GeneralTreeNode cur = nodes.poll();
			cur.children = new LinkedList<>();
			for(int i = cur.index + 1; i <= cur.index + cur.val && i < nums.length; ++i){
				GeneralTreeNode temp = new GeneralTreeNode(nums[i], i);
				cur.children.add(temp);
				nodes.add(temp);
			}
		}
		List<Integer> path = new LinkedList<>();
		List<Integer> sp = new LinkedList<>();
		path.add(root.index);
		int jump = shortestPath(root, path, sp);
		for(Integer i : sp){
			System.out.print(i + " ");
		}
		System.out.println();
		return jump;
	}
	
	private int shortestPath(GeneralTreeNode root, List<Integer> path, List<Integer> sp){
		if(root.children.size() == 0){
			if(sp.size() == 0 || sp.size() > path.size()){
				sp.clear();
				sp.addAll(path);
			}
			return path.size() - 1;
		}
		int min = Integer.MAX_VALUE;
		List<GeneralTreeNode> children = root.children;
		for(GeneralTreeNode node : children){
			path.add(node.index);
			int temp = shortestPath(node, path, sp);
			path.remove(path.size() - 1);
			min = min < temp ? min : temp;
		}
		return min;
	}
	
	//Greedy
	public int jump2(int[] nums){
		if(nums == null || nums.length < 2){
			return 0;
		}
		int jump = 0;
		int start = 0;
		List<Integer> path = new LinkedList<>();
		path.add(start);
		for(int i = 0; i < nums.length;){
			++jump;
			int max = start;
			int j = i;
			for(; j <= nums[start] + start && j < nums.length; ++j){
				if(j + nums[j] > max + nums[max]){
					max = j;
				}
			}
			start = max;
			path.add(start);
			i = j;
		}
		for(Integer i : path){
			System.out.println(i + " ");
		}
		return jump;
	}
	
	
	//DP
	public int jump1(int[] A){
		if(A == null || A.length == 0){
			return 0;
		}
		int[] steps = new int[A.length];
		for(int i = A.length - 2; i >= 0; --i){
			if(A[i] + i >= A.length - 1){
				steps[i] = 1;
			}else{
				int min = Integer.MAX_VALUE;
				for(int j = i + 1; j <= i + A[i]; ++i){
					min = min < (steps[j] + 1) ? min : (steps[j] + 1);
				}
				steps[i] = min;
			}
		}
		return steps[0];
	}
}
