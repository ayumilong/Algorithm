/**
 * File Name: MergeTwoSortedList.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:05:15 PM May 2, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 9:05:15 PM May 2, 2016
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 != null){
            pre.next = l1;
        }else if(l2 != null){
            pre.next = l2;
        }
        //pre.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}
