/**
 * File Name: RotateList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:06:56 PM Oct 2, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 11:06:56 PM Oct 2, 2015
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 1;
        ListNode tail = head;
        while(tail != null && tail.next != null){ //Use tail != null to deal with the case of head == null
            ++len;
            tail = tail.next;
        }
        if(k % len == 0){ // Any number mod 1 is 0
            return head;
        }
        k = len - k % len;
        tail.next = head;
        while(k > 1){
        		head = head.next;
        		--k;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
    
    public ListNode rotateRight1(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        ListNode fast = head;
        ListNode tail = null;
        int count = k;
        int len = 0;
        while(fast != null && count > 0){
            tail = fast;
            fast = fast.next;
            --count;
            ++len;
        }
        if(fast == null){
            k = k % len;
            if(k == 0){
                return head;
            }
            int steps = len - k;
            fast = head;
            ListNode pre = null;
            while(steps > 0){
                pre = fast;
                fast = fast.next;
                --steps;
            }
            pre.next = null;
            tail.next = head;
            
            return fast;
        }else{
            ListNode slow = head;
            ListNode pre = null;
            while(fast != null){
                tail = fast;
                fast = fast.next;
                pre = slow;
                slow = slow.next;
            }
            pre.next = null;
            tail.next = head;
            return slow;
        }
        
    }
}
