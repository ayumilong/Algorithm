/**
 * File Name: MinStack.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:35:34 PM Oct 15, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

public class MinStack {
	Stack<Long> stack = new Stack<>();
	long min;

	public void push(int x) {
		if (stack.empty()) {
			stack.push(0L);
			min = x;
		} else {
			stack.push(Long.valueOf(x - min));
			if (stack.peek() < 0L) {
				min = (long) x;
			}
		}
	}

	public void pop() {
		long cur = stack.pop();
		if (cur < 0L) {
			min = min - cur;
		}
	}

	public int top() {
		if (stack.peek() < 0L) {
			return (int) min;
		} else {
			return (int) (stack.peek() + min);
		}
	}

	public int getMin() {
		return (int) min;
	}
}

/**
 * @author Yaolin Zhang
 * @time 6:35:34 PM Oct 15, 2015
 */
/*
 * public class MinStack { LinkedList<Integer> minimums = new LinkedList<>();
 * Stack<Integer> s = new Stack<>();
 * 
 * public void push(int x) { s.push(x); if (minimums.isEmpty() || x <=
 * minimums.peek()) { minimums.addFirst(x); } }
 * 
 * public void pop() { if (!s.empty()) { if (s.pop().intValue() ==
 * minimums.peek()) { minimums.removeFirst(); } } }
 * 
 * public int top() { if (!s.empty()) { return s.peek(); } else { return
 * Integer.MIN_VALUE; } }
 * 
 * public int getMin() { if (!minimums.isEmpty()) { return minimums.peek(); }
 * else { return Integer.MAX_VALUE; } } }
 */
