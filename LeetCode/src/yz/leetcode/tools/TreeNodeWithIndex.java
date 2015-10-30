/**
 * File Name: BstWithIndex.java
 * Package Name: yz.leetcode.tools
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:37:19 PM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode.tools;

/**
 * @author Yaolin Zhang
 * @time 10:37:19 PM Oct 25, 2015
 */
public class TreeNodeWithIndex {
	public int val;
	public int count; //How many nodes in this tree
	public int index; //The index in in-order traversal sequence
	public TreeNodeWithIndex left;
	public TreeNodeWithIndex right;
	public TreeNodeWithIndex(int v){
		this.val = v;
		this.index = 1;
		this.count = 1;
	}
}
