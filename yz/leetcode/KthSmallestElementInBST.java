/**
 * File Name: KthSmallestElementInBST.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:45:33 PM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

import yz.leetcode.tools.TreeNode;

/**
 * @author Yaolin Zhang
 * @time 9:45:33 PM Oct 25, 2015
 */
public class KthSmallestElementInBST {
	public Result helper(TreeNode root, int k, int i){
	    if(root == null){
	        return new Result(0);
	    }
	    Result r = helper(root.left, k, i);
	    if(r.count + i != k){
	        ++r.count;
	        if(r.count + i == k){
	            r.val = root.val;
	        }else{
	            Result rr = helper(root.right, k, i + r.count);
	            rr.count += i + r.count;
	            System.out.println(rr.count + "  here");
	            return rr;
	        }
	    }
	    return r;
	}
	
	public int kthSmallest(TreeNode root, int k){
		Result result = helper(root, k, 0);
		return result.val;
	}
	
	/*
	 * O(h), h is the height of the BST
	 */
    private class Result{
        int count;
        int val;
        Result(int c){
            count = c;
            val = 0;
        }
    }
    
    public void helper1(TreeNode root, int k, Result r){
        if(root == null){
            return;
        }
        helper1(root.left, k, r);
        if(r.count != k){
            ++r.count;
            if(r.count == k){
                r.val = root.val;
            }else{
                helper1(root.right, k, r);
            }
        }
    }
    
    public int kthSmallest2(TreeNode root, int k){
        Result result = new Result(0);
        helper1(root, k, result);
        return result.val;
    }

	/*
	 * O(n), n is the number of nodes
	 */
	public int kthSmallest1(TreeNode root, int k) {
		Stack<TreeNode> nodes = new Stack<>();
		int count = 0;
		while (root != null || !nodes.isEmpty()) {
			while (root != null) {
				nodes.push(root);
				root = root.left;
			}
			++count;
			if (!nodes.isEmpty()) {
				root = nodes.pop();
				if (count == k) {
					return root.val;
				}
				root = root.right;
			}
		}
		return 0;
	}
}
