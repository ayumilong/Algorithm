/**
 * File Name: IntersectionOfTwoLinkedList.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:03:54 PM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:03:54 PM Apr 14, 2016
 */
public class IntersectionOfTwoLinkedList {
	//Two pointers
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA == null || headB == null){
			return null;
		}
		ListNode lastA = null;
		ListNode lastB = null;
		ListNode pa = headA;
		ListNode pb = headB;
		while(pa != pb){
			if(pa.next == null){
				lastA = pa;
				if(lastB != null && lastA != lastB){
					return null;
				}
				pa = headB;
			}else{
				pa = pa.next;
			}
			if(pb.next == null){
				lastB = pb;
				if(lastA != null && lastA != lastB){
					return null;
				}
				pb = headA;
			}else{
				pb = pb.next;
			}
		}
		return pa;
	}
	
	//HashMap
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
		if(headA == null || headB == null){
			return null;
		}
		HashSet<ListNode> set = new HashSet<>();
		while(headA != null){
			set.add(headA);
			headA = headA.next;
		}
		while(headB != null){
			if(!set.add(headB)){
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}
}
