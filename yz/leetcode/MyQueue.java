/**
 * File Name: MyQueue.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:29:22 PM Oct 15, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

class MyQueue {
	Stack<Integer> pushStack = new Stack<>();
	Stack<Integer> popStack = new Stack<>();

	// Push element x to the back of queue.
	public void push(int x) {
		pushStack.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!popStack.empty()) {
			popStack.pop();
		} else {
			while (!pushStack.empty()) {
				popStack.push(pushStack.pop());
			}
			popStack.pop();
		}
	}

	// Get the front element.
	public int peek() {
		if (!popStack.empty()) {
			return popStack.peek();
		} else {
			while (!pushStack.empty()) {
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

/**
 * @author Yaolin Zhang
 * @time 9:29:22 PM Oct 15, 2015
 */
/*
 * class MyQueue { Stack<Integer> s = new Stack<>(); // Push element x to the
 * back of queue. public void push(int x) { Stack<Integer> temp = new Stack<>();
 * while(!s.empty()){ temp.push(s.pop()); } s.push(x); while(!temp.empty()){
 * s.push(temp.pop()); } }
 * 
 * // Removes the element from in front of queue. public void pop() { s.pop(); }
 * 
 * // Get the front element. public int peek() { return s.peek(); }
 * 
 * // Return whether the queue is empty. public boolean empty() { return
 * s.empty(); } }
 */