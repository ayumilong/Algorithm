/**
 * File Name: Dijkstra.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose: Google Code Jam 2015 Qualification Round: C
 * Created Time: 3:25:20 PM Apr 8, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 3:25:20 PM Apr 8, 2016
 */
public class Dijkstra {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; ++t) {
			long L = scan.nextLong();
			long X = scan.nextLong();
			String s = scan.next();

			String one = "1";
			for (int i = 0; i < L; ++i) {
				String cur = s.charAt(i) + "";
				one = multi(one, cur);
			}
			String all = "1";
			for (int i = 0; i < X % 4; ++i) {
				all = multi(all, one);
			}
			if (!all.equals("-1")) {
				System.out.printf("Case #%d: NO\n", t);
				continue;
			}

			long left = -1;
			long right = -1;
			one = "1";
			for (int i = 0; i < L * X && i < 4 * L; ++i) {
				String cur = s.charAt((int) (i % L)) + "";
				one = multi(one, cur);
				if (one.equals("i")) {
					left = i + 1;
					break;
				}
			}
			if (left == -1) {
				System.out.printf("Case #%d: NO\n", t);
				continue;
			}
			one = "1";
			for (int i = 0; i < L * X && i < 4 * L; ++i) {
				String cur = s.charAt((int) (L - 1 - i % L)) + "";
				one = multi(cur, one);
				if (one.equals("k")) {
					right = i + 1;
					break;
				}
			}
			boolean success = true;
			if (right == -1 || left + right >= L * X) {
				success = false;
			}
			System.out.printf("Case #%d: %s\n", t, success ? "YES" : "NO");
		}

		scan.close();
	}

	private static String multi(String s1, String s2) {
		boolean negative = false;
		if (s1.charAt(0) == '-') {
			s1 = s1.substring(1);
			negative ^= true;
		}
		if (s2.charAt(0) == '-') {
			s2 = s2.substring(1);
			negative ^= true;
		}
		String ans = "";
		if (s1.equals("1")) {
			ans = s2;
		} else if (s2.equals("1")) {
			ans = s1;
		} else if (s1.equals(s2)) {
			ans = "-1";
		} else if (s1.equals("i")) {
			ans = s2.equals("j") ? "k" : "-j";
		} else if (s1.equals("j")) {
			ans = s2.equals("i") ? "-k" : "i";
		} else if (s1.equals("k")) {
			ans = s2.equals("i") ? "j" : "-i";
		}
		if (ans.charAt(0) == '-') {
			negative ^= true;
			ans = ans.substring(1);
		}
		if (negative) {
			ans = '-' + ans;
		}
		return ans;
	}
}
