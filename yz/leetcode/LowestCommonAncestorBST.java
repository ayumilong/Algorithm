/**
 * File Name: LowestCommonAncestorBST.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:45:07 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:45:07 PM Oct 24, 2015
 */
public class LowestCommonAncestorBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (p.val == root.val && p == root) {
				return p;
			}
			if (q.val == root.val && q == root) {
				return q;
			}
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else if(p.val == root.val || q.val == root.val){
				root = root.left;
			} else {
				return root;
			}
		}
		return null;
	}

	/*
	 * Recursive
	 */
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		// if(root == p && root == q){
		// return root;
		// }
		if (p.val == root.val && q.val != root.val) {
			return p;
		}
		if (q.val == root.val && p.val != root.val) {
			return q;
		}
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}
}
