/**
 * File Name: Main.java
 * Package Name: yz.geeksforgeeks
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:02:48 PM Oct 26, 2015
 * Author: Yaolin Zhang
 */
package yz.geeksforgeeks;

import java.util.*;

import yz.leetcode.tools.*;


/**
 * @author Yaolin Zhang
 * @time 8:02:48 PM Oct 26, 2015
 */
public class Main {
	public static void main(String args[]) {
		System.out.println("Please input something: ");
		Scanner sc = new Scanner(System.in);
		int total = 0;
		int differ = 0;
		int len = sc.nextInt();
		while (len != 0) {
			++total;
			System.out.println(total);
			int[] nums = new int[len];
			for (int i = 0; i < nums.length; ++i) {
				nums[i] = (int)(Math.random() * nums.length);
				//nums[i] = sc.nextInt();
			}
			//System.out.println(Arrays.toString(nums));
			
			int[] numbers = {2,0,2,1,3};
			
			PreorderSequenceOfBST ps = new PreorderSequenceOfBST();
			TreeNode root = ps.isPreorderBST(numbers);
			
			boolean result = ps.isPreorder(numbers);
			
			if((root == null && result) || (root != null && !result)){
				++differ;
				System.out.println((root == null ? false : true) + "---" + result);
				System.out.println(total + "---" + differ);
				sc.nextLine();
			}
		}
		sc.close();
	}
}
