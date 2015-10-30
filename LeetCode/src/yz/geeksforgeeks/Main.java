/**
 * File Name: Main.java
 * Package Name: yz.geeksforgeeks
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:02:48 PM Oct 26, 2015
 * Author: Yaolin Zhang
 */
package yz.geeksforgeeks;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:02:48 PM Oct 26, 2015
 */
public class Main {
	public static void main(String args[]) {
		System.out.println("Please input something: ");
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int count = sc.nextInt();
		for (int j = 0; j < count; ++j) {
			ArrayList<Integer> nums = new ArrayList<>();
			for (int i = 0; i < len; ++i) {
				nums.add(sc.nextInt());
			}

			FindArrayPivot fap = new FindArrayPivot();
			int pivot = fap.findPivot(nums);
			System.out.println(pivot + (pivot == -1 ? "" : "--" + nums.get(pivot)));
			
		}
		sc.close();
	}
}
