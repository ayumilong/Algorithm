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
		String strs[] = new String[sc.nextInt()];
		strs[0] = sc.next();
		for(int i = 1; i < strs.length; ++i){
			strs[i] = sc.nextLine();
		}
		GroupAnagrams ga = new GroupAnagrams();
		List<List<String>> ls = ga.groupAnagrams(strs);
		System.out.println(Arrays.toString(ls.toArray()));
		
		sc.close();
	}
}
