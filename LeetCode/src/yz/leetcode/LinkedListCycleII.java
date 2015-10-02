/**
 * File Name: LinkedListCycleII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:33:44 PM Oct 1, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:33:44 PM Oct 1, 2015
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
        		fast = fast.next.next;
        		slow = slow.next;
        		if(fast == slow){
        			break;
        		}
        }
        if(fast == null || fast.next == null){
        		return null;
        }
        slow = head;
        while(slow != fast){
        		slow = slow.next;
        		fast = fast.next;
        }
    		return slow;
    }
}
