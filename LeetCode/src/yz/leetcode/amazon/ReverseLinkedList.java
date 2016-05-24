/**
 * File Name: ReverseLinkedList.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:44:30 PM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 7:44:30 PM Apr 14, 2016
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        while(head.next != null){
            ListNode temp = dummyHead.next;
            dummyHead.next = head.next;
            head.next = head.next.next;
            dummyHead.next.next = temp;
        }
        return dummyHead.next;
    }
    
    public ListNode reverseList1(ListNode head) {
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
}
