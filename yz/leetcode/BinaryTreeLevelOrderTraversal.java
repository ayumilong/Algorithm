/**
 * File Name: BinaryTreeLevelOrderTraversal.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:07:31 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

import yz.leetcode.tools.TreeNode;

/**
 * @author Yaolin Zhang
 * @time 10:07:31 PM Oct 24, 2015
 */
public class BinaryTreeLevelOrderTraversal {
	/*
	 * DFS
	 */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        int targetLevel = 0;
        while(true){
            ArrayList<Integer> level = new ArrayList<>();
            dfs(root, level, 0, targetLevel);
            if(level.size() == 0){
                break;
            }
            results.add(level);
            ++targetLevel;
        }
        return results;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> level, int curLevel, int targetLevel){
        if(root == null){
            return;
        }
        if(curLevel == targetLevel){
            level.add(root.val);
        }
        dfs(root.left, level, curLevel + 1, targetLevel);
        dfs(root.right, level, curLevel + 1, targetLevel);
    }
	
    /*
     * BFS
     */
    public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            int size = level.size();
            ArrayList<Integer> curLevel = new ArrayList<>();
            for(int i = 0; i < size; ++i){
                TreeNode cur = level.poll();
                curLevel.add(cur.val);
                if(cur.left != null){
                    level.add(cur.left);
                }
                if(cur.right != null){
                    level.add(cur.right);
                }
            }
            results.add(curLevel);
        }
        return results;
    }
	
	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		
		LinkedList<Integer> values = new LinkedList<>();
		if (root != null) {
			current.add(root);
			values.add(root.val);
		}
		while (!current.isEmpty()) {
			result.add(values);
			values = new LinkedList<>();
			LinkedList<TreeNode> parent = current;
			current = new LinkedList<>();
			for (TreeNode node : parent) {
				if (node.left != null) {
					current.add(node.left);
					values.add(node.left.val);
				}
				if (node.right != null) {
					current.add(node.right);
					values.add(node.right.val);
				}
			}
		}
		return result;
	}
}
