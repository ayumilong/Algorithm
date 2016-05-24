/**
 * File Name: Stack.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:39:50 PM Oct 4, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

/**
 * @author Yaolin Zhang
 * @time 8:39:50 PM Oct 4, 2015
 */
public class MyStack {
	private int buffer[];
	private int top;
	private boolean isEmpty;
	private boolean isFull;
	
	public MyStack(int size){
		buffer = new int[size];
		top = 0;
		isEmpty = true;
		isFull = false;
	}
	
	public int size(){
		return top;
	}
	
	public boolean isEmpty(){
		return this.isEmpty;
	}
	
	public boolean isFull(){
		return this.isFull;
	}
	
	public Integer pop(){
		if(!isEmpty){
			--top;
			if(top == 0){
				isEmpty = true;
			}
			isFull = false;
			return buffer[top];
		}
		return null;
	}
	
	public boolean push(int val){
		if(!isFull){
			buffer[top++] = val;
			if(top == buffer.length){
				isFull = true;
			}
			isEmpty = false;
			return true;
		}
		return false;
	}
	
	public Integer peek(){
		if(!isEmpty){
			return buffer[top - 1];
		}
		return null;
	}
}
