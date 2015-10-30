/**
 * File Name: BinaryTreeRightSideView.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:52:10 PM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 7:52:10 PM Oct 25, 2015
 */
public class BinaryTreeRightSideView {
	/*
	 * Recursive
	 */
	private void recursive(TreeNode root, int level, List<Integer> result){
		if(level == result.size()){
			result.add(root.val);
		}
		if(root.right != null){
			recursive(root.right, level + 1, result);
		}
		if(root.left != null){
			recursive(root.left, level + 1, result);
		}
	}
	
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> result = new LinkedList<>();
		if(root == null){
			return null;
		}
		recursive(root, 0, result);
		return result;
	}
	
	/*
	 * Iterative
	 */
	public List<Integer> rightSideView1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root != null) {
			Deque<TreeNode> nodes = new LinkedList<>();
			nodes.add(root);
			while (!nodes.isEmpty()) {
				result.add(nodes.peekLast().val);
				Deque<TreeNode> parents = nodes;
				nodes = new LinkedList<>();
				for (TreeNode n : parents) {
					if (n.left != null) {
						nodes.add(n.left);
					}
					if (n.right != null) {
						nodes.add(n.right);
					}
				}
			}
		}
		return result;
	}
}
