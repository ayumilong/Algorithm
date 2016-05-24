/**
 * File Name: LRUCache.java
 * Package Name: yz.amazon.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 3:09:35 PM Apr 16, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 3:09:35 PM Apr 16, 2016
 */
public class LRUCache {
    private class DoubleListNode{
        int key;
        int val;
        DoubleListNode pre;
        DoubleListNode next;
        DoubleListNode(int key, int val, DoubleListNode pre, DoubleListNode next){
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
    
    private DoubleListNode head;
    private DoubleListNode tail;
    private HashMap<Integer, DoubleListNode> nodesMap; 
    private int capacity;
    
    public LRUCache(int capacity) {
        head = new DoubleListNode(0, 0, null, null);
        tail = new DoubleListNode(0, 0, head, null);
        head.next = tail;
        nodesMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(nodesMap.containsKey(key)){
            DoubleListNode cur = nodesMap.get(key);
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre; //Delete cur
            head.next.pre = cur; //Add cur to head
            cur.next = head.next;
            head.next = cur;
            cur.pre = head;
            return cur.val;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(nodesMap.containsKey(key)){
            get(key); //Move the node to head
            nodesMap.get(key).val = value;
        }else{
            if(capacity == 0){
                DoubleListNode last = tail.pre; //Delete a node from tail
                last.pre.next = tail;
                tail.pre = last.pre;
                nodesMap.remove(last.key);
                ++capacity;
            }
            //Add a node to head
            DoubleListNode newNode = new DoubleListNode(key, value, head, head.next);
            head.next.pre = newNode;
            head.next = newNode;
            nodesMap.put(key, newNode);
            --capacity;
        }
    }
}
