/**
 * File Name: ValidBinarySearchTree.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:40:10 PM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 9:40:10 PM Apr 14, 2016
 */
public class ValidBinarySearchTree {
	//Pre-order traversal
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val >= root.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
	//Recursive
    public boolean isValidBST2(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValid(TreeNode root, long low, long high){
        if(root == null){
            return true;
        }
        if(root.val <= low || root.val >= high){
            return false;
        }
        return isValid(root.left, low, root.val) && isValid(root.right, root.val, high);
    }
	private class Range {
		long low;
		long high;
		Range(long l, long h) {
			this.low = l;
			this.high = h;
		}
	}
	//Non-recursive, level-order traversal
	public boolean isValidBST1(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Range> ranges = new LinkedList<>();
		nodes.add(root);
		ranges.add(new Range(Long.MIN_VALUE, Long.MAX_VALUE));

		while (!nodes.isEmpty()) {
			TreeNode cur = nodes.poll();
			Range curRange = ranges.poll();
			if (cur.val <= curRange.low || cur.val >= curRange.high) {
				return false;
			}
			if (cur.left != null) {
				nodes.add(cur.left);
				ranges.add(new Range(curRange.low, cur.val));
			}
			if (cur.right != null) {
				nodes.add(cur.right);
				ranges.add(new Range(cur.val, curRange.high));
			}
		}
		return true;
	}
}
