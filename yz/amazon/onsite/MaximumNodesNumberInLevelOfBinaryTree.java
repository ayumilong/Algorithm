/**
 * File Name: MaximumNodesNumberInLevelOfBinaryTree.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:01:37 PM Apr 19, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 8:01:37 PM Apr 19, 2016
 */
public class MaximumNodesNumberInLevelOfBinaryTree {
	public static void main(String args[]){
		SerializeAndDeserializeBianryTree sd = new SerializeAndDeserializeBianryTree();
		Scanner scan = new Scanner(System.in);
		String tree = scan.nextLine();
		TreeNode root = sd.deserialize(tree);
		MaximumNodesNumberInLevelOfBinaryTree mn = new MaximumNodesNumberInLevelOfBinaryTree();
		System.out.println(mn.findMaximumCount(root));
		
		scan.close();
	}
	
	public int findMaximumCount(TreeNode root){
		List<Integer> count = new ArrayList<>();
		helper(root, 0, count);
		int max = 0;
		for(int c : count){
			max = max > c ? max : c;
		}
		return max;
	}
	
	private void helper(TreeNode root, int level, List<Integer> count){
		if(root == null){
			return;
		}
		if(count.size() <= level){
			count.add(1);
		}else{
			count.set(level, count.get(level) + 1);
		}
		helper(root.left, level + 1, count);
		helper(root.right, level + 1, count);
	}
}
