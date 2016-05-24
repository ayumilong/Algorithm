/**
 * File Name: Chapter2.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:24:08 PM Sep 19, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

import java.util.HashMap;

/**
 * @author Yaolin Zhang
 * @time 1:24:08 PM Sep 19, 2015
 */
public class Chapter2 {
	public void printList(SingleLinkedList head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
		System.out.println();
	}

	/*
	 * Question #1
	 */
	public SingleLinkedList removeDuplicates(SingleLinkedList head) {
		SingleLinkedList cur = head;
		HashMap<Integer, Boolean> map = new HashMap<>();
		SingleLinkedList pre = null;
		while (cur != null) {
			if (map.put(cur.getData(), true) != null) {
				pre.setNext(cur.getNext());
			} else {
				pre = cur;
			}
			cur = pre.getNext();
		}
		return head;
	}

	/*
	 * Question #2
	 */
	public SingleLinkedList getKthNode(SingleLinkedList head, int k) {
		if (k <= 0) {
			return null;
		}
		SingleLinkedList fast = head;
		SingleLinkedList slow = head;
		while (fast != null && k > 0) {
			fast = fast.getNext();
			--k;
		}
		if (fast == null) {
			return null;
		}
		while (fast != null) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return slow;
	}

	/*
	 * Question #3
	 */
	public boolean removeKthNode(SingleLinkedList kth) { // Cannot delete the
															// last node
		if (kth == null || !kth.hasNext()) {
			return false;
		}
		SingleLinkedList pre = kth;
		kth = kth.getNext();
		pre.setData(kth.getData());
		pre.setNext(kth.getNext());
		return true;
	}

	/*
	 * Question #4
	 */
	public void partition1(SingleLinkedList head, int x) {
		if (head == null) {
			return;
		}
		SingleLinkedList tail = head;
		while (tail.getNext() != null) {
			tail = tail.getNext();
		}
		SingleLinkedList fakeHead = new SingleLinkedList(-1);
		fakeHead.setNext(head);
		SingleLinkedList pre = fakeHead;
		SingleLinkedList cur = head;
		while (cur != tail) {
			if (cur.getData() >= x) {
				pre.setNext(cur.getNext());
				cur.setNext(tail.getNext());
				tail.setNext(cur);
			} else {
				pre = cur;
			}
			cur = pre.getNext();
		}
		head = fakeHead.getNext();
		printList(head);
	}

	/*
	 * Question #4 GF
	 */
	public void partition(SingleLinkedList head, int x) {
		if (head == null) {
			return;
		}
		SingleLinkedList p1 = head; // 第一个小于x
		SingleLinkedList p2 = head; // 第一个不小于x
		SingleLinkedList cur = null;
		while (p1.getNext() != null && p1.getData() >= x) {
			p1 = p1.getNext();
		}
		int tempVal = head.getData();
		head.setData(p1.getData());
		p1.setData(tempVal);
		p1 = head;

		while (p2.getNext() != null && p2.getData() < x) {
			p2 = p2.getNext();
		}
		cur = p2.getNext();
		SingleLinkedList pre = p2;
		while (cur != null) {
			if (cur.getData() < x) {
				pre.setNext(cur.getNext());
				cur.setNext(p1.getNext());
				p1.setNext(cur);
			} else {
				pre = cur;
			}
			cur = pre.getNext();
			printList(head);
		}

	}

	/*
	 * Question #5
	 */

	public SingleLinkedList addReverseLists(SingleLinkedList num1, SingleLinkedList num2) {
		SingleLinkedList result = new SingleLinkedList(0);
		SingleLinkedList cur = result;
		int carry = 0;
		while (num1 != null || num2 != null || carry != 0) {
			int curResult = carry;
			if (num1 != null) {
				curResult += num1.getData();
				num1 = num1.getNext();
			}
			if (num2 != null) {
				curResult += num2.getData();
				num2 = num2.getNext();
			}
			carry = curResult / 10;
			cur.setNext(new SingleLinkedList(curResult % 10));
			cur = cur.getNext();
		}
		return result.getNext();
	}

	public SingleLinkedList reverse(SingleLinkedList head) {
		if (head == null) {
			return null;
		}
		SingleLinkedList next = head.getNext();
		SingleLinkedList pre = null;
		while (next != null) {
			head.setNext(pre);
			pre = head;
			head = next;
			next = next.getNext();
		}
		head.setNext(pre);

		return head;
	}

	public SingleLinkedList reverse1(SingleLinkedList head) {
		if (head == null) {
			return null;
		}
		SingleLinkedList tail = head;
		while (tail.getNext() != null) {
			tail = tail.getNext();
		}
		SingleLinkedList fakeHead = new SingleLinkedList(0);
		fakeHead.setNext(head);
		SingleLinkedList pre = fakeHead;
		while (head != tail) {
			pre.setNext(head.getNext());
			head.setNext(tail.getNext());
			tail.setNext(head);
			head = pre.getNext();
		}
		return fakeHead.getNext();
	}

	public SingleLinkedList addNormalLists(SingleLinkedList num1, SingleLinkedList num2) {
		num1 = reverse(num1);
		num2 = reverse(num2);

		SingleLinkedList result = addReverseLists(num1, num2);

		num1 = reverse(num1);
		num2 = reverse(num2);

		printList(reverse(result));

		return reverse(result);
	}

	/*
	 * Question #6
	 */
	public SingleLinkedList findCircle(SingleLinkedList head) {
		if (head == null) {
			return null;
		}
		SingleLinkedList fast = head;
		SingleLinkedList slow = head;
		while (true) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if (fast == slow) {
				SingleLinkedList start = head;
				while (start != slow) {
					start = start.getNext();
					slow = slow.getNext();
				}
				return start;
			}
		}
	}

	/*
	 * Question #7
	 */
	public boolean isPalindrom(SingleLinkedList head) {
		if (head == null) {
			return true;
		}
		int len = 1;
		SingleLinkedList tail = head;
		while (tail.getNext() != null) {
			++len;
			tail = tail.getNext();
		}

		int mid = (len - 1) / 2;
		SingleLinkedList middle = head;
		while (mid > 0) {
			middle = middle.getNext();
			--mid;
		}

		mid = len / 2 - 1;
		SingleLinkedList newTail = middle.getNext();
		SingleLinkedList reverse = middle.getNext();
		while (mid > 0) { // Reverse the right half part
			middle.setNext(reverse.getNext());
			;
			reverse.setNext(tail.getNext());
			tail.setNext(reverse);
			reverse = middle.getNext();
			--mid;
		}
		tail = newTail;

		reverse = middle.getNext();
		SingleLinkedList first = head;
		while (reverse != null) {
			if (first.getData() != reverse.getData()) {
				return false;
			}
			first = first.getNext();
			reverse = reverse.getNext();
		}
		return true;
	}
}
