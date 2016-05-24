/**
 * File Name: ReverseLinkedList.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:17:06 PM Apr 30, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:17:06 PM Apr 30, 2016
 */
public class ReverseLinkedList {
	//Recursive
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
	//Iterative
    public ListNode reverseList1(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while(head.next != null){
            ListNode temp = dummyHead.next;
            dummyHead.next = head.next;
            head.next = head.next.next;
            dummyHead.next.next = temp;
        }
        return dummyHead.next;
    }
}
