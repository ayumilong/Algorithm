/**
 * File Name: LowestCommonAncestorBT.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:11:52 PM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 6:11:52 PM Oct 25, 2015
 */
public class LowestCommonAncestorBT {
	/*
	 * Based on post-order traversal
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2){
		Stack<TreeNode> nodes = new Stack<>();
		boolean findOne = false;
		boolean findTwo = false;
		boolean isChild = true; //If now is traverse ancestor's child
		TreeNode ancestor = root;
		
		while(root != null || !nodes.isEmpty()){
			while(root != null){
				nodes.push(root);
				if(root == node1){
					findOne = true;
					if(findTwo){
						return ancestor;
					}
					ancestor = root;
				}
				if(root == node2){
					findTwo = true;
					if(findOne){
						return ancestor;
					}
					ancestor = root;
				}
				root = root.left;
			}
			root = nodes.peek().right;
			if(root == null){
				while(root == nodes.peek().right){
					root = nodes.pop();
					if(root == ancestor){
						isChild = false;
					}
					if(nodes.isEmpty()){
						return ancestor;
					}
				}
				if(!isChild){
					ancestor = nodes.peek();
				}
				isChild = true;
				root = nodes.peek().right;
			}
		}
		return ancestor;
	}
	
	/*
	 * Based on the specific position (level and index in level) of node1 and node2
	 * Too slow because we need process it as a full binary tree
	 */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode node1, TreeNode node2) {
		if (node1 == null || node2 == null) {
			return node1 == null ? node2 : node1;
		}
		Queue<TreeNode> nodes = new LinkedList<>();
		int layer1 = -1;
		int layer2 = -1;
		int index1 = 0;
		int index2 = 0;

		int curLayer = 0;
		int curIndex = 0;
		int count = 1;
		nodes.add(root);

		while (!nodes.isEmpty()) {
			TreeNode cur = nodes.poll();
			if (cur != null) {
				if (cur == node1) {
					layer1 = curLayer;
					index1 = curIndex;
				}
				if (cur == node2) {
					layer2 = curLayer;
					index2 = curIndex;
				}
				if (layer1 != -1 && layer2 != -1) {
					break;
				}
				nodes.add(cur.left);
				nodes.add(cur.right);
			}else{
				nodes.add(null);
				nodes.add(null);
			}
			--count;
			++curIndex;
			if (count == 0) {// Next layer
				++curLayer;
				curIndex = 0;
				count = (int) Math.pow(2, curLayer);
			}
		}

		while (layer1 < layer2) {
			--layer2;
			index2 = index2 / 2;
		}

		while (layer2 < layer1) {
			--layer1;
			index1 = index1 / 2;
		}

		while (index1 != index2) {
			--layer1;
			index1 = index1 / 2;
			index2 = index2 / 2;
		}

		curLayer = 0;
		curIndex = 0;
		count = 1;
		
		nodes.clear();
		nodes.add(root);
		TreeNode result;
		while (!nodes.isEmpty()) {
			result = nodes.poll();
			if(result != null){
				if(layer1 == curLayer && index1 == curIndex){
					return result;
				}
				nodes.add(result.left);
				nodes.add(result.right);
			}else{
				nodes.add(null);
				nodes.add(null);
			}
			--count;
			++curIndex;
			if(count == 0){
				curIndex = 0;
				++curLayer;
				count = (int)Math.pow(2, curLayer);
			}
		}

		return null;
	}
	
	public Stack<TreeNode> findPath(TreeNode root, TreeNode node) {
		Stack<TreeNode> path = new Stack<>();
		while (root != null || !path.isEmpty()) {
			while (root != null) {
				path.push(root);
				if (node == root) {
					return path;
				}
				root = root.left;
			}
			root = path.peek().right;
			if (root == null) { // Pop invalid partial path
				while (root == path.peek().right) {
					root = path.pop();
				}
				root = path.peek().right; // Go to right sub tree
			}
		}

		return null;
	}

	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode node1, TreeNode node2) {
		Stack<TreeNode> path1 = findPath(root, node1);
		Stack<TreeNode> path2 = findPath(root, node2);

		if (path1 != null && path2 != null) {
			int size1 = path1.size();
			int size2 = path2.size();

			while (size1 < size2) {
				--size2;
				path2.pop();
			}
			while (size2 < size1) {
				--size1;
				path1.pop();
			}
			while (path1.peek() != path2.peek()) {
				path1.pop();
				path2.pop();
			}
			return path1.peek();
		}

		return null;
	}
}
