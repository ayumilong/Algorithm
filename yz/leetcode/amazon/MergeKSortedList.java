/**
 * File Name: MergeKSortedList.java
 * Package Name: yz.amazon.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 3:25:59 PM Apr 16, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 3:25:59 PM Apr 16, 2016
 */
public class MergeKSortedList {
	//Divide-and-Conquer, Merge sort
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        int jump = 1;
        while(jump < lists.length){
            for(int i = 0; i < lists.length - jump; i += jump * 2){
            		lists[i] = mergeTwoLists(lists[i], lists[i + jump]);
            }
            jump *= 2;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
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
        pre.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
    //Use PriorityQueue as Heap
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
            
        });
        for(ListNode l : lists){
        		if(l != null){
        			pq.offer(l);
        		}
        }
        ListNode dummyNode = new ListNode(0);
        ListNode pre = dummyNode;
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            if(cur.next != null){
                pq.offer(cur.next);
            }
            pre.next = cur;
            pre = pre.next;
        }
        return dummyNode.next;
    }
}
