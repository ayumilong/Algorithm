/**
 * File Name: SimplifyPath.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:21:26 PM Oct 15, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:21:26 PM Oct 15, 2015
 */
public class SimplifyPath {
	public String simplifyPath(String path) {

		Deque<String> queue = new LinkedList<>();
		int length = path.length();
		for (int i = 0; i < length; i++) {
			char cur = path.charAt(i);
			if (cur == '.') {
				String file = new String();
				while (i < length && path.charAt(i) != '/') {
					file += path.charAt(i);
					i++;
				}
				if (file.equals("..") && (!queue.isEmpty())) {
					queue.removeLast();
				} else if (file.length() > 2) {
					queue.addLast(file);
				}
			} else if (cur != '/') {
				System.out.println("Cur: " + cur);
				String file = new String();
				while (i < length && path.charAt(i) != '/') {
					file += path.charAt(i);
					i++;
				}
				queue.addLast(file);
			}
		}
		String simplify = new String();
		if (queue.isEmpty()) {
			return "/";
		} else {
			while(!queue.isEmpty()){
				simplify += "/";
				simplify += queue.pollFirst();
			}
		}
		return simplify;
	}

	public String simplifyPath2(String path) {
		int len = path.length();
		Deque<String> dirs = new LinkedList<>();
		for (int i = 0; i < len; ++i) {
			switch (path.charAt(i)) {
			case '.':
				int startDot = i;
				while (i < len && path.charAt(i) != '/') {
					++i;
				}
				if(i - startDot != 1){
					if(path.charAt(startDot) == '.' && i - startDot == 2){
						if(!dirs.isEmpty()){
							dirs.removeLast();
						}
					}else{
						dirs.addLast(path.substring(startDot, i--));
					}
				}
				break;
			case '/':
				break;
			default:
				int startChar = i;
				while (i < len && path.charAt(i) != '/') {
					++i;
				}
				dirs.addLast(path.substring(startChar, i--));
				break;
			}
		}

		String result = "";
		while (!dirs.isEmpty()) {
			result += "/" + dirs.removeFirst();
		}
		return result == "" ? "/" : result;
	}
}
