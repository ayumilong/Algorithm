/**
 * File Name: ImplementQueueWithStack.java
 * Package Name: yz.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:18:18 AM Apr 26, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:18:18 AM Apr 26, 2016
 */
public class ImplementQueueWithStack {
	Stack<Integer> pushStack = new Stack<>();
	Stack<Integer> popStack = new Stack<>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        pushStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!popStack.empty()){
        		popStack.pop();
        }else{
        		while(!pushStack.empty()){
        			popStack.push(pushStack.pop());
        		}
        		popStack.pop();
        }
    }

    // Get the front element.
    public int peek() {
    	if(!popStack.empty()){
    		return popStack.peek();
    }else{
    		while(!pushStack.empty()){
    			popStack.push(pushStack.pop());
    		}
    		return popStack.peek();
    }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return pushStack.empty() && popStack.empty();
    }
}
