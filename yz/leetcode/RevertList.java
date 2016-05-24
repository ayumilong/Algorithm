/**
 * File Name: RevertList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:42:28 PM Sep 30, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 6:42:28 PM Sep 30, 2015
 */
public class RevertList {
    public ListNode reverseList(ListNode head) {
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
