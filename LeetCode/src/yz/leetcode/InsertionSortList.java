/**
 * File Name: InsertionSortList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:42:07 PM Oct 2, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:42:07 PM Oct 2, 2015
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            head = fakeHead.next;
            ListNode pre = fakeHead;
            while(head != cur.next && head.val < cur.next.val){
                pre = head;
                head = head.next;
            }
            if(head == cur.next){
                cur = cur.next; //Move cur to cur.next
            }else{
                ListNode temp = cur.next.next;
                cur.next.next = pre.next;
                pre.next = cur.next;
                cur.next = temp; //We delete original cur.next and insert it to a suitable position
                //So no need to move cur to cur.next
            }
        }
        return fakeHead.next;
    }
}
