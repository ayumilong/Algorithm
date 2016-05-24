/**
 * File Name: BinaryTreeZigzagLevelOrderTraversal.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:05:47 PM Nov 9, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 7:05:47 PM Nov 9, 2015
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> results = new LinkedList<>();
		if(root != null){
    		List<TreeNode> curNode = new LinkedList<>();
    		LinkedList<Integer> level = new LinkedList<>();
    		curNode.add(root);
    		boolean isReverse = false;
    		while(!curNode.isEmpty()){
    			List<TreeNode> parentNode = curNode;
    			curNode = new LinkedList<>();
    			for(TreeNode n : parentNode){
    				if(isReverse){
    					level.addFirst(n.val);
    				}else{
    					level.addLast(n.val);
    				}
    				if(n.left != null){
    					curNode.add(n.left);
    				}
    				if(n.right != null){
    					curNode.add(n.right);
    				}
    			}
    			results.add(level);
    			level = new LinkedList<>();
    			isReverse = !isReverse;
    		}
		}
		return results;
}
}
