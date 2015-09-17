/**
 * File Name: Main.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose: Start point of the application
 * Created Time: 9:53:36 PM Aug 18, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;


/**
 * @author Yaolin Zhang
 * @time 9:53:36 PM Aug 18, 2015
 */



public class Main {
	public static void main(String args[]){
		System.out.println("Please input something: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		BasicCalculatorII bc = new BasicCalculatorII();
		System.out.println(bc.calculate(s));
		
		sc.close();
	}
}
