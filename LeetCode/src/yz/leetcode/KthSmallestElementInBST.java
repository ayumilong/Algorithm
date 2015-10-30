/**
 * File Name: KthSmallestElementInBST.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:45:33 PM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.crackingcode.TreeNode;

/**
 * @author Yaolin Zhang
 * @time 9:45:33 PM Oct 25, 2015
 */
public class KthSmallestElementInBST {
	/*
	 * O(h), h is the height of the BST
	 */
	private class Result {
		int count;
		TreeNode kthNode;

		Result(int c) {
			this.count = c;
		}
	}

	public void helper(TreeNode root, int k, Result r) {
		if (root == null) {
			return;
		}
		helper(root.left, k, r);
		if (r.count != k) {
			++r.count;
			if (r.count == k) {
				r.kthNode = root;
				return;
			}
			helper(root.right, k, r);
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		Result result = new Result(0);
		helper(root, k, result);
		return result.kthNode.val;
	}

	/*
	 * O(n), n is the number of nodes
	 */
	public int kthSmallest1(TreeNode root, int k) {
		Stack<TreeNode> nodes = new Stack<>();
		int count = 0;
		while (root != null || !nodes.isEmpty()) {
			while (root != null) {
				nodes.push(root);
				root = root.left;
			}
			++count;
			if (!nodes.isEmpty()) {
				root = nodes.pop();
				if (count == k) {
					return root.val;
				}
				root = root.right;
			}
		}
		return 0;
	}
}
