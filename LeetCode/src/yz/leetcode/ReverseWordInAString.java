/**
 * File Name: ReverseWordInAString.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:28:16 PM Aug 21, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 10:28:16 PM Aug 21, 2015
 */
public class ReverseWordInAString {
	public String reverseWords0(String s){
		StringBuffer sb = new StringBuffer();
		for(int i = s.length() - 1; i >= 0; --i){
			while(i >= 0 && s.charAt(i) == ' '){
				--i;
			}
			if(i == -1) break;
			int last = i;
			while(i >= 0 && s.charAt(i) != ' '){
				--i;
			}
			sb.append(s.substring(i + 1, last + 1) + " ");
		}
		if(sb.length() == 0){
			return "";
		}
		return sb.substring(0, sb.length() - 1);
	}

	public String reverseWords1(String s) {
		String sx = new String();
		if (s == null)
			return null;

		char c[] = s.trim().toCharArray();

		for (int i = 0; i < c.length;) {
			StringBuffer sb = new StringBuffer();
			while (i < c.length && c[i] != ' ') {
				sb.append(c[i]);
				i++;
			}
			while (i < c.length && c[i] == ' ') {
				i++;
			}
			sx = " " + sb.toString() + sx;
		}

		return sx.trim();
	}

	public String reverseWords2(String s) {
		StringBuffer sb = new StringBuffer(s.trim());
		StringBuffer result = new StringBuffer("");
		int spaceIndex = sb.indexOf(" ");

		while (spaceIndex != -1) {
			result.insert(0, sb.substring(0, spaceIndex + 1));
			sb.delete(0, spaceIndex + 1);

			String temp = sb.toString();
			sb.delete(0, sb.length());
			sb.append(temp.trim());

			spaceIndex = sb.indexOf(" ");
		}

		result.insert(0, sb.toString() + " ");

		return result.substring(0, result.length());
	}

	public String reverseWords3(String s) {
		String array[] = s.trim().split(" ");
		if (array.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = array.length - 1; i > 0; --i) {
			if (array[i].equals("") == false) {
				sb.append(array[i] + " ");
			}
		}
		sb.append(array[0]);
		return sb.toString();
	}

	public String reverseWords(String s) {
		StringBuffer sb = new StringBuffer(s.trim());
		int len;
		for (int i = 0; i < sb.length() / 2; ++i) {
			if (sb.charAt(i) == ' ') {
				int j = i + 1;
				while (sb.charAt(j) == ' ') {
					++j;
				}
				if (i + 1 != j) {
					sb.delete(i + 1, j);
				}
			}

			if (sb.charAt(sb.length() - i - 1) == ' ') {
				int j = sb.length() - i - 2;
				while (sb.charAt(j) == ' ') {
					--j;
				}
				if (j + 1 != sb.length() - i - 1) {
					sb.delete(j + 1, sb.length() - i - 1);
				}
			}

			char c = sb.charAt(i);
			len = sb.length();
			sb.setCharAt(i, sb.charAt(len - i - 1));
			sb.setCharAt(len - i - 1, c);
		}

		len = sb.length();

		int spaceIndex = sb.indexOf(" ");
		int i = 0;
		int preSpaceIndex = 0;
		while (true) {
			int end = (spaceIndex - i) / 2 + i;
			for (; i < end; ++i) {
				char c = sb.charAt(i);
				sb.setCharAt(i, sb.charAt(spaceIndex - i - 1 + preSpaceIndex));
				sb.setCharAt(spaceIndex - i - 1 + preSpaceIndex, c);
			}
			if (spaceIndex == len) {
				break;
			}
			i = spaceIndex + 1;
			preSpaceIndex = i;
			spaceIndex = sb.indexOf(" ", spaceIndex + 1);
			if (spaceIndex == -1) {
				spaceIndex = len;
			}
		}

		return sb.toString();
	}
}
