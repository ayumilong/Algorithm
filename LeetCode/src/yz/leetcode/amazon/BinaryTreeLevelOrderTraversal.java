/**
 * File Name: BinaryTreeLevelOrderTraversal.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:55:29 PM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 7:55:29 PM Apr 14, 2016
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        if(root != null){
            cur.add(root);
            values.add(root.val);
        }
        while(!cur.isEmpty()){
            result.add(values);
            values = new ArrayList<>();
            List<TreeNode> parent = cur;
            cur = new ArrayList<>();
            for(TreeNode node : parent){
                if(node.left != null){
                    cur.add(node.left);
                    values.add(node.left.val);
                }
                if(node.right != null){
                    cur.add(node.right);
                    values.add(node.right.val);
                }
            }
        }
        return result;
    }
}
