/**
 * File Name: InvertBinaryTree.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:21:12 AM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 1:21:12 AM Oct 25, 2015
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root){
		if(root != null){
			Queue<TreeNode> nodes = new LinkedList<>();
			nodes.add(root);
			while(!nodes.isEmpty()){
				TreeNode cur = nodes.poll();
				TreeNode temp = cur.left;
				cur.left = cur.right;
				cur.right = temp;
				if(cur.left != null){
					nodes.add(cur.left);
				}
				if(cur.right != null){
					nodes.add(cur.right);
				}
			}
		}
		return root;
	}
	
	/*
	 * Recursive
	 */
    public TreeNode invertTree1(TreeNode root) {
        if(root != null){
        		TreeNode temp = root.left;
        		root.left = root.right;
        		root.right = temp;
        		invertTree1(root.left);
        		invertTree1(root.right);
        }
    	
    		return root;
    }
}
