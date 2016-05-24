/**
 * File Name: MinimumDepthOfBinaryTree.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 4:47:36 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 4:47:36 PM Apr 17, 2016
 */
public class MinimumDepthOfBinaryTree {
	//BFS, level-order traversal
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        int level = 0;
        while(cur.size() != 0){
            ++level;
            List<TreeNode> parent = cur;
            cur = new ArrayList<>();
            for(TreeNode t : parent){
                if(t.left == null && t.right == null){
                    return level;
                }
                if(t.left != null){
                    cur.add(t.left);
                }
                if(t.right != null){
                    cur.add(t.right);
                }
            }
        }
        return level;
    }
	//DFS
    public int minDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getMin(root);
    }
    
    private int getMin(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null){//Leaf
            return 1;
        }
        int left = getMin(root.left);
        int right = getMin(root.right);
        return left < right ? left + 1 : right + 1;
    }
    //Use Post-order traversal, will scan all the nodes, not good
    public int minDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek().right;
            if(root == null){
                if(stack.peek().left == null){
                    int cur = stack.size();
                    min = min < cur ? min : cur;
                }
                while(root == stack.peek().right){
                    root = stack.pop();
                    if(stack.isEmpty()){
                        return min;
                    }
                }
                root = stack.peek().right;
            }
        }
        return min;
    }
}
