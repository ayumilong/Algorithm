/**
 * File Name: RemoveDuplicatesFromSoretedListII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 5:53:32 PM Oct 1, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 5:53:32 PM Oct 1, 2015
 */
public class RemoveDuplicatesFromSoretedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        while(head != null && head.next != null){
        		if(head.val == head.next.val){
        			int val = head.val;
        			while(head != null && head.val == val){
        				head = head.next;
        			}
        			pre.next = head;
        		}else{
        			pre = head;
        			head = head.next;
        		}
        }
        
        return fakeHead.next;
    }
}
