/**
 * File Name: Main.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:19:08 PM Aug 30, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 1:19:08 PM Aug 30, 2015
 */
public class Main {
	
	public static void main(String args[]){
		System.out.println("Please input something: ");
		Scanner sc = new Scanner(System.in);
		
		Chapter4 c4 = new Chapter4();
		
		int[] nums = new int[sc.nextInt()];
		for(int i = 0; i < nums.length; ++i){
			nums[i] = sc.nextInt();
		}
		
		TreeNode root = c4.createBinaryTree(nums);
		c4.printLinkedList(c4.createLinkedList(root));
		System.out.println(Arrays.toString(c4.preorderTraversalRecursive(root).toArray()));
		
		sc.close();
	}
}
