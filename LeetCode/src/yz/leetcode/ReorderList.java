/**
 * File Name: ReorderList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 3:53:38 PM Oct 3, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 3:53:38 PM Oct 3, 2015
 */
public class ReorderList {
	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
    private ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode next = head.next;
        while(next != null){
            head.next = pre;
            pre = head;
            head = next;
            next = next.next;
        }
        head.next = pre;
        return head;
    }
    
    /*
     * O(n)
     */
    public void reorderList3(ListNode head) {
        if(head == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null; //Break linked list
        right = reverse(right);
        while(right != null){
            ListNode temp = right.next;
            right.next = head.next;
            head.next = right;
            head = head.next.next;
            right = temp;
        }
    }
    
    /*
     * O(n2)
     */
    public void reorderList2(ListNode head) {
        if(head == null){
            return;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while(cur != null){
            cur = reverse(cur);
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
    }
	
    private ListNode recursiveReorder(ListNode head, ListNode tail, int len){
        if(len == 0){
            return head;
        }
        if(len == 1){
            return head.next;
        }
        if(len == 2){
            return head.next.next;
        }
        ListNode right = recursiveReorder(head.next, tail, len - 2);
        tail.next = right.next;
        right.next = head.next;
        head.next = right;
        
        return tail.next;
        
    }
    
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            len += 2;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            ++len;
        }
        recursiveReorder(head, slow, len);
        printList(head);
    }
}
