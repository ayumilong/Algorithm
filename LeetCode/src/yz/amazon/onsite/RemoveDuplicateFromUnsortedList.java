/**
 * File Name: RemoveDuplicateFromUnsortedList.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 5:52:30 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 5:52:30 PM Apr 17, 2016
 */
public class RemoveDuplicateFromUnsortedList {
	//Remove duplicates, 1 -> 2 -> 1 -> 3 will be 2 -> 3
    public ListNode removeDuplicates(ListNode head) {
		if(head == null){
		    return null;
		}
		HashMap<Integer, Boolean> nodes = new HashMap<>();
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		head = dummyHead;
		while(head.next != null){
		    if(nodes.containsKey(head.next.val)){
		        nodes.put(head.next.val, true);
		        head.next = head.next.next;
		    }else{
		        nodes.put(head.next.val, false);
		        head = head.next;
		    }
		}
		head = dummyHead;
		while(head.next != null){
		    if(nodes.get(head.next.val)){
		        head.next = head.next.next;
		    }else{
		        head = head.next;
		    }
		}
		return dummyHead.next;
	} 
	//Remove duplicate, 1 -> 2 -> 1 -> 3 to 1 -> 2 -> 3
    public ListNode removeDuplicates1(ListNode head) {
		if(head == null){
		    return null;
		}
		HashSet<Integer> nodes = new HashSet<>();
		nodes.add(head.val);
		ListNode oldHead = head;
		while(head.next != null){
		    if(nodes.contains(head.next.val)){
		        head.next = head.next.next;
		    }else{
		        nodes.add(head.next.val);
		        head = head.next;
		    }
		}
		return oldHead;
	}
}
