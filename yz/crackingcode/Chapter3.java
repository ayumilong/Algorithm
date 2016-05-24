/**
 * File Name: Chapter3.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:30:05 PM Oct 5, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

/**
 * @author Yaolin Zhang
 * @time 9:30:05 PM Oct 5, 2015
 */
public class Chapter3 {
	/*
	 * Question #2
	 * MinimumStack.java
	 */
	
	/*
	 * Question #3
	 * SetOfStacks.java
	 */
	
	/*
	 * Question #4
	 */
	public static void printStack(MyStack s){
		MyStack temp = new MyStack(s.size());
		int size = s.size();
		for(int i = 0; i < size; ++i){
			temp.push(s.pop());
		}
		for(int i = 0; i < size; ++i){
			System.out.print(temp.peek() + " ");
			s.push(temp.pop());
		}
		System.out.println();
	}
	
	
	
	/*
	 * Recursive
	 */
	public static void playHanoi1(int n, MyStack s1, MyStack s2, MyStack s3){
		if(n > 0){
			playHanoi1(n - 1, s1, s3, s2);
			s3.push(s1.pop());
			playHanoi1(n - 1, s2, s1, s3);
		}
	}
	/*
	 * Iterative
	 */
	public static void playHanoi(int n, MyStack s1, MyStack s2, MyStack s3){
		while(!s1.isEmpty()){
			
		}
	}

}
