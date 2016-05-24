/**
 * File Name: CopyListWithRandomPointer.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:38:08 PM Apr 20, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import yz.leetcode.tools.*;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:38:08 PM Apr 20, 2016
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode pre = dummyHead;
        while(head != null){
            pre.next = head.next;
            pre = pre.next;
            head.next = head.next.next;
            head = head.next;
        }
        return dummyHead.next;
    }
    
    public RandomListNode copyRandomList1(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> old2New = new HashMap<>();
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode pre = dummyHead;
        while(head != null){
            if(old2New.containsKey(head)){
                pre.next = old2New.get(head);
            }else{
                pre.next = new RandomListNode(head.label);
                old2New.put(head, pre.next);
            }
            if(head.random != null){
                if(old2New.containsKey(head.random)){
                    pre.next.random = old2New.get(head.random);
                }else{
                    pre.next.random = new RandomListNode(head.random.label);
                    old2New.put(head.random, pre.next.random);
                }
            }
            head = head.next;
            pre = pre.next;
        }
        return dummyHead.next;
    }
}
