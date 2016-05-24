/**
 * File Name: LowestCommonAncestorOfBinarySearchTree.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:30:55 AM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 12:30:55 AM Apr 14, 2016
 */
public class LowestCommonAncestorOfBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(root != null){
		    if(p.val > root.val && q.val > root.val){
		        root = root.right;
		    }else if(p.val < root.val && q.val < root.val){
		        root = root.left;
		    }else{
		        return root;
		    }
		}
		return null;
	}
}
