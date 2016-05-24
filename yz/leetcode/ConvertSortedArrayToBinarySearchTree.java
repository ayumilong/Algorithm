/**
 * File Name: ConvertSortedArrayToBinarySearchTree.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:53:11 PM Nov 3, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 8:53:11 PM Nov 3, 2015
 */
public class ConvertSortedArrayToBinarySearchTree {
	private class NodeRange {
		int start;
		int middle;
		int end;

		NodeRange(int s, int m, int e) {
			this.start = s;
			this.middle = m;
			this.end = e;
		}
	}

	public TreeNode sortedToBST(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return null;
		}
		TreeNode root = new TreeNode(nums[len / 2]);
		Queue<NodeRange> ranges = new LinkedList<>();
		Queue<TreeNode> nodes = new LinkedList<>();
		boolean[] isVisited = new boolean[len];

		ranges.add(new NodeRange(0, len / 2, len));
		nodes.add(root);
		isVisited[len / 2] = true;

		while (!nodes.isEmpty()) {
			TreeNode curNode = nodes.poll();
			NodeRange curRange = ranges.poll();
			if ((curRange.start + curRange.middle) / 2 >= curRange.start
					&& !isVisited[(curRange.start + curRange.middle) / 2]) {
				curNode.left = new TreeNode(nums[(curRange.start + curRange.middle) / 2]);
				nodes.add(curNode.left);
				ranges.add(new NodeRange(curRange.start, (curRange.start + curRange.middle) / 2, curRange.middle));
				isVisited[(curRange.start + curRange.middle) / 2] = true;
			}
			if ((curRange.middle + curRange.end + 1) / 2 < curRange.end
					&& !isVisited[(curRange.middle + curRange.end + 1) / 2]) {
				curNode.right = new TreeNode(nums[(curRange.middle + curRange.end + 1) / 2]);
				nodes.add(curNode.right);
				ranges.add(new NodeRange(curRange.middle + 1, (curRange.middle + curRange.end + 1) / 2, curRange.end));
				isVisited[(curRange.middle + curRange.end + 1) / 2] = true;
			}
		}
		return root;
	}
	
	/*
	 * Recursive
	 */
	private TreeNode recursive(int[] nums, int low, int high){
		if(low == high){
			return null;
		}
		int middle = (low + high) / 2;
		TreeNode root = new TreeNode(nums[middle]);
		root.left = recursive(nums, low, middle);
		root.right = recursive(nums, middle + 1, high);
		return root;
	}
	
    public TreeNode sortedArrayToBST1(int[] nums) {
        if(nums.length == 0){
        		return null;
        }
        return recursive(nums, 0, nums.length);
    }
}
