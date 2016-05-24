/**
 * File Name: PathSum.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:45:35 PM May 6, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:45:35 PM May 6, 2016
 */
public class PathSum {
	//Post-order traversal
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> nodes = new Stack<>();
        int nodeSum = 0;
        while(root != null || !nodes.isEmpty()){
            while(root != null){
                nodes.push(root);
                nodeSum += root.val;
                root = root.left;
            }
            root = nodes.peek().right;
            if(root == null){
                if(nodes.peek().left == null && nodeSum == sum){
                    return true;
                }
                while(root == nodes.peek().right){
                    root = nodes.pop();
                    nodeSum -= root.val;
                    if(nodes.isEmpty()){
                        return false;
                    }
                }
                root = nodes.peek().right;
            }
        }
        
        return false;
    }
	//Recursive DFS
    public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
    //Return all the paths - Recursive Version DFS
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        helper(root, results, sum, new ArrayList<Integer>());
        return results;
    }
    private void helper(TreeNode root, List<List<Integer>> results, int sum, List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum){
                results.add(new ArrayList<>(path));
            }
        }else{
            helper(root.left, results, sum - root.val, path);
            helper(root.right, results, sum - root.val, path);
        }
        path.remove(path.size()  - 1);
    }
    
    //Post-order traversal
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        List<Integer> path = new ArrayList<>();
        int nodeSum = 0;
        while(root != null || !nodes.isEmpty()){
            while(root != null){
                nodes.push(root);
                path.add(root.val);
                nodeSum += root.val;
                root = root.left;
            }
            root = nodes.peek().right;
            if(root == null){
                if(nodes.peek().left == null && nodeSum == sum){
                    results.add(new ArrayList<>(path));
                }
                while(root == nodes.peek().right){
                    root = nodes.pop();
                    path.remove(path.size() - 1);
                    nodeSum -= root.val;
                    if(nodes.isEmpty()){
                        return results;
                    }
                }
                root = nodes.peek().right;
            }
        }
        return results;
    }
    
    
    //Leetcode 257 Binary Tree Paths: DFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, result, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(TreeNode root, List<String> result, List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null){
            result.add(toString(path));
        }else{
            helper(root.left, result, path);
            helper(root.right, result, path);
        }
        path.remove(path.size() - 1);
    }
    
    private String toString(List<Integer> path){
        StringBuilder sb = new StringBuilder();
        sb.append(path.get(0));
        for(int i = 1; i < path.size(); ++i){
            sb.append("->").append(path.get(i));
        }
        return sb.toString();
    }
    
    //Leetcode 129: Sum Root to Leaf Numbers: DFS
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int pathSum){
        if(root == null){
            return 0;
        }
        int sum = 0;
        pathSum = pathSum * 10 + root.val;
        if(root.left == null && root.right == null){
            sum += pathSum;
        }else{
            sum += helper(root.left, pathSum);
            sum += helper(root.right, pathSum);
        }
        //pathSum /= 10;
        return sum;
    }
    
    //Leetcode 124: Binary Tree Maximum Path Sum
    public int maxPathSum(TreeNode root) {
        return helper(root)[1];
    }
    
    public int[] helper(TreeNode root){
        if(root == null){
            return new int[]{0, Integer.MIN_VALUE};
        }
        int left[] = helper(root.left);
        int right[] = helper(root.right);
        //The maximum path sum of left and right subtree
        int maxSum = left[1] > right[1] ? left[1] : right[1];
        
        //The maximum path from starting from current root
        int singleMax  = left[0] > right[0] ? left[0] : right[0];
        singleMax = singleMax > 0 ? singleMax + root.val : root.val;
        
        //The maximum path with the current root as bridge
        int withRoot = left[0] + right[0] + root.val;
        withRoot = withRoot > singleMax ? withRoot : singleMax;
        
        //The maximum path sum of current tree
        maxSum = maxSum > withRoot ? maxSum : withRoot;
        
        return new int[]{singleMax, maxSum};
    }
}
