/**
 * File Name: Chapter4.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 2:22:57 PM Oct 18, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

import java.util.*;

import yz.leetcode.tools.TreeNode;

/**
 * @author Yaolin Zhang
 * @time 2:22:57 PM Oct 18, 2015
 */
public class Chapter4 {
	/*
	 * Question #1
	 */
	/*
	 * private int getHeight(TreeNode root, Stack<Boolean> heights){ if(root ==
	 * null){ return 0; } int left = getHeight(root.left, heights); int right =
	 * getHeight(root.right, heights); heights.push(Math.abs(left - right) > 1);
	 * 
	 * return left > right ? left + 1 : right + 1; }
	 * 
	 * public boolean isBalanceTree(TreeNode root){ Stack<Boolean> heights = new
	 * Stack<>(); getHeight(root, heights); while(!heights.isEmpty()){
	 * if(heights.pop()){ return false; } } return true; }
	 */
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		if (left == -1) {
			return -1;
		}
		int right = getHeight(root.right);
		if (right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return left > right ? left + 1 : right + 1;
	}

	public boolean isBalanceTree(TreeNode root) {
		if (getHeight(root) == -1) {
			return false;
		}
		return true;
	}

	/*
	 * Question #3
	 */
	public void printTree(TreeNode root) {
		Queue<TreeNode> tree = new LinkedList<>();
		tree.add(root);
		while (!tree.isEmpty()) {
			TreeNode curNode = tree.poll();
			if (curNode != null) {
				System.out.print(curNode.val + " ");
				tree.add(curNode.left);
				tree.add(curNode.right);
			}
		}

		System.out.println();
	}

	private class NodeRange {
		int start;
		int middle;
		int end;

		NodeRange(int s, int m, int e) {
			this.start = s;
			this.middle = m;
			this.end = e;
		}
	}

	public TreeNode createBinaryTree(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return null;
		}
		TreeNode root = new TreeNode(nums[len / 2]);
		Queue<NodeRange> ranges = new LinkedList<>();
		Queue<TreeNode> nodes = new LinkedList<>();
		boolean[] isVisited = new boolean[len];

		ranges.add(new NodeRange(0, len / 2, len));
		nodes.add(root);
		isVisited[len / 2] = true;

