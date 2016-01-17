/**
 * File Name: BinaryTreeLevelOrderTraversal.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:07:31 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

import yz.leetcode.tools.TreeNode;

/**
 * @author Yaolin Zhang
 * @time 10:07:31 PM Oct 24, 2015
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		
		LinkedList<Integer> values = new LinkedList<>();
		if (root != null) {
			current.add(root);
			values.add(root.val);
		}
		while (!current.isEmpty()) {
			result.add(values);
			values = new LinkedList<>();
			LinkedList<TreeNode> parent = current;
			current = new LinkedList<>();
			for (TreeNode node : parent) {
				if (node.left != null) {
					current.add(node.left);
					values.add(node.left.val);
				}
				if (node.right != null) {
					current.add(node.right);
					values.add(node.right.val);
				}
			}
		}
		return result;
	}
}
