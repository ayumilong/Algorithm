/**
 * File Name: ProblemB.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 1:08:33 AM May 15, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 1:08:33 AM May 15, 2016
 */
public class ProblemB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> counts = new ArrayList<String>();
		counts.add("1");
		counts.add("2");
		while (scan.hasNext()) {
			int n = scan.nextInt();
			if (counts.size() < n) {
				for (int i = counts.size(); i < n; ++i) {
					counts.add(addStr(counts.get(i - 2), counts.get(i - 1)));
				}
			}
			System.out.println(counts.get(n - 1));
		}

		scan.close();
	}

	public static String addStr(String s1, String s2) {
		String result = "";
		int carry = 0;
		int index1 = s1.length() - 1;
		int index2 = s2.length() - 1;
		while (index1 >= 0 || index2 >= 0 || carry > 0) {
			int cur = 0;
			if (index1 >= 0) {
				cur = s1.charAt(index1) - '0';
				--index1;
			}
			if (index2 >= 0) {
				cur += s2.charAt(index2) - '0';
				--index2;
			}
			cur += carry;
			carry = cur / 10;
			result = (cur % 10) + result;
		}
		return result;
	}
}
