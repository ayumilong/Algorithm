/**
 * File Name: CopyRandomList.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:26:17 PM Jan 30, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 9:26:17 PM Jan 30, 2016
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode oldHead = head;
        while(head != null){//Transfer 1 -> 2 -> 3 to 1 -> 1' -> 2 -> 2' -> 3 -> 3'
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            newNode.random = head.random;
            head.next = newNode;
            head = newNode.next;
        }
        head = oldHead;
        while(head != null){//Compute random
            if(head.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = oldHead;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode pre = dummyHead;
        while(head != null){//Compute random
            pre.next = head.next;
            head.next = head.next.next;
            head = head.next;
            pre = pre.next;
        }
        return dummyHead.next;
    }
}
