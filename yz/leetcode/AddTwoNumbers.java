/**
 * File Name: AddTwoNumbers.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:08:44 PM Oct 1, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 11:08:44 PM Oct 1, 2015
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curNode = result;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int cur = carry;
            if(l1 != null){
                cur += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                cur += l2.val;
                l2 = l2.next;
            }
            carry = cur / 10;
            curNode.next = new ListNode(cur % 10);
            curNode = curNode.next;
        }
        return result.next;
    }
}
