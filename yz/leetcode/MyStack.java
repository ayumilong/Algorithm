/**
 * File Name: MyStack.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:11:32 PM Oct 15, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 9:11:32 PM Oct 15, 2015
 */
public class MyStack {
	Queue<Integer> stack = new LinkedList<>();
	int top;
	
    // Push element x onto stack.
    public void push(int x) {
        stack.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int len = stack.size();
        while(len > 2){
        		stack.add(stack.poll());
        		--len;
        }
        top = stack.poll();
        stack.add(top);
        
        stack.poll();
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
