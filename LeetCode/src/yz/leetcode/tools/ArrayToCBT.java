/**
 * File Name: ArrayToCBT.java
 * Package Name: yz.leetcode.tools
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:28:48 PM Oct 29, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode.tools;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:28:48 PM Oct 29, 2015
 */
public class ArrayToCBT {
	public TreeNode toCBT(int[] nums){
		int len = nums.length;
		if(len != 0){
			TreeNode root = new TreeNode(nums[0]);
			Stack<TreeNode> cur = new Stack<>();
			int i = 1;
			cur.push(root);
			while(i < len){
				Stack<TreeNode> parent = cur;
				cur = new Stack<>();
				for(TreeNode n : parent){
					if(i < len){
						TreeNode temp = new TreeNode(nums[i]);
						n.left = temp;
						cur.push(temp);
					}
					if(i + 1 < len){
						TreeNode temp = new TreeNode(nums[i + 1]);
						n.right = temp;
						cur.push(temp);
					}
					i += 2;
				}
			}
			return root;
		}
		return null;
	}
}
