/**
 * File Name: MergeTwoSortedList.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:39:07 PM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 7:39:07 PM Apr 14, 2016
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode dummyHead = new ListNode(0);
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
        pre.next = (l1 == null) ? l2 : l1;
        return dummyHead.next;
    }
}
