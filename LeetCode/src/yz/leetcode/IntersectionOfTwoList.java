/**
 * File Name: IntersectionOfTwoList.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:45:28 PM Sep 30, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.leetcode.tools.*;
import java.util.HashMap;

/**
 * @author Yaolin Zhang
 * @time 6:45:28 PM Sep 30, 2015
 */
public class IntersectionOfTwoList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
        while(headA != null){
            map.put(headA, true);
            headA = headA.next;
        }
        while(headB != null){
            if(map.containsKey(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
