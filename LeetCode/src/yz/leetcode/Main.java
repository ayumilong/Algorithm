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
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 9:53:36 PM Aug 18, 2015
 */

public class Main {
	public static void main(String args[]) {

		System.out.println("Please input something: ");
		Scanner sc = new Scanner(System.in);

		int len = sc.nextInt();
		ListNode head = new ListNode(sc.nextInt());
		ListNode cur = head;
		for (int i = 1; i < len; ++i) {
			cur.next = new ListNode(sc.nextInt());
			cur = cur.next;
		}
		ReverseLinkedListII rll = new ReverseLinkedListII();
		rll.reverseBetween(head, sc.nextInt(), sc.nextInt());
		sc.close();
	}
}
