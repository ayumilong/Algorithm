/**
 * File Name: ReverseLinkedListII.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:08:18 PM Oct 1, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 10:08:18 PM Oct 1, 2015
 */
public class ReverseLinkedListII {
	public void printList(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fakeHead = pre;
        ListNode reverseFront = head;
        ListNode reverseEnd = head;
        int count = n - m;
        while (m > 1) {
            pre = pre.next;
            --m;
        }
        reverseFront = pre.next;
        while (n > 1) {
            reverseEnd = reverseEnd.next;
            --n;
        }
        pre.next = reverseEnd;
        while (count > 0) {      // 1 2 3 4 5    m = 2 n = 4    
            pre = reverseFront;
            reverseFront = reverseFront.next;
            pre.next = reverseEnd.next;
            reverseEnd.next = pre;  
            --count;
        }
        return fakeHead.next;
    }
	
	public ListNode reverseBetween2(ListNode head, int m, int n){
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode start = head;
		ListNode pre = fakeHead;
		int range = n - m + 1;
		while(m > 1){
			--m;
			pre = start;
			start = start.next;
		}
		ListNode preReverse = null;
		ListNode next = start.next;
		while(true){
			start.next = preReverse;
			preReverse = start;
			start = next;
			--range;
			if(range == 0) break;
			next = next.next;
		}
		pre.next.next = start;
		pre.next = preReverse;
		
		return fakeHead.next;
	}
	
    public ListNode reverseBetween1(ListNode head, int m, int n) {
    		if(m == n){
    			return head;
    		}
        ListNode start = head;
        ListNode pre = null;
        int range = n - m + 1;
        while(m > 1){
            pre = start;
            start = start.next;
            --m;
        }
        ListNode preReverse = null;
        ListNode next = start.next;
        while(true){
            start.next = preReverse;
            preReverse = start;
            start = next;
            --range;
            if(range == 0) break;
            next = next.next;
        }
        if(pre != null){
        		pre.next.next = start;
        		pre.next = preReverse;
        }else{
        		head.next = start;
        		head = preReverse;
        }
        
        printList(head);
        
        return head;
    }
}
