/**
 * File Name: BinaryTreeRightSideView.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:15:48 PM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 9:15:48 PM Apr 14, 2016
 */
public class BinaryTreeRightSideView {
	private void recursive(TreeNode root, int level, List<Integer> result){
		if(level == result.size()){
			result.add(root.val);
		}
		if(root.right != null){
			recursive(root.right, level + 1, result);
		}
		if(root.left != null){
			recursive(root.left, level + 1, result);
		}
	}
	//Recursive
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> result = new LinkedList<>();
		if(root == null){
			return result;
		}
		recursive(root, 0, result);
		return result;
	}
	//Non-recursive, level-scan like solution
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        nodes.add(root);
        values.add(root.val);
        while(!nodes.isEmpty()){
            List<TreeNode> parent = nodes;
            nodes = new ArrayList<>();
            result.add(values.get(values.size() - 1));
            for(TreeNode node : parent){
                if(node.left != null){
                    nodes.add(node.left);
                    values.add(node.left.val);
                }
                if(node.right != null){
                    nodes.add(node.right);
                    values.add(node.right.val);
                }
            }
        }
        return result;
    }
}
