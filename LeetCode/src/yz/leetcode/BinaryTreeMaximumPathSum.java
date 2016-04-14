/**
 * File Name: BinaryTreeMaximumPathSum.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:41:15 PM Jan 20, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 9:41:15 PM Jan 20, 2016
 */
public class BinaryTreeMaximumPathSum {
    private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath, maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
	
	/*
	 * My solution
	 */
    private class MaximumPath{
        public int singleSum;
        public int pathSum;
        public MaximumPath(int ss, int ps){
            singleSum = ss;
            pathSum = ps;
        }
    }
    
    public int maxPathSum1(TreeNode root) {
        return helper1(root).pathSum;
    }
    
    private MaximumPath helper1(TreeNode root){
        if(root == null){
            return new MaximumPath(0, Integer.MIN_VALUE);
        }
        MaximumPath left = helper1(root.left);
        MaximumPath right = helper1(root.right);
        int max = left.pathSum > right.pathSum ? left.pathSum : right.pathSum;
        //The max path startign from the current root
        int singleSum = left.singleSum > right.singleSum ? left.singleSum : right.singleSum;
        singleSum = singleSum > 0 ? singleSum + root.val : root.val;
        
        //The max path using the current root as the bridge of left and right subtree
        int withRoot = left.singleSum + right.singleSum + root.val;
        withRoot = withRoot > singleSum ? withRoot : singleSum;
        
        max = max > withRoot ? max : withRoot;
        
        return new MaximumPath(singleSum, max);
    }
    
    public int maxPathSum2(TreeNode root) {
        return helper2(root)[1];
    }
    
    private int[] helper2(TreeNode root){
        if(root == null){
            return new int[]{0, Integer.MIN_VALUE};
        }
        int left[] = helper2(root.left);
        int right[] = helper2(root.right);
        int maxSum = left[1] > right[1] ? left[1] : right[1];
        //The max path starting from the current root
        int singleSum = left[0] > right[0] ? left[0] : right[0];
        singleSum = singleSum > 0 ? singleSum + root.val : root.val;
        
        //The max path using the current root as the bridge of left and right subtree
        int withRoot = left[0] + right[0] + root.val;
        withRoot = withRoot > singleSum ? withRoot : singleSum;
        
        maxSum = maxSum > withRoot ? maxSum : withRoot;
        
        return new int[]{singleSum, maxSum};
    }
}
