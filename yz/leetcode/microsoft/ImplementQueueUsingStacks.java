/**
 * File Name: ImplementQueueUsingStacks.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:19:01 PM May 4, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:19:01 PM May 4, 2016
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        pushStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        move();
        if(!popStack.isEmpty()){
            popStack.pop();
        }
    }

    // Get the front element.
    public int peek() {
        move();
        if(popStack.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return popStack.peek();
    }
    
    private void move(){
        if(!popStack.isEmpty()){
            return;
        }
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
