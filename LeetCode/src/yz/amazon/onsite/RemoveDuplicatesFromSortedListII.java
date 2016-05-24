/**
 * File Name: RemoveDuplicatesFromSortedListII.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 6:16:06 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 6:16:06 PM Apr 17, 2016
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(head != null){
            boolean duplicate = false;
            while(head.next != null && head.val == head.next.val){
                duplicate = true;
                head = head.next;
            }
            if(duplicate){
                pre.next = head.next;
            }else{
                pre = head;
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}
