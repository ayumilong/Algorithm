/**
 * File Name: PreorderSequenceOfBST.java
 * Package Name: yz.geeksforgeeks
 * Project Name: LeetCode
 * Purpose: http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 * Created Time: 5:23:00 PM Oct 31, 2015
 * Author: Yaolin Zhang
 */
package yz.geeksforgeeks;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 5:23:00 PM Oct 31, 2015
 */
public class PreorderSequenceOfBST {
	/*
	 * A better solution
	 */
	public boolean isPreorder(int[] nums) {
		int len = nums.length;
		if (len != 0) {
			int rootIndex = 0;
			boolean isRight = false;
			for (int i = 1; i < len; ++i) {
				if(isRight && nums[i] <= nums[rootIndex]){
					return false;
				}
				isRight = false;
				if(nums[i] > nums[i - 1]){
					isRight = true;
					int j = i;
					while(j > rootIndex && nums[i] > nums[j - 1]){
						--j;
					}
					rootIndex = j;
				}
			}
			return true;
		}

		return false;
	}

	private class Range {
		long low;
		long high;
		int index;

		Range(long l, long h, int i) {
			this.low = l;
			this.high = h;
			this.index = i;
		}
	}

	public TreeNode isPreorderBST(int[] nums) {
		int len = nums.length;
		if (len != 0) {
			TreeNode root = new TreeNode(nums[0]);
			Stack<TreeNode> nodes = new Stack<>();
			Stack<Range> ranges = new Stack<>();
			nodes.push(root);
			ranges.push(new Range(Long.MIN_VALUE, Long.MAX_VALUE, 0));
			for (int i = 1; i < len; ++i) {
				if (nums[i] <= nums[i - 1]) {// Go left
					if (nums[i] <= ranges.peek().low) {
						return null;
					}
					TreeNode left = new TreeNode(nums[i]);
					nodes.peek().left = left; // Create left child
					nodes.push(left);
					ranges.push(new Range(ranges.peek().low, nums[i - 1], i));
				} else {//Go right
					if (nums[i] > ranges.peek().high) {
						while (!ranges.isEmpty()) {
							if (nums[i] > ranges.peek().low && nums[i] <= ranges.peek().high) {
								break;
							}
							ranges.pop();
							nodes.pop();
						}
					}
					TreeNode right = new TreeNode(nums[i]);
					nodes.peek().right = right; // Create right child
					nodes.push(right);
					ranges.push(new Range(nums[ranges.peek().index], ranges.peek().high, i));
				}
			}
			return root;
		}

		return null;
	}
}
