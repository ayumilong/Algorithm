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

import yz.leetcode.tools.BitInteger;

/**
 * @author Yaolin Zhang
 * @time 1:19:08 PM Aug 30, 2015
 */
public class Main {
	public static ArrayList<BitInteger> initialize(int n, int missing) {
		BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();
		ArrayList<BitInteger> array = new ArrayList<BitInteger>();

		for (int i = 1; i <= n; i++) {
			array.add(new BitInteger(i == missing ? 0 : i));
		}

		// Shuffle the array once.
		for (int i = 0; i < n; i++) {
			int rand = i + (int) (Math.random() * (n - i));
			array.get(i).swapValues(array.get(rand));
		}

		return array;
	}

	public static int findOnePairs(int num) {
		int mask = 3;
		int result = 0;
		for (int i = 0; i < 31; ++i) {
			if ((num & (mask << i)) == (mask << i)) {
				++result;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int a = 3;
		int b = 5;
		System.out.println((a ^ b) ^ ~0);
		System.out.println("Please input something: ");
		Scanner sc = new Scanner(System.in);
		Chapter5 c5 = new Chapter5();
		while (sc.hasNext()) {
			System.out.println(findOnePairs(sc.nextInt()));
		}

		sc.close();
	}
}
