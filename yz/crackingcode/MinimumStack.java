/**
 * File Name: MinimumStack.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:50:23 PM Oct 5, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

/**
 * @author Yaolin Zhang
 * @time 9:50:23 PM Oct 5, 2015
 */
public class MinimumStack {
	private int buffer[];
	private int top;
	private boolean isEmpty;
	private boolean isFull;
	private SingleLinkedList minList;
	
	public MinimumStack(int size){
		buffer = new int[size];
		top = 0;
		isEmpty = true;
		isFull = false;
		minList = new SingleLinkedList();
	}
	
	public Integer minimum(){
		if(!isEmpty){
			return minList.getData();
		}
		return null;
	}
	
	public Integer pop(){
		if(!isEmpty){
			--top;
			if(buffer[top] == minList.getData()){
				minList = minList.getNext();
			}
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
			if(isEmpty){
				minList.setData(val);
			}else if(val <= minList.getData()){
				SingleLinkedList temp = new SingleLinkedList(val);
				temp.setNext(minList);
				minList = temp;
			}
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
