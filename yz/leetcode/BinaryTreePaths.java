/**
 * File Name: BinaryTreePaths.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 12:53:33 AM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 12:53:33 AM Oct 25, 2015
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new LinkedList<>();
        if(root != null){
        		Stack<TreeNode> nodes = new Stack<>();
        		String path = "";
        		while(root != null || !nodes.isEmpty()){
        			while(root != null){
        				nodes.push(root);
        				path = path == "" ? root.val + "" : path + "->" + root.val;
        				root = root.left;
        			}
        			root = nodes.peek().right;
        			if(root == null){
        				if(nodes.peek().left == null){
        					results.add(path);
        				}
        				while(root == nodes.peek().right){
        					root = nodes.pop();
        					if(nodes.isEmpty()){
        						return results;
        					}
        					path = path.substring(0, path.lastIndexOf("->"));
        					System.out.println(path);
        				}
        				root = nodes.peek().right;
        			}
        		}
        }
    	
    		return results;
    }
}
