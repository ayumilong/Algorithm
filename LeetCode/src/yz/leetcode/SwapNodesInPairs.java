/**
 * File Name: SwapNodesInPairs.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:49:57 PM Oct 1, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 9:49:57 PM Oct 1, 2015
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        while(head != null && head.next != null){
            pre.next = head.next;
            head.next = pre.next.next;
            pre.next.next = head;
            pre = head;
            head = head.next;
        }
        return fakeHead.next;
    }
}
