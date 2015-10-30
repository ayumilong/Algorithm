/**
 * File Name: BalancedBinaryTree.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:40:07 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.crackingcode.*;

/**
 * @author Yaolin Zhang
 * @time 9:40:07 PM Oct 24, 2015
 */
public class BalancedBinaryTree {
	private class Balance{
		TreeNode node;
		int height; //Store the height of this node or when right subtree is not processed yet, store the height of left subtree
		Balance(TreeNode n){
			this.node = n;
			height = 0;
		}
	}
	public boolean isBalanced(TreeNode root) {
		Stack<Balance> nodes = new Stack<>();
		while (root != null || !nodes.isEmpty()) {
			while (root != null) {
				nodes.push(new Balance(root));
				root = root.left;
			}
			root = nodes.peek().node.right;
			if (root == null) { // 
				Balance temp = nodes.pop();
				if(temp.height > 1){//No right subtree and if left subtree's height is greater than 1
					return false;
				}
				++temp.height; //temp.node has no right subtree so its height is left subtree's height plus 1
				root = temp.node;
				
				while (!nodes.isEmpty() && root == nodes.peek().node.right) {
					if(Math.abs(nodes.peek().height - temp.height) > 1){//When compare to right subtree, root.height will be the height of left subtree
						return false;
					}
					//Root's left and right subtrees have been processed then update it's height
					nodes.peek().height = temp.height > nodes.peek().height ? temp.height + 1 : nodes.peek().height + 1;
					temp = nodes.pop();
					root = temp.node;
				}
				if(nodes.isEmpty()){
					return true;
				}
				nodes.peek().height = temp.height; //Temporally set root's height to left subtree's height in order to compare to right subtree's height
				root = nodes.peek().node.right; // Go to right subtree
			}
		}
		return true;
	}
	
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		if (left == -1) {
			return -1;
		}
		int right = getHeight(root.right);
		if (right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return left > right ? left + 1 : right + 1;
	}

	public boolean isBalanced1(TreeNode root) {
		if (getHeight(root) == -1) {
			return false;
		}
		return true;
	}
}
