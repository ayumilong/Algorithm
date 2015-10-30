/**
 * File Name: Main.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose: Start point of the application
 * Created Time: 9:53:36 PM Aug 18, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

import yz.leetcode.tools.BST;

/**
 * @author Yaolin Zhang
 * @time 9:53:36 PM Aug 18, 2015
 */

public class Main {
	public static void main(String args[]) {
		System.out.println("Please input something: ");
		Scanner sc = new Scanner(System.in);

		int[] nums = new int[sc.nextInt()];
		for (int i = 0; i < nums.length; ++i) {
			nums[i] = i + 1;
		}

		BST bst = new BST(nums);
		// bst.insert(sc.nextInt());
		bst.printBST();
		int deleteNum = sc.nextInt();
		while (deleteNum > 0) {
			bst.delete(sc.nextInt());
			bst.printBST();
			--deleteNum;
			bst.insert(sc.nextInt());
			bst.printBST();
		}

		while (sc.hasNext()) {
			System.out.println(bst.kthNumber(sc.nextInt()));
		}

		sc.close();
	}
}
