/**
 * File Name: SymmetricTree.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:31:07 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:31:07 PM Oct 24, 2015
 */
public class SymmetricTree {
	/*
	 * Recursive
	 */
	private boolean symmetric(TreeNode left, TreeNode right){
		if(left == null && right == null){
			return true;
		}
		if(left == null || right == null || left.val != right.val){
			return false;
		}
		
		return symmetric(left.left, right.right) && symmetric(left.right, right.left);
	}
	
	public boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		return symmetric(root.left, root.right);
	}
	
	/*
	 * Iterative
	 */
    public boolean isSymmetric1(TreeNode root) {
        if(root == null){
        		return true;
        }
        Deque<TreeNode> level = new LinkedList<>();
        level.add(root.left);
        level.add(root.right);
        while(!level.isEmpty()){
        		Deque<TreeNode> parent = level;
        		level = new LinkedList<>();
        		while(!parent.isEmpty()){
        			TreeNode first = parent.pollFirst();
        			TreeNode last = parent.pollLast();
        			if(first == null && last == null){
        				continue;
        			}
        			if(first == null || last == null || first.val != last.val){
        				return false;
        			}
        			level.addFirst(first.right);
        			level.addFirst(first.left);
        			level.addLast(last.left);
        			level.addLast(last.right);
        		}
        }
        return true;
    }
}
