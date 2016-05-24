/**
 * File Name: IsBeautiful.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:17:07 PM Apr 5, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.io.*;
import java.util.Random;

/**
 * @author Yaolin Zhang
 * @time 11:17:07 PM Apr 5, 2016
 */
public class IsBeautiful {
	public static void main(String args[]) throws IOException {
		boolean debug = true;
		if (debug) {
			int n = 100;
			System.out.println(n);
			Random r = new Random();
			while (n > 0) {
				--n;
				int len = r.nextInt(50);
				while(len < 3){
					len = r.nextInt(10);
				}
				System.out.println(len);
				String s = "";
				while (len > 0) {
					--len;
					s += (char) (r.nextInt(10) + 'a');
				}
				System.out.println(s);
			}
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(reader.readLine());
		while (cases > 0) {
			--cases;
			int len = Integer.parseInt(reader.readLine());
			String str = reader.readLine();
			//int len = str.length();
			//System.out.println(len);
			if (isBeautiful1(str, len)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
		reader.close();
	}

	public static boolean isBeautiful(String s, int len) {
		if (len == 0 || s == null) {
			return false;
		}
		int[] count = new int[26];
		int pre = s.charAt(0) - 'a';
		count[pre] = 1;
		for (int i = 1; i < len; i++) {
			int cur = s.charAt(i) - 'a';
			if (cur == pre) {
				count[pre]++;
			}
			if (pre >= 2 && count[pre - 1] <= count[pre] && count[pre - 1] <= count[pre - 2]) {
				System.out.println(pre);
				return true;
			} else {
				if (cur != pre + 1) {
					for (int j = 0; j < 26; j++) {
						count[j] = 0;
					}

				}
				count[cur]++;
				pre = cur;
			}
		}
		if (pre >= 2 && count[pre - 1] <= count[pre] && count[pre - 1] <= count[pre - 2]) {
			return true;
		}
		return false;
	}

	public static boolean isBeautiful1(String s, int len) {
		if (len < 3) {
			return false;
		}
		int[] count = new int[len];
		count[0] = 1;
		char pre = s.charAt(0);
		for (int i = 1; i < len; ++i) {
			char cur = s.charAt(i);
			if (cur == pre) {
				count[i] = count[i - 1] + 1;
			} else {
				count[i] = 1;
				pre = cur;
			}
		}
		int first = len - 1;
		int second = first - count[first];
		if(second < 0){
			return false;
		}
		int third = second - count[second];
		while (third >= 0) {
			if (s.charAt(first) == s.charAt(second) + 1 && s.charAt(second) == s.charAt(third) + 1) {
				if (count[first] >= count[second] && count[third] >= count[second]) {
					return true;
				}
			}
			// Move backward
			first = second;
			second = third;
			third = third - count[third];
		}
		return false;
	}
}
