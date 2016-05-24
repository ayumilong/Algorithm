/**
 * File Name: Template.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose: Template for input
 * Created Time: 12:05:41 AM Apr 10, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 12:05:41 AM Apr 10, 2016
 */
public class Template {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			
			
			System.out.printf("Case #%d: \n", t);
		}
		scan.close();
	}
}
