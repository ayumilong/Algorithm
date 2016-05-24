/**
 * File Name: LevelOrderTraversal.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:54:50 PM May 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:54:50 PM May 4, 2016
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while(!level.isEmpty()){
            List<TreeNode> parent = level;
            level = new ArrayList<>();
            List<Integer> levelInt = new ArrayList<>();
            for(TreeNode node : parent){
                levelInt.add(node.val);
                if(node.left != null){
                    level.add(node.left);
                }
                if(node.right != null){
                    level.add(node.right);
                }
            }
            results.add(levelInt);
        }
        return results;
    }
    //Traditional BFS
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        bfs.offer(null);
        int level = 0;
        results.add(new ArrayList<>());
        while(!bfs.isEmpty()){
            TreeNode cur = bfs.poll();
            if(cur == null){
                if(bfs.isEmpty()){
                    return results;
                }
                ++level;
                results.add(new ArrayList<>());
                bfs.offer(null);
            }else{
                results.get(level).add(cur.val);
                if(cur.left != null){
                    bfs.offer(cur.left);
                }
                if(cur.right != null){
                    bfs.offer(cur.right);
                }
            }
        }
        
        return results;
    }
}
