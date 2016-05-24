package yz.leetcode;

import yz.leetcode.tools.*;
import java.util.*;

public class KthSmallestElementInBstDsign {
	private class TreeNodeWithIndex {
		public int val;
		public int index; // The index in in-order traversal sequence
		public TreeNodeWithIndex left;
		public TreeNodeWithIndex right;

		public TreeNodeWithIndex(int v) {
			this.val = v;
			this.index = 1;
		}
	}

	private TreeNodeWithIndex createTreeNodeWithIndex(TreeNode root) {
		if (root != null) {
			Stack<TreeNode> nodes = new Stack<>();
			Stack<TreeNodeWithIndex> newNodes = new Stack<>();
			nodes.push(root);
			int index = 0;
			TreeNodeWithIndex newRoot = new TreeNodeWithIndex(root.val);
			newNodes.push(newRoot);
			TreeNode pre = root;
			TreeNodeWithIndex newPre = newRoot;
			root = root.left;
			while (root != null || !nodes.isEmpty()) {
				while (root != null) {
					TreeNodeWithIndex temp = new TreeNodeWithIndex(root.val);
					if (root == pre.left) {
						newPre.left = temp;
					} else {
						newPre.right = temp;
					}
					nodes.push(root);
					newNodes.push(temp);

					newPre = temp;
					pre = root;
					root = root.left;
				}
				++index;
				if (!nodes.isEmpty()) {
					root = nodes.pop();
					TreeNodeWithIndex cur = newNodes.pop();
					cur.index = index;
					newPre = cur;
					pre = root;
					root = root.right;
				}
			}
			return newRoot;
		}
		return null;
	}

	public int kthSmallest(TreeNode root, int k) {
		TreeNodeWithIndex cur = createTreeNodeWithIndex(root);
		while (cur != null) {
			if (cur.index == k) {
				return cur.val;
			}
			if (cur.index > k) {
				cur = cur.left;
			} else if (cur.index < k) {
				cur = cur.right;
			}
		}
		return Integer.MIN_VALUE;
	}
}