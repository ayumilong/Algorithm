/**
 * File Name: MinimumDepthOfBinaryTree.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 12:12:44 AM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.Stack;

import yz.leetcode.tools.TreeNode;

/**
 * @author Yaolin Zhang
 * @time 12:12:44 AM Oct 25, 2015
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
    		if(root == null){
    			return 0;
    		}
		Stack<TreeNode> nodes = new Stack<>();
		int curMin = Integer.MAX_VALUE;
		while(root != null || !nodes.isEmpty()){
			while(root != null){
				nodes.push(root);
				root = root.left;
			}
			root = nodes.peek().right;
			if(root == null){
				if(nodes.peek().left ==  null){
					curMin = curMin < nodes.size() ? curMin : nodes.size();
				}
				while(!nodes.isEmpty() && root == nodes.peek().right){
					root = nodes.pop();
				}
				if(nodes.isEmpty()){
					return curMin;
				}
				root = nodes.peek().right;
			}
		}
		return curMin;        
    }
}
