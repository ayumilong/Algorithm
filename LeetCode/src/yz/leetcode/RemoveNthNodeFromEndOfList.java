/**
 * File Name: RemoveNthNodeFromEndOfList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:43:37 PM Sep 30, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 6:43:37 PM Sep 30, 2015
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(n > 0){
            fast = fast.next;
            --n;
        }
        while(fast != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if(pre == null){
            return head.next;
        }else{
            pre.next = slow.next;
        }
        
        return head;
    }
}
