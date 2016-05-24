/**
 * File Name: CompareVersion.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:03:47 PM May 16, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

/**
 * @author Yaolin Zhang
 * @time 11:03:47 PM May 16, 2016
 */
public class CompareVersion {
	public int compareVersion(String version1, String version2) {
		String ver1[] = version1.split("\\.");
		String ver2[] = version2.split("\\.");
		int i = 0;
		int j = 0;
		for (; i < ver1.length && j < ver2.length; ++i, ++j) {
			int cur1 = Integer.parseInt(ver1[i]);
			int cur2 = Integer.parseInt(ver2[i]);
			if (cur1 > cur2) {
				return 1;
			} else if (cur1 < cur2) {
				return -1;
			}
		}
		if (i == ver1.length && j == ver2.length) {
			return 0;
		}
		if (i == ver1.length) {
			while (j < ver2.length && Integer.parseInt(ver2[j]) == 0) {
				++j;
			}
			if (j == ver2.length) {
				return 0;
			}
			return -1;
		} else {
			while (i < ver1.length && Integer.parseInt(ver1[i]) == 0) {
				++i;
			}
			if (i == ver1.length) {
				return 0;
			}
			return 1;
		}
	}
}
