/**
 * File Name: BinaryTreeInorderTraversal.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:14:35 PM Oct 29, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 9:14:35 PM Oct 29, 2015
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root){
		Stack<TreeNode> nodes = new Stack<>();
		List<Integer> result = new ArrayList<>();
		while(root != null || !nodes.isEmpty()){
			while(root != null){
				nodes.push(root);
				root = root.left;
			}
				TreeNode cur = nodes.pop();
				result.add(cur.val);
				root = cur.right;
		}
		return result;
	}
}
