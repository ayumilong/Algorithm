/**
 * File Name: PalindromLinkedList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 5:12:36 PM Sep 29, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;


/**
 * @author Yaolin Zhang
 * @time 5:12:36 PM Sep 29, 2015
 */
public class PalindromLinkedList {
	private class Result{
		ListNode rightNode;
		boolean isEqual;
		Result(ListNode node, boolean equal){
			rightNode = node;
			isEqual = equal;
		}
	}
	
	/*
	 * 递归算法
	 */
	private Result recursive(ListNode head, int len){
		if(len == 0){ //当链表位空或者节点个数是偶数，例如 1 2 2 1， 当len=0时，head指向了第二个2 所以返回head去跟第一个2做比较
			return new Result(head, true);
		}
		if(len == 1){ //当链表节点个数是奇数，例如 1 2 1， 当len=1时， head指向了2 所以应该返回head.next也即第二个1去跟第一个1做比较
			return new Result(head.next, true);
		}
		Result temp = recursive(head.next, len - 2); //递归判断第i + 1个节点和第n - i - 1个节点的val是否相等
		if(temp.isEqual && temp.rightNode.val == head.val){ //Short-circuit effect， 也即短路效应，如果中间的子链表是palindrom则需要判断第i个节点和第n - i个节点是否val相等
			return new Result(temp.rightNode.next, true);
		}else{
			return new Result(null, false); //遇见一个false，则一次递归上传至上层调用，无需再传递rightNode
		}
	}
	
	public boolean isPalindrome(ListNode head){
		int len = 0;
		ListNode tail = head;
		while(tail != null){
			++len;
			tail = tail.next;
		}
		return recursive(head, len).isEqual;
	}
	
	public void printList(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
    public boolean isPalindrome2(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode middle = null;
        while(fast != null){ //Find the middle of the list
            if(fast.next != null){
                fast = fast.next;
            }
            fast = fast.next;
            middle = slow;
            slow = slow.next;
        }
        if(slow == null){ //Deal with 0 or 1 node
            return true;
        }
        ListNode pre = null;
        fast = slow.next;
        while(fast != null){ //Reverse the right half of the list
            slow.next = pre;
            pre = slow;
            slow = fast;
            fast = fast.next;
        }
        slow.next = pre;
        middle.next = slow;
        
        middle = middle.next;
        while(middle != null){
            if(head.val != middle.val){
                return false;
            }
            head = head.next;
            middle = middle.next;
        }
        
        
        
        return true;
    }
	
    public boolean isPalindrome1(ListNode head) {
        if(head == null){
        		return true;
        }
        int len = 1;
        ListNode tail = head;
        while(tail.next != null){
        		++len;
        		tail = tail.next;
        }
        
        int mid = (len - 1) / 2;
        ListNode middle = head;
        while(mid > 0){
        		middle = middle.next;
        		--mid;
        }
        
        mid = len / 2 - 1;
        ListNode newTail = middle.next;
        ListNode reverse = middle.next;
        while(mid > 0){ //Reverse the right half part
        		middle.next = reverse.next;
        		reverse.next = tail.next;
        		tail.next = reverse;
        		reverse = middle.next;
        		--mid;
        }
        tail = newTail;
        
        reverse = middle.next;
        ListNode first = head;
        while(reverse != null){
        		if(first.val != reverse.val){
        			return false;
        		}
        		first = first.next;
        		reverse = reverse.next;
        }
        //No need to re-reverse the right half part of the list, because Java is always pass by value
    		return true;
    }
}
