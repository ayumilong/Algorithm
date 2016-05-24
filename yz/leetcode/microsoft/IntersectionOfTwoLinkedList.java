/**
 * File Name: IntersectionOfTwoLinkedList.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 2:30:10 PM May 11, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 2:30:10 PM May 11, 2016
 */
public class IntersectionOfTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lenA = 0;
		ListNode head = headA;
		while (head != null) {
			++lenA;
			head = head.next;
		}
		head = headB;
		int lenB = 0;
		while (head != null) {
			++lenB;
			head = head.next;
		}
		while (lenA > lenB) {
			--lenA;
			headA = headA.next;
		}
		while (lenB > lenA) {
			--lenB;
			headB = headB.next;
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pa = headA;
		ListNode pb = headB;
		ListNode lastA = null;
		ListNode lastB = null;
		while (pa != pb) {
			if (pa.next == null) {
				lastA = pa;
				if (lastB != null && lastA != lastB) {
					return null;
				}
				pa = headB;
			} else {
				pa = pa.next;
			}
			if (pb.next == null) {
				lastB = pb;
				if (lastA != null && lastA != lastB) {
					return null;
				}
				pb = headA;
			} else {
				pb = pb.next;
			}
		}
		return pa;
	}

	// Using HashSet
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		HashSet<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		while (headB != null) {
			if (!set.add(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}
}
