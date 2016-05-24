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
	
    public List<List<Integer>> pathSum1(TreeNode root, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Stack<TreeNode> nodes = new Stack<>();
        int sum = 0;
        while(root != null || !nodes.isEmpty()){
            while(root != null){
                nodes.add(root);
                path.add(root.val);
                sum += root.val;
                root = root.left;
            }
            root = nodes.peek().right;
            if(root == null){
                if(sum == target && nodes.peek().left == null){
                    result.add(new LinkedList<>(path));
                }
                while(root == nodes.peek().right){
                    root = nodes.pop();
                    sum -= root.val;
                    path.removeLast();
                    if(nodes.isEmpty()){
                        return result;
                    }
                }
                root = nodes.peek().right;
            }
        }
        return result;
    }
}
