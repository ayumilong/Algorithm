/**
 * File Name: PartitionList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 3:05:16 PM Oct 3, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 3:05:16 PM Oct 3, 2015
 */
public class PartitionList {
	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public ListNode partition(ListNode head, int x){
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode leftPre = fakeHead;
		while(head != null && head.val < x){
			leftPre = head;
			head = head.next;
		}
		ListNode rightPre = head;
		while(head != null){
			if(head.val < x){
				rightPre.next = head.next;
				head.next = leftPre.next;
				leftPre.next = head;
				leftPre = head;
				head = rightPre.next;
			}else{
				rightPre = head;
				head = head.next;
			}
		}
		return fakeHead;
	}
	
	/*
	 * 
	 */
    public ListNode partition1(ListNode head, int x) {
        ListNode leftList = new ListNode(0);
        ListNode rightList = new ListNode(0);
        ListNode leftPre = leftList;
        ListNode rightPre = rightList;
        while(head != null){
            if(head.val < x){
                leftPre.next = head;
                leftPre = head;
            }else{
                rightPre.next = head;
                rightPre = head;
            }
            head = head.next;
        }
        rightPre.next = null; //break circle
        leftPre.next = rightList.next;
        return leftList.next;
    }
}
