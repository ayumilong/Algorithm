/**
 * File Name: LoadBalancer.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:22:01 PM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:22:01 PM Apr 23, 2016
 */
public class LoadBalancer {
    private class DoubleListNode{
        int id;
        DoubleListNode pre;
        DoubleListNode next;
        DoubleListNode(int id, DoubleListNode p, DoubleListNode n){
            this.id = id;
            pre = p;
            next = n;
        }
    }
    
    HashMap<Integer, DoubleListNode> servers;
    DoubleListNode head;
    DoubleListNode tail;

    public LoadBalancer() {
        // Initialize your data structure here.
        servers = new HashMap<>();
        head = new DoubleListNode(-1, null, null);
        tail = new DoubleListNode(-1, head, null);
        head.next = tail;
    }

    // @param server_id add a new server to the cluster 
    // @return void
    public void add(int server_id) {
        // Write your code here
        if(!servers.containsKey(server_id)){
            DoubleListNode newNode = new DoubleListNode(server_id, tail.pre, tail);
            tail.pre = newNode;
            newNode.pre.next = newNode;
            servers.put(server_id, newNode);
        }
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
        if(servers.containsKey(server_id)){
            DoubleListNode curNode = servers.get(server_id);
            curNode.pre.next = curNode.next;
            curNode.next.pre = curNode.pre;
            servers.remove(server_id);
        }
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
        int index = (int)(Math.random() * servers.size()) + 1;
        DoubleListNode curNode = head;
        while(index > 0){
            --index;
            curNode = curNode.next;
        }
        return curNode.id;
    } 
}
