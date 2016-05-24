/**
 * File Name: PathSumII.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:32:15 PM Apr 12, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import yz.leetcode.tools.TreeNode;
import java.util.*;
/**
 * @author Yaolin Zhang
 * @time 9:32:15 PM Apr 12, 2016
 */
public class PathSumII {
	//Post order traversal
	public List<List<Integer>> pathSum(TreeNode root, int target){
		List<List<Integer>> results = new LinkedList<>();
		Stack<TreeNode> nodes = new Stack<>();
		Stack<Integer> path = new Stack<>();
		if(root == null){
			return results;
		}
		int sum = 0;
		while(root != null || !nodes.isEmpty()){
			while(root != null){
				nodes.add(root);
				sum += root.val;
				path.add(root.val);
				root = root.left;
			}
			root = nodes.peek().right;
			if(root == null){//No right child
				if(nodes.peek().left == null && sum == target){
					results.add(new LinkedList<>(path));
				}
				while(!nodes.isEmpty() && nodes.peek().right == root){
					root = nodes.pop();
					sum -= root.val;
					path.pop();
				}
				if(nodes.isEmpty()){
					return results;
				}
				root = nodes.peek().right;
			}
		}
		
		return results;
	}
	
	//DFS
	public List<List<Integer>> pathSum1(TreeNode root, int target){
		List<List<Integer>> results = new LinkedList<>();
		Stack<Integer> path = new Stack<>();
		if(root != null){
			dfs(root, results, path, target);
		}
		return results;
	}
	
	private void dfs(TreeNode root, List<List<Integer>> results, Stack<Integer> path, int sum){
		path.push(root.val);
		if(root.val == sum && root.left == null && root.right == null){
			results.add(new LinkedList<>(path));
			path.pop();
			return;
		}
		if(root.left != null){
			dfs(root.left, results, path, sum - root.val);
		}
		if(root.right != null){
			dfs(root.right, results, path, sum - root.val);
		}
		path.pop();
	}
}
