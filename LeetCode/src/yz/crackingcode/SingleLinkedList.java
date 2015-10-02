/**
 * File Name: SingleLinkedList.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:40:31 PM Sep 19, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

/**
 * @author Yaolin Zhang
 * @time 1:40:31 PM Sep 19, 2015
 */
public class SingleLinkedList {
	private int data;
	private SingleLinkedList next = null;
	
	public SingleLinkedList(int data){
		this.data = data;
	}
	
	public SingleLinkedList getNext(){
		return this.next;
	}
	
	public void setNext(SingleLinkedList next){
		this.next = next;
	}
	
	public boolean hasNext(){
		return this.next != null;
	}
	
	public int getData(){
		return data;
	}
	
	public void setData(int data){
		this.data = data;
	}
}
