/**
 * File Name: MinStack.java
 * Package Name: yz.amazon.onsite.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:38:52 AM Apr 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:38:52 AM Apr 14, 2016
 */
public class MinStack {
    Stack<Integer> minStack = new Stack<>();
    int min = 0;
    public void push(int x) {
        if(minStack.isEmpty()){
            min = x;
            minStack.push(0);
        }else{
            minStack.push(x - min);
            min = min < x ? min : x;
        }
    }

    public void pop() {
        if(!minStack.isEmpty()){
            int top = minStack.pop();
            min = (top < 0) ? min - top : min;
        }
    }

    public int top() {
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return minStack.peek() < 0 ? min : minStack.peek() + min;
    }

    public int getMin() {
        return min;
    }
}