		while (!nodes.isEmpty()) {
			TreeNode curNode = nodes.poll();
			NodeRange curRange = ranges.poll();
			if ((curRange.start + curRange.middle) / 2 >= curRange.start
					&& !isVisited[(curRange.start + curRange.middle) / 2]) {
				curNode.left = new TreeNode(nums[(curRange.start + curRange.middle) / 2]);
				nodes.add(curNode.left);
				ranges.add(new NodeRange(curRange.start, (curRange.start + curRange.middle) / 2, curRange.middle));
				isVisited[(curRange.start + curRange.middle) / 2] = true;
			}
			if ((curRange.middle + curRange.end + 1) / 2 < curRange.end
					&& !isVisited[(curRange.middle + curRange.end + 1) / 2]) {
				curNode.right = new TreeNode(nums[(curRange.middle + curRange.end + 1) / 2]);
				nodes.add(curNode.right);
				ranges.add(new NodeRange(curRange.middle + 1, (curRange.middle + curRange.end + 1) / 2, curRange.end));
				isVisited[(curRange.middle + curRange.end + 1) / 2] = true;
			}
		}
		return root;
	}

	/*
	 * Recursive
	 */
	public TreeNode createBinaryTree1(int[] nums, int start, int end) {
		if (start == end) {
			return null;
		}
		TreeNode root = new TreeNode(nums[(start + end) / 2]);
		root.left = createBinaryTree1(nums, start, (start + end) / 2);
		root.right = createBinaryTree1(nums, (start + end) / 2 + 1, end);
		return root;
	}

	public TreeNode createBinaryTree2(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return null;
		}
		TreeNode root = new TreeNode(nums[len / 2]);
		int[] leftNums = Arrays.copyOfRange(nums, 0, len / 2);
		int[] rightNums = Arrays.copyOfRange(nums, len / 2 + 1, len);
		root.left = createBinaryTree2(leftNums);
		root.right = createBinaryTree2(rightNums);
		return root;
	}

	/*
	 * Question #4
	 */

	public LinkedList<LinkedList<TreeNode>> depthOfElement(TreeNode root) {
		LinkedList<LinkedList<TreeNode>> listHead = new LinkedList<LinkedList<TreeNode>>();
		Queue<TreeNode> node = new LinkedList<>();
		node.add(null);
		node.add(root);

		LinkedList<TreeNode> sameDepth = new LinkedList<>();
		while (!node.isEmpty()) {
			if (node.peek() == null) {
				if (node.size() != 1) {
					node.add(null);
				}
				LinkedList<TreeNode> temp = new LinkedList<>(sameDepth);
				listHead.add(temp);
				sameDepth.clear();
			} else {
				sameDepth.add(node.peek());
				if (node.peek().left != null) {
					node.add(node.peek().left);
				}
				if (node.peek().right != null) {
					node.add(node.peek().right);
				}
			}
			node.poll();
		}
		listHead.removeFirst();
		return listHead;
	}

	public void printLinkedList(List<List<TreeNode>> list) {
		for (List<TreeNode> ll : list) {
			for (TreeNode t : ll) {
				System.out.print(t.val + " ");
			}
			System.out.println("");
		}
		System.out.println();
	}

	public List<List<TreeNode>> toLinkedList(TreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		nodes.add(null);

		List<List<TreeNode>> results = new LinkedList<>();
		while (true) {
			TreeNode curNode = nodes.poll();
			LinkedList<TreeNode> ll = new LinkedList<>();
			while (curNode != null) {
				ll.add(curNode);
				if (curNode.left != null) {
					nodes.add(curNode.left);
				}
				if (curNode.right != null) {
					nodes.add(curNode.right);
				}
				curNode = nodes.poll();
			}
			results.add(ll);
			if (nodes.isEmpty()) {
				break;
			}
			nodes.add(null);
		}
		return results;
	}

	/*
	 * Solution from Cracking Code
	 */
	public List<List<TreeNode>> createLinkedList(TreeNode root) {
		List<List<TreeNode>> result = new LinkedList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}
		while (!current.isEmpty()) {
			result.add(current);
			LinkedList<TreeNode> parent = current;
			current = new LinkedList<>();
			for (TreeNode node : parent) {
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

	/*
	 * Question #5
	 */
	/*
	 * Pre-order traversal
	 */
	/*
	 * Pre-order traversal actually is DFS traversal
	 */
	public void recursive(TreeNode root, List<Integer> result){
		result.add(root.val);
		if(root.left != null){
			recursive(root.left, result);
		}
		if(root.right != null){
			recursive(root.right, result);
		}
	}
	
	public List<Integer> preorderTraversalRecursive(TreeNode root){
		if(root == null){
			return null;
		}
		List<Integer> result = new LinkedList<>();
		recursive(root, result);
		return result;
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> nodes = new Stack<>();
		List<Integer> result = new ArrayList<>();

		nodes.push(root);
		while (!nodes.isEmpty()) {
			TreeNode cur = nodes.pop();
			result.add(cur.val);
			if (cur.right != null) {
				nodes.push(cur.right);
			}
			if (cur.left != null) {
				nodes.push(cur.left);
			}
		}

		return result;
	}

	/*
	 * In-order traversal
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> nodes = new Stack<>();
		List<Integer> result = new ArrayList<>();
		while (root != null || !nodes.isEmpty()) {
			while (root != null) {
				nodes.push(root);
				root = root.left;
			}
			TreeNode cur = nodes.pop();
			result.add(cur.val);
			root = cur.right;
		}
		return result;
	}
	/*
	 * public List<Integer> inorderTraversal(TreeNode root){ Stack<TreeNode>
	 * nodes = new Stack<>(); List<Integer> result = new ArrayList<>();
	 * 
	 * TreeNode cur = root; while(cur != null){ //Go to left most node, which is
	 * the first node nodes.push(cur); cur = cur.left; }
	 * 
	 * while(!nodes.isEmpty()){ cur = nodes.pop(); result.add(cur.val); //Visit
	 * node at stack top cur = cur.right; //Visit right child tree while(cur !=
	 * null){ nodes.push(cur); cur = cur.left; } } return result; }
	 */

	/*
	 * Post-order traversal
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> nodes = new Stack<>();
		List<Integer> result = new ArrayList<>();
		while (root != null || !nodes.isEmpty()) {
			while (root != null) {
				nodes.push(root);
				root = root.left;
			}
			root = nodes.peek().right;
			if (root == null) { // 
				while (root == nodes.peek().right) {
					root = nodes.pop();
					result.add(root.val);
					if(nodes.isEmpty()){
						return result;
					}
				}
				root = nodes.peek().right; // Go to right sub tree
			}
		}
		return result;
	}

	/*
	 * Depend on in-order traversal
	 */
	public boolean isBST(TreeNode root) {
		Stack<TreeNode> nodes = new Stack<>();
		TreeNode pre = null;
		while (root != null || !nodes.isEmpty()) {
			while (root != null) {
				nodes.push(root);
				root = root.left;
			}
			if (!nodes.isEmpty()) {
				TreeNode cur = nodes.pop();
				if (pre != null && (pre.val > cur.val || (pre.val == cur.val && pre.right == cur))) {
					return false;
				}
				pre = cur;
				root = cur.right;
			}
		}
		return true;
	}

	/*
	 * Solution from Cracking Code
	 */
	private class Range {
		int low;
		int high;

		Range(int l, int h) {
			this.low = l;
			this.high = h;
		}
	}

	public boolean isBinarySearchTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Range> ranges = new LinkedList<>();
		nodes.add(root);
		ranges.add(new Range(Integer.MIN_VALUE, Integer.MAX_VALUE));

		while (!nodes.isEmpty()) {
			TreeNode cur = nodes.poll();
			Range curRange = ranges.poll();
			if (cur.val <= curRange.low || cur.val > curRange.high) {
				return false;
			}
			if (cur.left != null) {
				nodes.add(cur.left);
				ranges.add(new Range(curRange.low, cur.val));
			}
			if (cur.right != null) {
				nodes.add(cur.right);
				ranges.add(new Range(cur.val, curRange.high));
			}
		}

		return true;
	}

	/*
	 * Question #6
	 */
	public TreeNode nextNode(TreeNode cur) {
		if (cur == null) {
			return null;
		}
		if (cur.right != null) {
			TreeNode right = cur.right;
			while (right.left != null) {
				right = right.left;
			}
			return right;
		} else {
			while (cur.parent != null && cur.parent.right == cur) {
				cur = cur.parent;
			}
			return cur.parent;
		}
	}

	/*
	 * Question #7
	 */
	/*
	 * Find two path
	 */

	public void printStack(Stack<TreeNode> s) {
		if (s == null) {
			System.out.println("Null Stack");
			return;
		}
		Stack<TreeNode> temp = new Stack<>();
		int size = s.size();
		for (int i = 0; i < size; ++i) {
			temp.push(s.pop());
		}
		for (int i = 0; i < size; ++i) {
			System.out.print(temp.peek().val + " ");
			s.push(temp.pop());
		}
		System.out.println();
	}

	/*
	 * Find the path from root to node based on Post-order Traversal
	 */
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
				while (!path.isEmpty() && root == path.peek().right) {
					root = path.pop();
				}
				if (path.isEmpty()) {
					return null;
				}
				root = path.peek().right; // Go to right sub tree
			}
		}
		return null;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
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

	/*
	 * Too slow
	 */
	public TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
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
			} else {
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
			if (result != null) {
				if (layer1 == curLayer && index1 == curIndex) {
					return result;
				}
				nodes.add(result.left);
				nodes.add(result.right);
			} else {
				nodes.add(null);
				nodes.add(null);
			}
			--count;
			++curIndex;
			if (count == 0) {
				curIndex = 0;
				++curLayer;
				count = (int) Math.pow(2, curLayer);
			}
		}

		return null;
	}

	/*
	 * Question #8
	 */
	public boolean isMatch(TreeNode t1, TreeNode t2) {
		Queue<TreeNode> t1Nodes = new LinkedList<>();
		Queue<TreeNode> t2Nodes = new LinkedList<>();
		t1Nodes.add(t1);
		t2Nodes.add(t2);
		while (!t1Nodes.isEmpty()) {
			TreeNode t1Cur = t1Nodes.poll();
			TreeNode t2Cur = t2Nodes.poll();
			if (t1Cur == null && t2Cur == null) {
				continue;
			}
			if (t1Cur == null || t2Cur == null) {
				return false;
			}
			if (t1Cur.val != t2Cur.val) {
				return false;
			}
			t1Nodes.add(t1Cur.left);
			t1Nodes.add(t1Cur.right);
			t2Nodes.add(t2Cur.left);
			t2Nodes.add(t2Cur.right);
		}

		return true;
	}

	public boolean isSubtree(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return false;
		}
		if (t2 == null) {
			return true;
		}
		Queue<TreeNode> t1Nodes = new LinkedList<>();
		t1Nodes.add(t1);
		while (!t1Nodes.isEmpty()) {
			TreeNode cur = t1Nodes.poll();
			if (cur.val == t2.val) {
				if (isMatch(cur, t2)) {
					return true;
				}
			}
			if (cur.left != null) {
				t1Nodes.add(cur.left);
			}
			if (cur.right != null) {
				t1Nodes.add(cur.right);
			}
		}

		return false;
	}

	/*
	 * Question #9
	 */
	/*
	 * Find a path that has a sum of "sum"
	 */
	public Stack<TreeNode> copyStack(Stack<TreeNode> path) {
		Stack<TreeNode> newPath = new Stack<>();
		Stack<TreeNode> helper = new Stack<>();

		while (!path.isEmpty()) {
			helper.push(path.pop());
		}

		while (!helper.isEmpty()) {
			path.push(helper.peek());
			newPath.push(helper.pop());
		}
		return newPath;
	}

	public LinkedList<Stack<TreeNode>> findSumPath(TreeNode root, int sum) {
		LinkedList<Stack<TreeNode>> result = new LinkedList<>();
		Stack<TreeNode> path = new Stack<>();
		int count = 0;
		while (root != null || !path.isEmpty()) {
			while (root != null) {
				path.push(root);
				count += root.val;
				if (count == sum) {
					result.add(copyStack(path));
				}
				root = root.left;
			}
			root = path.peek().right;
			if (root == null) { // Pop invalid partial path
				while (!path.isEmpty() && root == path.peek().right) {
					root = path.pop();
					count -= root.val;
				}
				if (path.isEmpty()) {
					return result;
				}
				root = path.peek().right; // Go to right sub tree
			}
		}
		return result;
	}

	public void printSumPath(TreeNode root, int sum) {
		if (root != null) {
			Queue<TreeNode> nodes = new LinkedList<>();
			nodes.add(root);
			while (!nodes.isEmpty()) {
				TreeNode cur = nodes.poll();
				LinkedList<Stack<TreeNode>> paths = findSumPath(cur, sum);
				for (int i = 0; i < paths.size(); ++i) {
					printStack(paths.get(i));
				}
				if (cur.left != null) {
					nodes.add(cur.left);
				}
				if (cur.right != null) {
					nodes.add(cur.right);
				}
			}
		}
	}
}
