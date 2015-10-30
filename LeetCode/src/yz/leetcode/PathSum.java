/**
 * File Name: PathSum.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:53:14 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:53:14 PM Oct 24, 2015
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> path = new Stack<>();
        int count = 0;
        while(root != null || !path.isEmpty()){
        		while(root != null){
        			path.push(root);
        			count += root.val;
        			root = root.left;
        		}
        		if(count == sum && path.peek().left == null && path.peek().right == null){
        			return true;
        		}
        		root = path.peek().right;
        		if(root == null){
        			if(count == sum && path.peek().left == null){
            			return true;
            		}
        			while(root == path.peek().right){
        				root = path.pop();
        				count -= root.val;
        			    if(path.isEmpty()){
        				    return false;
        			    }
        			}
        			root = path.peek().right;
        		}
        }
    		return false;
    }
}
