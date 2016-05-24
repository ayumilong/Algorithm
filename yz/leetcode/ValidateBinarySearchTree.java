/**
 * File Name: ValidateBinarySearchTree.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:28:26 PM Oct 28, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 11:28:26 PM Oct 28, 2015
 */
public class ValidateBinarySearchTree {
	/*
	 * DFS iterative
	 */
	private class Range {
		long low;
		long high;

		Range(long l, long h) {
			this.low = l;
			this.high = h;
		}
	}

	public boolean isValidBST3(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Range> ranges = new LinkedList<>();
		nodes.add(root);
		ranges.add(new Range(Long.MIN_VALUE, Long.MAX_VALUE));

		while (!nodes.isEmpty()) {
			TreeNode cur = nodes.poll();
			Range curRange = ranges.poll();
			if (cur.val < curRange.low || cur.val > curRange.high) {
				return false;
			}
			if (cur.left != null) {
				nodes.add(cur.left);
				ranges.add(new Range(curRange.low, cur.val));
			}
			if (cur.right != null) {
				nodes.add(cur.right);
				ranges.add(new Range(cur.val, curRange.high));
			}
		}

		return true;
	}

	
	/*
	 * DFS recursive
	 */
	private boolean recursive(TreeNode root, long base, long top){
		if(root != null){
			if(root.val <= base || root.val >= top){
				return false;
			}
			return recursive(root.left, base, root.val) && recursive(root.right, root.val, top);
		}
		return true;
	}
	
	public boolean isValidBST2(TreeNode root){
		return recursive(root.left, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	/*
	 * Based on in-order traversal
	 */
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
		TreeNode pre = null;
		while (root != null || !nodes.isEmpty()) {
			while (root != null) {
				nodes.push(root);
				root = root.left;
			}
			TreeNode cur = nodes.pop();
			if (pre != null && pre.val >= cur.val) {
				return false;
			}
			pre = cur;
			root = cur.right;
		}
		return true;
    }
}
