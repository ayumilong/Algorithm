/**
 * File Name: CompareVersionNumbers.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:27:03 PM Aug 26, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 10:27:03 PM Aug 26, 2015
 */
public class CompareVersionNumbers {
	public int compareVersion1(String version1, String version2) {
		int i = 0;
		int j = 0;
		int lenA = version1.length();
		int lenB = version2.length();
		boolean allZero1 = true;
		boolean allZero2 = true;
		for (; i < lenA && j < lenB; ++i, ++j) {
			if(version1.charAt(i) == '.'){
				allZero1 = true;
			}
			if(version2.charAt(j) == '.'){
				allZero2 = true;
			}
			if(version1.charAt(i) >= '1' && version1.charAt(i) <= '9'){
				allZero1 = false;
			}
			if(version2.charAt(j) >= '1' && version2.charAt(j) <= '9'){
				allZero2 = false;
			}
			while(allZero1 && i < lenA && version1.charAt(i) == '0'){//Skip leading 0 such as 0001.1 and 1.1
				++i;
			}
			if(i == lenA){
				break;
			}
			while(allZero2 && j < lenB && version2.charAt(j) == '0'){//Skip leading 0 such as 1.1 and 0001.1
				++j;
			}
			if(j == lenB){
				break;
			}
			if (version1.charAt(i) == '.' && version2.charAt(j) != '.') {
				while (allZero2 && j < lenB && version2.charAt(j) == '0') {
					++j;
				}
				if(j == lenB){
					break;
				}
				if (version2.charAt(j) != '.') {
					return -1;
				}
			}
			if (version1.charAt(i) != '.' && version2.charAt(j) == '.') {
				while (allZero1 && i < lenA && version1.charAt(i) != '.') {
					++i;
				}
				if(i == lenA){
					break;
				}
				if (version1.charAt(i) != '.') {
					return 1;
				}
			}
			
			if (version1.charAt(i) > version2.charAt(j)) {
				return 1;
			}
			if (version1.charAt(i) < version2.charAt(j)) {
				return -1;
			}
		}

		if (i == lenA && j == lenB) {
			return 0;
		}

		if (i == lenA) {
			while (allZero2 && j < lenB && (version2.charAt(j) == '0' || version2.charAt(j) == '.')) {
				++j;
			}
			if(j == lenB){
				return 0;
			}
			return -1;
		}

		if (j == lenB) {
			while (allZero1 && i < lenA && (version1.charAt(i) == '0' || version1.charAt(i) == '.')) {
				++i;
			}
			if(i == lenB){
				return 0;
			}
			return 1;
		}
		return 0;
	}

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
