/**
 * File Name: Main.java
 * Package Name: yz.leetcode.google
 * Project Name: Algorithm
 * Purpose: Some simple functions
 * Created Time: 1:22:33 AM May 14, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.google;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 1:22:33 AM May 14, 2016
 */
public class Main {
	public static void main(String args[]) {
		System.out.println(1.2 % 1);
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int num = Integer.parseInt(scan.nextLine(), 16);
			System.out.println(num);
			System.out.println(isPalindrome(num));
		}

		scan.close();
	}
	
	public static boolean isPalindrome(int x){
		for(int i = 0; i < 16; ++i){
			if((1 & (x >> i)) != (1 & (x >> 32 - i - 1))){
				return false;
			}
		}
		return true;
	}


	public static int countBits(int x) {
		int count = 0;
		while (x != 0) {
			++count;
			x &= (x - 1);
		}
		return count;
	}

	public static String reverse(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		char[] sc = str.toCharArray();
		int low = 0;
		int high = sc.length - 1;
		while (low < high) {
			char c = sc[low];
			sc[low++] = sc[high];
			sc[high--] = c;
		}
		return String.valueOf(sc);
	}

	public static String formatRGB(int r, int g, int b) {
		System.out.printf("%02X%02X%02X\n", r, g, b);
		return toHex(r) + toHex(g) + toHex(b);
	}

	private static String toHexAPI(int n) {
		String s = Integer.toHexString(n);
		return (s.length() == 1) ? '0' + s : s;
	}

	private static String toHex(int n) {
		int left = n >> 4;
		left = left >= 10 ? 'A' + (left - 10) : left;
		int right = n & 15;
		right = right >= 10 ? 'A' + (right - 10) : right;
		return (char) left + "" + (char) right;
	}

	public static int fib(int n) {
		int[] pre = { 0, 1 };
		for (int i = 2; i <= n; ++i) {
			pre[i % 2] = pre[i % 2] + pre[(i + 1) % 2];
		}
		return pre[n % 2];
	}

	public static void printOdds(int n) {
		for (int i = 1; i <= n; i += 2) {
			System.out.println(i);
		}
	}

	/*
	 * Sums up integers from a text file, one integer per line
	 */
	public static void sumFile(String name) {
		try {
			int total = 0;
			BufferedReader in = new BufferedReader(new FileReader(name));
			for (String s = in.readLine(); s != null; s = in.readLine()) {
				total += Integer.parseInt(s);
			}
			System.out.println(total);
			in.close();
		} catch (Exception xc) {
			xc.printStackTrace();
		}
	}
}
