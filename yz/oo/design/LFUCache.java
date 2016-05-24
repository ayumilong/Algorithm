/**
 * File Name: LFUCache.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:18:34 PM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:18:34 PM Apr 23, 2016
 */
public class LFUCache {
    private class DoubleListNode{
        int key;
        int val;
        int count;
        DoubleListNode next;
        DoubleListNode pre;
        DoubleListNode(int k, int v, int c, DoubleListNode n, DoubleListNode p){
            key = k;
            val = v;
            count = c;
            next = n;
            pre = p;
        }
    }
    
    private int capacity;
    private HashMap<Integer, DoubleListNode> nodes; //Key to node
    private HashMap<Integer, DoubleListNode> queue; 
    //Frequency to node: link all the nodes that has the same frequency
    private DoubleListNode head;
    private DoubleListNode tail;

    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        this.capacity = capacity;
        nodes = new HashMap<>();
        head = new DoubleListNode(0, 0, Integer.MAX_VALUE, null, null);
        tail = new DoubleListNode(0, 0, Integer.MIN_VALUE, null, head);
        head.next = tail;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        if(nodes.containsKey(key)){
            get(key);
            nodes.get(key).val = value;
            return;
        }
        if(nodes.size() == capacity){
            nodes.remove(tail.pre.key);
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
        }
        DoubleListNode newNode = new DoubleListNode(key, value, 1, null, null);
        DoubleListNode preNode = tail.pre;
        while(preNode.count <= newNode.count){
            preNode = preNode.pre;
        }
        newNode.next = preNode.next;
        newNode.next.pre = newNode;
        newNode.pre = preNode;
        preNode.next = newNode;
        nodes.put(key, newNode);
    }

    public int get(int key) {
        // Write your code here
        if(!nodes.containsKey(key)){
            return -1;
        }
        DoubleListNode curNode = nodes.get(key);
        ++curNode.count;
        DoubleListNode preNode = curNode.pre;
        while(preNode.count <= curNode.count){
            preNode = preNode.pre;
        }
        curNode.pre.next = curNode.next;
        curNode.next.pre = curNode.pre;
        
        curNode.next = preNode.next;
        curNode.next.pre = curNode;
        curNode.pre = preNode;
        preNode.next = curNode;
        
        return curNode.val;
    }
}
