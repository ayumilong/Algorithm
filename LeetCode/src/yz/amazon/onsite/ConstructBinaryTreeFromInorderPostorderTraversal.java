/**
 * File Name: ConstructBinaryTreeFromInorderPostorderTraversal.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:35:03 PM Apr 12, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:35:03 PM Apr 12, 2016
 */
public class ConstructBinaryTreeFromInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        if(inorder.length != postorder.length){
            return null;
        }
        int len = inorder.length;
        return helper(inorder, 0, len, postorder, 0, len);
    }
    
    private TreeNode helper(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2){
        if(s1 == e1){
            return null;
        }
        TreeNode root = new TreeNode(postorder[e2 - 1]);
        int r = s1;
        for(int i = s1; i < e1; ++i){
            if(inorder[i] == root.val){
                r = i;
                break;
            }
        }
        root.left = helper(inorder, s1, r, postorder, s2, s2 + r - s1);
        root.right = helper(inorder, r + 1, e1, postorder, s2 + r - s1, e2 - 1);
        return root;
    }
}
