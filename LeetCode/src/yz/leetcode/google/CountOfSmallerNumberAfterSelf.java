/**
 * File Name: CountOfSmallerNumberAfterSelf.java
 * Package Name: yz.leetcode.google
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:16:08 PM May 19, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.google;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:16:08 PM May 19, 2016
 */
public class CountOfSmallerNumberAfterSelf {
    private class TreeNode{
        int val;
        int dup; //Count of duplications
        int count; //Number of numbers <= val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.dup = 0;
            this.count = 0;
            this.left = null;
            this.right = null;
        }
    }
    //Binary Search and insert form last number to first one, O(n*n)
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> sorted = new ArrayList<>();
        int[] result = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; --i){
            result[i] = binarySearch(sorted, nums[i]);
            sorted.add(result[i], nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int n : result){
            list.add(n);
        }
        return list;
    }
    
    private int binarySearch(List<Integer> sorted, int target){//Find first index of target
        int low = 0;
        int high = sorted.size();
        while(low < high){
            int mid = low + (high - low) / 2;
            int cur = sorted.get(mid);
            if(cur == target){
                if(mid == 0 || sorted.get(mid - 1) < target){
                    return mid;
                }else{
                    high = mid;
                }
            }else if(cur > target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    
    //Build Binary Search Tree, O(nlgn)
    public List<Integer> countSmaller1(int[] nums) {
        if(nums == null || nums.length == 0){
            return new LinkedList<Integer>();
        }
        LinkedList<Integer> results = new LinkedList<>();
        TreeNode root = new TreeNode(nums[nums.length - 1]); //Root is the middle value of nums
        for(int i = nums.length - 1; i >= 0; --i){
            insert(root, nums[i], 0, results);
        }
        return results;
    }
    
    private TreeNode insert(TreeNode root, int val, int count, LinkedList<Integer> results){
        if(root == null){
            results.addFirst(count);
            root = new TreeNode(val);
            root.count = 1;
            root.dup = 1;
            return root;
        }
        if(val < root.val){
            root.left = insert(root.left, val, count, results);
            ++root.count;
        }else if(val == root.val){
            count += root.count - root.dup;
            results.addFirst(count);
            ++root.count;
            ++root.dup;
        }else{
            count += root.count;
            root.right = insert(root.right, val, count, results);
        }
        return root;
    }
}
