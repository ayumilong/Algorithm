/**
 * File Name: BST.java
 * Package Name: yz.leetcode.tools
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:40:54 PM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode.tools;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:40:54 PM Oct 25, 2015
 */
public class BST {
	public TreeNodeWithIndex root;

	public BST(int[] nums) {
		root = createBST(nums, 0);
	}

	/*
	 * Update the index of the tree
	 */
	private void updateIndex(TreeNodeWithIndex root, int count) {
		if (root != null) {
			Queue<TreeNodeWithIndex> nodes = new LinkedList<>();
			nodes.add(root);
			while (!nodes.isEmpty()) {
				Queue<TreeNodeWithIndex> parents = nodes;
				nodes = new LinkedList<>();
				for (TreeNodeWithIndex n : parents) {
					n.index += count;
					if (n.left != null) {
						nodes.add(n.left);
					}
					if (n.right != null) {
						nodes.add(n.right);
					}
				}
			}
		}
	}

	/*
	 * Update all nodes' index based on the previous index and in-order traversal
	 * traversal
	 */
	private void updateIndex() {
		int index = 0;
		Stack<TreeNodeWithIndex> nodes = new Stack<>();
		TreeNodeWithIndex cur = root;
		while (cur != null || !nodes.isEmpty()) {
			while (cur != null) {
				nodes.push(cur);
				cur = cur.left;
			}

			if (!nodes.isEmpty()) {
				cur = nodes.pop();
				++index;
				if (index != cur.index) {
					cur.index = index;
				}
				cur = cur.right;
			}
		}
	}
	
	/*
	 * Update nodes's count
	 */
	private void updateCount(Stack<TreeNodeWithIndex> nodes){
		while(!nodes.isEmpty()){
			--nodes.pop().count;
		}
	}

	/*
	 * Insert a number to the tree and return the new node that hold the number
	 */
	public TreeNodeWithIndex insert(int num) {
		TreeNodeWithIndex cur = root;
		while (cur != null) {
			if (cur.val > num) { // Go to left child
				if (cur.right != null) {//// Increase index of all nodes in
										//// right child by 1
					updateIndex(cur.right, 1);
				}
				++cur.count;
				++cur.index; // index will be increased
				if (cur.left == null) {
					cur.left = new TreeNodeWithIndex(num);
					cur.left.index = cur.index - 1;
					return cur.left;
				}
				cur = cur.left;
			} else if (cur.val < num) {
				++cur.count; // Only count will be increased
				if (cur.right == null) {
					cur.right = new TreeNodeWithIndex(num);
					cur.right.index = cur.index + 1;
					return cur.right;
				}
				cur = cur.right;
			} else if (cur.val == num) {
				TreeNodeWithIndex temp = cur.left;
				cur.left = new TreeNodeWithIndex(num); // Insert a new node
														// between cur and
														// cur.left
				if(temp != null){
					cur.left.count = temp.count + 1;
					cur.left.index = temp.index + 1;
					cur.left.left = temp;
				}
				if (cur.right != null) { // Increase index of all nodes in right
											// child by 1
					updateIndex(cur.right, 1);
				}
				++cur.index;
				++cur.count;
				return cur.left;
			}
		}
		return null;
	}

	/*
	 * Delete a number and return the node that hold the number
	 */
	public TreeNodeWithIndex delete(int num) {
		Stack<TreeNodeWithIndex> nodes = new Stack<>();
		TreeNodeWithIndex cur = root;
		TreeNodeWithIndex pre = new TreeNodeWithIndex(-1);
		pre.left = root; // Let pre's left point to root
		while (cur != null) {
			if (cur.val == num) {
				TreeNodeWithIndex leftMost = cur.right;
				if (leftMost == null) {// If cur do not have right subtree
					if (cur == root) {
						root = cur.left;
						// Do not need to update index
					} else {
						if (pre.left == cur) {
							pre.left = cur.left;
						} else {
							pre.right = cur.left;
						}
					}
					updateIndex();
					updateCount(nodes);
					return cur;
				}
				TreeNodeWithIndex preLeft = null;
				while (leftMost.left != null) {
					nodes.push(leftMost);
					preLeft = leftMost;
					leftMost = leftMost.left;
				}
				if (preLeft != null) {
					preLeft.left = leftMost.right;
				}
				leftMost.left = cur.left;
				if (leftMost != cur.right) {// Link the right subtree if
											// leftMost is not right subtree of
											// cur
					leftMost.right = cur.right;
				}

				if (pre.left == cur) {// Left subtree
					pre.left = leftMost;
				} else {// Right subtree
					pre.right = leftMost;
				}

				if (cur == root) {
					root = pre.left;
				}
				leftMost.count = cur.count - 1;
				updateIndex();
				updateCount(nodes);
				return cur;
			} else if (cur.val > num) {// Go to left
				nodes.push(cur);
				pre = cur;
				cur = cur.left;
			} else if (cur.val < num) {// Go to right
				nodes.push(cur);
				pre = cur;
				cur = cur.right;
			}
		}

		return null;
	}

	public int kthNumber(int k) {
		TreeNodeWithIndex cur = root;
		while (cur != null) {
			if (cur.index == k) {
				return cur.val;
			}
			if (cur.index > k) {
				cur = cur.left;
			} else if (cur.index < k) {
				cur = cur.right;
			}
		}
		return Integer.MIN_VALUE;
	}

	public TreeNodeWithIndex createBST(int[] nums, int start) {
		int len = nums.length;
		if (len == 0) {
			return null;
		}
		TreeNodeWithIndex root = new TreeNodeWithIndex(nums[len / 2]);
		int[] leftNums = Arrays.copyOfRange(nums, 0, len / 2);
		int[] rightNums = Arrays.copyOfRange(nums, len / 2 + 1, len);
		root.left = createBST(leftNums, start);
		root.index += start;
		if (root.left != null) {
			root.index += root.left.count;
			root.count += root.left.count;
		}
		root.right = createBST(rightNums, root.index);
		if (root.right != null) {
			root.count += root.right.count;
		}
		return root;
	}

	private void printLinkedList(LinkedList<LinkedList<TreeNodeWithIndex>> list) {
		for (LinkedList<TreeNodeWithIndex> ll : list) {
			for (TreeNodeWithIndex t : ll) {
				System.out.print(t.val + "[" + t.index + ", " + t.count + "] ");
			}
			System.out.println("");
		}
		System.out.println();
	}

	private LinkedList<LinkedList<TreeNodeWithIndex>> createLinkedList() {
		LinkedList<LinkedList<TreeNodeWithIndex>> result = new LinkedList<>();
		LinkedList<TreeNodeWithIndex> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}
		while (!current.isEmpty()) {
			result.add(current);
			LinkedList<TreeNodeWithIndex> parent = current;
			current = new LinkedList<>();
			for (TreeNodeWithIndex node : parent) {
				if (node.left != null) {
					current.add(node.left);
				}
				if (node.right != null) {
					current.add(node.right);
				}
			}
		}

		return result;
	}

	public void printBST() {
		printLinkedList(createLinkedList());
	}
}
