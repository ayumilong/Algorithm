/**
 * File Name: TreeNode.java
 * Package Name: yz.leetcode.tools
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:43:20 PM Oct 15, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode.tools;

/**
 * @author Yaolin Zhang
 * @time 9:43:20 PM Oct 15, 2015
 */
public class TreeNode {
	 public int val;
	 public int index;
	 public TreeNode left;
	 public TreeNode right;
	 public TreeNode parent;
	 public TreeNode(int x) { val = x; }
	 public TreeNode(int x, int i){
		 val = x;
		 index = i;
	 }
}
