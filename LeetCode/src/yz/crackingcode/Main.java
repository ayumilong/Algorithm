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
		Chapter1 c11 = new Chapter1();
		int N;
		N = sc.nextInt();
		int[][] image = new int[N][N];
		for(int i = 0; i < N; ++i){
			for(int j = 0; j < N; ++j){
				image[i][j] = sc.nextInt();
			}
		}
		c11.rotate(image, N);
		for(int i = 0; i < N; ++i){
			System.out.println(c11.compress(sc.nextLine()));
		}
		sc.close();
	}
}
