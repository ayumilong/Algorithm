/**
 * File Name: CountCompleteTreeNode.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:24:08 PM Oct 29, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 8:24:08 PM Oct 29, 2015
 */
public class CountCompleteTreeNode {
	/*
	 * Binary Search
	 */
	public int countNodes(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftHeight = 0;
		TreeNode cur = root;
		while(cur != null){
			++leftHeight;
		}
		
		return 0;
	}
	/*
	 * Recursive
	 */
	public int recursiveCount = 0;
	public int binaryCount = 0;
	public int traversalCount = 0;
    public int countNodes4(TreeNode root){
        if(root == null){
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int level = 0;
        while(left != null && right != null){
            ++level;
            left = left.left;
            right = right.right;
            this.recursiveCount += 1;
        }
        if(left == null && right == null){
            return (1 << level) - 1;
        }
        return countNodes4(root.left) + countNodes4(root.right) + 1;
    }
	/*
	 * Binary search
	 */
	public int countNodes3(TreeNode root){
		if(root == null){
			return 0;
		}
		TreeNode leftMost = root.left;
		int level = 0;
		while(leftMost != null){
			++level;
			leftMost = leftMost.left;
			this.binaryCount += 1;
		}
		int count = (1 << level) - 1; 
		
		int low = 0;
		int high = 1 << level;
		while(low < high){
			int middle = (low + high) / 2;
			int shift = level - 1; //Left shift two determine to move left or right
			TreeNode cur = root;
			int curLevel = 0;
			while(cur != null){
				++curLevel;
				this.binaryCount += 1;
				if((middle & (1 << shift)) == 0){
					cur = cur.left;
				}else{
					cur = cur.right;
				}
				--shift;
			}
			if(curLevel == level + 1){
				low = middle + 1;
			}else{
				high = middle;
			}
		}
		return count + low;
	}
	
	private int recursive(TreeNode root, int cur, int level){
		int index = 0;
		++cur;
		if(cur == level){
			++index;
			return index;
		}
		if(root.left != null){
			index += recursive(root.left, cur, level);
			++this.traversalCount;
		}
		if(root.right != null){
			index += recursive(root.right, cur, level);
			++this.traversalCount;
		}
		return index;
	}
	
	public int countNodes2(TreeNode root){
		if(root == null){
			return 0;
		}
		TreeNode leftMost = root.left;
		int level = 1;
		int count = 1;
		int preCount = 1;
		while(leftMost != null){
			++level;
			leftMost = leftMost.left;
			preCount *= 2;
			count += preCount;

            ++this.traversalCount;
		}
		count -= preCount;
		int index = recursive(root, 0, level);
		return count + index;
	}
	
    public int countNodes1(TreeNode root) {
        int count = 0;
        int preCount = 1;
        int index = 0;
        if(root != null){
            Stack<TreeNode> nodes = new Stack<>();
            nodes.push(root);
            count = 1;
            root = root.left;
            while(root != null || !nodes.isEmpty()){
                while(root != null){
                    nodes.push(root);
                    root = root.left;
                    preCount = 2 * preCount;
                    count += preCount;
                }
                count -= preCount;
                preCount = 0;
                ++index;
                nodes.pop();
                if(!nodes.isEmpty()){
                    root = nodes.pop().right;
                    if(root == null){ //Only last level's right node could be null and we are done
                        break;
                    }
                }
            }
        }
        return count + index;
    }
}
