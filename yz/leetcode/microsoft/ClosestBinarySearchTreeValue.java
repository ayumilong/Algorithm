/**
 * File Name: ClosestValue.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:21:12 PM May 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 8:21:12 PM May 4, 2016
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        TreeNode pre = root;
        double min = Math.abs(target - root.val);
        while(root != null){
            if(root.val == target){
                return root.val;
            }else if(root.val < target){
                if(target - root.val < min){
                    min = target - root.val;
                    pre = root;
                }
                root = root.right;
            }else{
                if(root.val - target < min){
                    min = root.val - target;
                    pre = root;
                }
                root = root.left;
            }
        }
        return pre.val;
    }
}
