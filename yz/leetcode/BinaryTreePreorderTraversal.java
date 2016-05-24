/**
 * File Name: BinaryTreePreorderTraversal.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 5:59:44 PM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 5:59:44 PM Oct 25, 2015
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root){
		if(root == null){
			return null;
		}
		List<Integer> result = new LinkedList<>();
		Stack<TreeNode> nodes = new Stack<>();
		nodes.push(root);
		while(!nodes.isEmpty()){
			TreeNode cur = nodes.pop();
			result.add(cur.val);
			if(cur.right != null){
				nodes.push(cur.right);
			}
			if(cur.left != null){
				nodes.push(cur.left);
			}
		}
		return result;
	}
}
