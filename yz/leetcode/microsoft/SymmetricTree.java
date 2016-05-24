/**
 * File Name: SymmetricTree.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:09:15 AM May 12, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:09:15 AM May 12, 2016
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root.left);
        nodes.push(root.right);
        while(!nodes.isEmpty()){
            TreeNode left = nodes.pop();
            TreeNode right = nodes.pop();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val != right.val){
                return false;
            }
            nodes.push(left.left);
            nodes.push(right.right);
            nodes.push(left.right);
            nodes.push(right.left);
        }
        return true;
    }
	//Recursive
    public boolean isSymmetric1(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
