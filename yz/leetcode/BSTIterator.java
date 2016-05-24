/**
 * File Name: BinarySearchTreeIterator.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:45:53 PM Oct 15, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;
import java.util.*;

public class BSTIterator {
	Stack<TreeNode> stack = new Stack<>();
	
    public BSTIterator(TreeNode root) {
    		while(root != null){
    			stack.push(root);
    			root = root.left;
    		}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        int result = temp.val;
        
        temp = temp.right;
        while(temp != null){
        		stack.push(temp);
        		temp = temp.left;
        }
        return result;
    }
}

/**
 * @author Yaolin Zhang
 * @time 9:45:53 PM Oct 15, 2015
 */
/*
public class BSTIterator {
	Stack<Integer> stack = new Stack<>();
	
    public BSTIterator(TreeNode root) {
        populateStack(root);
    }
    
    public void populateStack(TreeNode root){
    		if(root != null){
    			populateStack(root.right);
    			stack.push(root.val);
    			populateStack(root.left);
    		}
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public int next() {
    		
        return stack.pop().intValue();
    }
}
*/
