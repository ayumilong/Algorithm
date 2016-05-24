/**
 * File Name: ReorderList.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 2:17:55 PM Apr 3, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 2:17:55 PM Apr 3, 2016
 */
public class ReorderList {
	public static  void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ListNode dummy = new ListNode(-1);
		ListNode pre = dummy;
		while(n > 0){
			--n;
			pre.next = new ListNode(scan.nextInt());
			pre = pre.next;
		}
		ReorderList rl = new ReorderList();
		rl.reorderList(dummy.next);
		while(dummy.next != null){
			System.out.print(dummy.next.val + " ");
			dummy = dummy.next;
		}
		System.out.println();
		scan.close();
	}
	
    public void reorderList(ListNode head) {  
        if(head == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){//Find the middle node
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if(pre == null){//Only has one node in the list
        		return;
        }
        ListNode right = slow;
        pre.next = null; //Split to two list: left part and right part
        while(right != null){//Insert the half right part to half left part one by one
        		if(head.next == null){//Last two nodes for odd list (has odd number of nodes)
        			head.next = right;
        			break;
        		}
            ListNode temp = right.next;
            	right.next = head.next;
            head.next = right;
            head = head.next.next;
            right = temp;
        }
    }
    
    public void reverseReorderList(ListNode head) {  
        if(head == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){//Find the middle node
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        while(right != null && right.next != null){//Reverse the half right part
            ListNode temp = slow.next;
            slow.next = right.next;
            right.next = right.next.next;
            slow.next.next = temp;
        }
        right = slow.next;
        slow.next = null;//Slow is the last node after reorder
        while(right != null){//Insert the half right part to half left part one by one
            ListNode temp = right.next;
            right.next = head.next;
            head.next = right;
            head = head.next.next;
            right = temp;
        }
    }    
}
