/**
 * File Name: InorderSuccessorInBST.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:21:14 PM May 17, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:21:14 PM May 17, 2016
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){
            return null;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        while(root != null || !nodeStack.isEmpty()){
            while(root != null){
                if(root == p){
                    if(root.right != null){
                        return findLeftMost(root.right);
                    }else{
                        return nodeStack.isEmpty() ? null : nodeStack.peek();
                    }
                }
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop().right;
        }
        return null;
    }
    
    private TreeNode findLeftMost(TreeNode root){
    		if(root == null){
    			return null;
    		}
    		while(root.left != null){
    			root = root.left;
    		}
    		return root;
    }
}
