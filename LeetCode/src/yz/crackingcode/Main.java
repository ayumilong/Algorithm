/**
 * File Name: Main.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:19:08 PM Aug 30, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 1:19:08 PM Aug 30, 2015
 */
public class Main {
	public static void main(String args[]){
		System.out.println("Please input something: ");
		Scanner sc = new Scanner(System.in);
		
		int length1 = sc.nextInt();
		SingleLinkedList num1 = new SingleLinkedList(sc.nextInt());
		SingleLinkedList cur = num1;
		while(length1 > 1){
			cur.setNext(new SingleLinkedList(sc.nextInt()));
			cur = cur.getNext();
			--length1;
		}
		
		int length2 = sc.nextInt();
		SingleLinkedList num2 = new SingleLinkedList(sc.nextInt());
		cur = num2;
		while(length2 > 1){
			cur.setNext(new SingleLinkedList(sc.nextInt()));
			cur = cur.getNext();
			--length2;
		}
		
		Chapter2 c2 = new Chapter2();
		c2.addNormalLists(num1, num2);
		
		sc.close();
	}
}
