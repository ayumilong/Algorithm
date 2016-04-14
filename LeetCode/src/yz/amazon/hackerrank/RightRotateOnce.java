/**
 * File Name: RightRotateOnce.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:38:28 PM Apr 2, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 1:38:28 PM Apr 2, 2016
 */
public class RightRotateOnce {
	public static void main1(String args[]){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] square = new int[n][n];
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				if(scan.hasNextInt()){
					square[i][j] = scan.nextInt();
				}else{
					System.out.println("ERROR");
					scan.close();
					return;
				}
			}
		}
		//if(scan.hasNextInt()){
		//	System.out.println("ERROR");
		//	scan.close();
		//	return;
		//}
		RightRotateOnce rro = new RightRotateOnce();
		rro.rotate(square, n);
		rro.print(square);
		scan.close();
	}
	
	public void print(int[][] square){
		for(int[] arr : square){
			for(int n : arr){
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	private int copy(int[][] square, int i, int j, int pre){
		int temp = square[i][j];
		square[i][j] = pre;
		return temp;
	}
	
	public void rotate(int[][] square, int n){
		int start = 0;
		while(n > 1){
			int end = start + n;
			int i = start;
			int j = start;
			//Go right
			int pre = square[i][j];
			while(j < end - 1){
				/*
				int temp = square[i][j + 1];
				square[i][j + 1] = pre;
				pre = temp;
				++j;
				*/
				pre = copy(square, i, ++j, pre);
			}
			//Go down
			while(i < end - 1){
				/*
				int temp = square[i + 1][j];
				square[i + 1][j] = pre;
				pre = temp;
				++i;
				*/
				pre = copy(square, ++i, j, pre);
			}
			//Go left
			while(j > start){
				/*
				int temp = square[i][j - 1];
				square[i][j - 1] = pre;
				pre = temp;
				--j;
				*/
				pre = copy(square, i, --j, pre);
			}
			//Go up
			while(i > start){
				/*
				int temp = square[i - 1][j];
				square[i - 1][j] = pre;
				pre = temp;
				--i;
				*/
				pre = copy(square, --i, j, pre);
			}
			n -= 2;
			++start;
		}
	}
}
