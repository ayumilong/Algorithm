/**
 * File Name: BinaryTreeLevelOrderTraversalII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:22:18 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:22:18 PM Oct 24, 2015
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        
        Queue<TreeNode> current = new LinkedList<>();
        List<Integer> values = new LinkedList<>();
        
        if(root != null){
        		current.add(root);
        		values.add(root.val);
        }
        while(!current.isEmpty()){
        		result.add(0, values);
        		values = new LinkedList<>();
        		Queue<TreeNode> parent = current;
        		current = new LinkedList<>();
        		for(TreeNode n : parent){
        			if(n.left != null){
        				current.add(n.left);
        				values.add(n.left.val);
        			}
        			if(n.right != null){
        				current.add(n.right);
        				values.add(n.right.val);
        			}
        		}
        }
    		return result;
    }
}
