/**
 * File Name: PathSumII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:36:34 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:36:34 PM Oct 24, 2015
 */
public class PathSumII {
	/*
	 * DFS Recursive
	 */
	private void recursive(TreeNode root, int sum, List<List<Integer>> results, Stack<Integer> singlePath){
		singlePath.push(root.val);
		if(root.val == sum && root.left == null && root.right == null){	
			results.add(new LinkedList<Integer>(singlePath));
		}else{
			if(root.left != null){
				recursive(root.left, sum - root.val, results, singlePath);
			}
			if(root.right != null){
				recursive(root.right, sum - root.val, results, singlePath);
			}
		}
		singlePath.pop();
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> results = new LinkedList<>();
		Stack<Integer> singlePath = new Stack<>();
		if(root != null){
			recursive(root, sum, results, singlePath);
		}
		return results;
	}
	
	private List<Integer> copyStack(Stack<TreeNode> path){
		List<Integer> result = new LinkedList<>();
		//Stack<TreeNode> helper = new Stack<>();
		for(TreeNode n : path){
			result.add(n.val);
		}
		/*
		while(!path.isEmpty()){
			helper.push(path.pop());
		}
		while(!helper.isEmpty()){
			path.push(helper.peek());
			result.add(helper.pop().val);
		}*/
		return result;
	}
	
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        Stack<TreeNode> nodes = new Stack<>();
        List<List<Integer>> results = new LinkedList<>();
    		
        int count = 0;
        while(root != null || !nodes.isEmpty()){
        		while(root != null){
        			nodes.push(root);
        			count += root.val;
        			root = root.left;
        		}
        		root = nodes.peek().right;
        		if(root == null){
            		if(count == sum && nodes.peek().left == null){
            			results.add(copyStack(nodes));
            		}
        			while(root == nodes.peek().right){
        				root = nodes.pop();
        				count -= root.val;
        				if(nodes.isEmpty()){
        					return results;
        				}
        			}
        			root = nodes.peek().right;
        		}
        }
    	
    		return results;
    }
}
