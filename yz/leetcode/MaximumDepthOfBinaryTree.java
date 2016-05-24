/**
 * File Name: MaximumDepthOfBinaryTree.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:44:55 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:44:55 PM Oct 24, 2015
 */
public class MaximumDepthOfBinaryTree {
	/*
	 * Based on pre-order traversal or called DFS
	 */
	public int maxDepth(TreeNode root){
		int curMax = 0;
		if(root != null){
			Stack<TreeNode> nodes = new Stack<>();
			nodes.push(root);
			int curDepth = 0;
			while(!nodes.isEmpty()){
				TreeNode cur = nodes.peek();
				if(cur != null){
					curMax = Math.max(curMax, ++curDepth);
					nodes.pop();
					nodes.push(null);
					if(cur.right != null){
						nodes.push(cur.right);
					}
					if(cur.left != null){
						nodes.push(cur.left);
					}
				}else{
					nodes.pop();
					--curDepth;
				}
			}
		}
		return curMax;
	}
	
	
	/*
	 * Based on post-order traversal
	 */
	public int maxDepth2(TreeNode root){
		Stack<TreeNode> nodes = new Stack<>();
		int curMax = 0;
		while(root != null || !nodes.isEmpty()){
			while(root != null){
				nodes.push(root);
				root = root.left;
			}
			root = nodes.peek().right;
			if(root == null){
				if(nodes.peek().left ==  null){
					curMax = curMax > nodes.size() ? curMax : nodes.size();
				}
				while(!nodes.isEmpty() && root == nodes.peek().right){
					root = nodes.pop();
				}
				if(nodes.isEmpty()){
					return curMax;
				}
				root = nodes.peek().right;
			}
		}
		return curMax;
	}
	
	/*
	 * Recursive
	 */
    public int maxDepth1(TreeNode root) {
        if(root == null){
        		return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
    	
    		return left > right ? left + 1: right + 1;
    }
}
