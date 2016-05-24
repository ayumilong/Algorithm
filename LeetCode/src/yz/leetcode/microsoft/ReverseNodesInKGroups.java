/**
 * File Name: ReverseNodesInKGroups.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:52:18 PM May 15, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:52:18 PM May 15, 2016
 */
public class ReverseNodesInKGroups {
	//Swap two nodes in list
	//1->2->3->4 to 2->1->4->3
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(pre.next != null && pre.next.next != null){
            ListNode temp = pre.next;
            pre.next = pre.next.next;
            temp.next = pre.next.next;
            pre.next.next = temp;
            pre = pre.next.next;
        }
        return dummyHead.next;
    }
	
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(head != null){
            int count = 1;
            while(head != null && count < k){
                ++count;
                head = head.next;
            }
            if(head == null){
                return dummyHead.next; 
            }
            ListNode first = pre.next;
            //Extract the current group from the original list
            pre.next = head.next;
            //Reverse current group
            head.next = null;
            head = reverseList(first);
            //Insert current reversed group back into the original list
            first.next = pre.next;
            pre.next = head;
            
            //The start of next group, if still exist
            pre = first;
            head = pre.next;
        }
        return dummyHead.next;
    }
    
    private ListNode reverseList(ListNode head){
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
