/**
 * File Name: AddBinary.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:56:40 PM Aug 22, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 1:56:40 PM Aug 22, 2015
 */
public class AddBinary {
	public String addBinary0(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		String result = "";
		int carry = 0;
		int len;
		if (lengthA > lengthB) {
			for (int j = 0; j < lengthA - lengthB; j++) {
				b = "0" + b;
			}
			len = lengthA;
		} else {
			for (int j = 0; j < lengthB - lengthA; j++) {
				a = "0" + a;
			}
			len = lengthB;
		}
		for (int i = len - 1; i >= 0; i--) {
			int l = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
			carry = l / 2;
			result = l % 2 + result;
		}
		if (carry == 1) {
			result = 1 + result;
		}
		return result;
	}

	public String addBinary1(String a, String b) {
		if (a == "" && b == "")
			return "";
		StringBuffer result = new StringBuffer();
		int lenA = a.length();
		int lenB = b.length();
		int A = 0, B = 0;
		for (int i = 0; i < lenA; ++i) {
			A = (A * 2 + a.charAt(i) - '0');
		}
		for (int i = 0; i < lenB; ++i) {
			B = (B * 2 + b.charAt(i) - '0');
		}
		int C = A + B;
		if (C == 0) {
			return "0";
		}
		while (C != 0) {
			result.insert(0, C % 2);
			C = C / 2;
		}

		return result.toString();
	}

	public String addBinary(String a, String b) {
		String sb = "";
		int lenA = a.length();
		int lenB = b.length();
		int c = 0;
		int i, j;
		for (i = lenA - 1, j = lenB - 1; i >= 0 && j >= 0; --i, --j) {
			int temp = a.charAt(i) + b.charAt(j) + c - '0' - '0';
			c = temp / 2;
			sb = temp % 2 + sb;
		}
		for (; i >= 0; --i) {
			int temp = a.charAt(i) + c - '0';
			c = temp / 2;
			sb = temp % 2 + sb;
		}
		for (; j >= 0; --j) {
			int temp = b.charAt(j) + c - '0';
			c = temp / 2;
			sb = temp % 2 + sb;
		}
		if (c == 1) {
			sb = 1 + sb;
		}
		return sb;
	}
}
