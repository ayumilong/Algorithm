/**
 * File Name: InorderSuccessorInBST.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:49:02 PM Jan 20, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 8:49:02 PM Jan 20, 2016
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while(root != null && root.val != p.val){
            if(p.val < root.val){
                pre = root;
                root = root.left;
            }else{
                //pre = null;
                root = root.right;
            }
        }
        if(root == null){
            return null;
        }
        if(root.right == null){
            return pre;
        }
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
