/**
 * File Name: SortList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:40:28 PM Oct 2, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 11:40:28 PM Oct 2, 2015
 */
public class SortList {
	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	/*
	 * Quick Sort
	 */
	private class Result {
		ListNode leftHead;
		ListNode leftTail;
		ListNode rightHead;
		ListNode rightTail;
		ListNode middleNode;
	}

	private Result partition(ListNode head, ListNode tail) {
		int target = head.val;
		Result r = new Result();
		r.middleNode = head;
		r.leftHead = new ListNode(0);
		ListNode leftPre = r.leftHead;

		ListNode rightPre = head;
		head = head.next;
		while (head != null && head != tail.next) {
			if (head.val < target) {
				rightPre.next = head.next;
				leftPre.next = head;
				leftPre = head;
				head = head.next;
			} else {
				rightPre = head;
				head = head.next;
			}
		}
		r.rightTail = rightPre == r.middleNode ? null : rightPre;
		r.rightHead = r.middleNode.next == tail.next ? null : r.middleNode.next;
		r.leftTail = leftPre == r.leftHead ? null : leftPre;
		r.leftHead = r.leftHead.next;

		leftPre.next = r.middleNode;

		return r;
	}

	private ListNode quickSortList(ListNode head, ListNode tail) {
		if (head == tail) {
			return head;
		}
		Result r = partition(head, tail);
		ListNode leftList = quickSortList(r.leftHead, r.leftTail);
		ListNode rightList = quickSortList(r.rightHead, r.rightTail);

		if(rightList != null){
			r.middleNode.next = rightList;
		}
		return leftList != null ? leftList : r.middleNode;
	}

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		ListNode result = quickSortList(head, tail);
		return result;
	}

	/*
	 * Merge Sort
	 */
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fakeHead = new ListNode(0);
		ListNode pre = fakeHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pre.next = l1;
				pre = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				pre = l2;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			pre.next = l1;
		}
		if (l2 != null) {
			pre.next = l2;
		}
		return fakeHead.next;
	}

	private ListNode mergeSortList(ListNode head, int len) {
		if (len == 1) {
			return head;
		}
		int half = (len - 1) / 2;
		ListNode middle = head;
		while (half > 0) {
			middle = middle.next;
			--half;
		}
		ListNode rightList = middle.next;
		middle.next = null;
		ListNode leftList = mergeSortList(head, (len - 1) / 2 + 1);
		rightList = mergeSortList(rightList, len - (len - 1) / 2 - 1);
		head = mergeTwoLists(leftList, rightList);
		return head;
	}

	public ListNode sortList1(ListNode head) {
		if (head == null) {
			return null;
		}
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			++len;
		}
		return mergeSortList(head, len);

	}
}
