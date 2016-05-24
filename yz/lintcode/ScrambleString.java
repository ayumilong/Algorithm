/**
 * File Name: ScrambleString.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 12:05:11 AM Mar 31, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 12:05:11 AM Mar 31, 2016
 */
public class ScrambleString {
	int[][][] visit;

	public boolean isScramble(String s1, String s2) {
		// Write your code here
		// ayumi_Long
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1 == null || s2 == null) {
			return false;
		}
		int len = s1.length();
		if (len != s2.length()) {
			return false;
		}
		visit = new int[len][len][len + 1]; // visit[i][j][k] means s1 starts
											// from i, s2 starts from j and both
											// of them have len of k
		return helper(s1.toCharArray(), s2.toCharArray(), 0, len - 1, 0, len - 1, len);
	}

	private boolean helper(char[] s1, char[] s2, int start1, int end1, int start2, int end2, int k) {
		if (visit[start1][start2][k] == 1) {
			return true;
		}
		if (visit[start1][start2][k] == -1) {
			return false;
		}
		if (start1 == end1) {
			if (s1[start1] == s2[start2]) {
				return true;
			} else {
				return false;
			}
		}
		for (int i = 0; i < end1 - start1; ++i) {
			if ((helper(s1, s2, start1, i + start1, start2, i + start2, i + 1)
					&& helper(s1, s2, i + start1 + 1, end1, i + start2 + 1, end2, k - i - 1))
					|| (helper(s1, s2, start1, i + start1, end2 - i, end2, i + 1)
							&& helper(s1, s2, i + start1 + 1, end1, start2, end2 - i - 1, k - i - 1))) {
				visit[start1][start2][k] = 1;
				return true;
			}
		}
		visit[start1][start2][k] = -1;
		return false;
	}
}
