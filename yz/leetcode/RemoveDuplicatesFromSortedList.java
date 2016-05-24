/**
 * File Name: RemoveDuplicatesFromSortedList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:44:31 PM Sep 30, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 6:44:31 PM Sep 30, 2015
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode first = head;
        ListNode cur = head.next;
        while(cur != null){
            if(first.val == cur.val){
                first.next = cur.next;
                cur = cur.next;
            }else{
                first = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
