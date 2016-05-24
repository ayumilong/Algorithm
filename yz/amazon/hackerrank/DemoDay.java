/**
 * File Name: DemoDay.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:40:09 AM Apr 6, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:40:09 AM Apr 6, 2016
 */
public class DemoDay {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int cols = scan.nextInt();
		char[][] maze = new char[rows][];
		scan.nextLine();
		for(int i = 0; i < rows; ++i){
			maze[i] = scan.nextLine().toCharArray();
		}
		//-1 is go down, 1 is go right
		System.out.println(changeCount(maze, rows, cols, 0, 0, 0, 1));
		scan.close();
	}
	
	public static int changeCount(char[][] maze, int rows, int cols, int start, int end, int count, int direction){
		if(start == rows - 1 && end == cols - 1){
			return count;
		}
		
		
		return count;
	}
}
