/**
 * File Name: ConstructBinaryTreeFromPreOrderInOrderTraversal.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:00:17 PM Apr 12, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:00:17 PM Apr 12, 2016
 */
public class ConstructBinaryTreeFromPreOrderInOrderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null){
            return null;
        }
        if(preorder.length != inorder.length){
            return null;
        }
        int len = preorder.length;
        TreeNode root = helper(preorder, 0, len, inorder, 0, len);
        return root;
    }
    private TreeNode helper(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2){
        if(s1 == e1){
            return null;
        }
        TreeNode root = new TreeNode(preorder[s1]);
        int r = s2;
        for(int i = s2; i < e2; ++i){
            if(inorder[i] == root.val){
                r = i;
                break;
            }
        }
        root.left = helper(preorder, s1 + 1, s1 + r - s2 + 1, inorder, s2, r);
        root.right = helper(preorder, s1 + r - s2 + 1, e1, inorder, r + 1, e2);
        return root;
    }
}
