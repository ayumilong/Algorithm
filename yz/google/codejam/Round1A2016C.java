/**
 * File Name: Round1A2016C.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:47:52 PM Apr 15, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:47:52 PM Apr 15, 2016
 */
public class Round1A2016C {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = scan.nextInt();
			scan.nextLine();
			String[] str = scan.nextLine().split(" ");
			int[] friends = new int[str.length + 1];
			for (int i = 0; i < N; ++i) {
				friends[i + 1] = Integer.parseInt(str[i]);
			}
			int max = findCircle(friends);
			System.out.printf("Case #%d: %d\n", t, max);
		}
		scan.close();
	}

	private static int findCircle(int[] friends) {
		HashMap<Integer, Integer> twoMap = new HashMap<>();
		for (int i = 1; i < friends.length; ++i) {
			if (i == friends[friends[i]] && !twoMap.containsKey(friends[i])) {
				twoMap.put(i, 2);
			}
		}
		int singleMax = 0;
		for (int i = 1; i < friends.length; ++i) {
			HashSet<Integer> list = new HashSet<>();
			list.add(i);
			int pre = i;
			int next = friends[i];
			while (!list.contains(next)) {
				list.add(next);
				pre = next;
				next = friends[next];
			}
			int cur = list.size();
			if (friends[next] == pre && next != i) {// Contains a two circle
				int hasOther = 0;
				boolean[] inList = new boolean[2];
				for (Integer n : list) {
					if (friends[n] == pre && n != next) {
						inList[0] = true;
					}
					if (friends[n] == next && n != pre) {
						inList[1] = true;
					}
				}
				int target = pre;
				if (inList[0]) {
					target = next;
				}
				for (int j = 1; j < friends.length; ++j) {
					if (list.contains(j)) {
						continue;
					}
					int count = 1;
					int start = j;
					boolean invalid = false;
					HashSet<Integer> set = new HashSet<>();
					set.add(start);
					while (friends[start] != target) {
						start = friends[start];
						if (list.contains(start)) {
							invalid = true;
							break;
						}
						if (set.contains(start)) {
							invalid = true;
							break;
						}
						set.add(start);
						++count;
					}
					if (!invalid) {
						hasOther = hasOther > count ? hasOther : count;
					}
				}
				cur += hasOther;
				if (twoMap.containsKey(pre)) {
					if (cur > twoMap.get(pre)) {
						twoMap.put(pre, cur);
					}
				} else if (twoMap.containsKey(next)) {
					if (cur > twoMap.get(next)) {
						twoMap.put(next, cur);
					}
				}
			} else if (next == i) {// Complete circle
				singleMax = singleMax > cur ? singleMax : cur;
			}
		}
		int max = 0;
		for (Integer i : twoMap.values()) {
			max += i;
		}
		return max > singleMax ? max : singleMax;
	}
}
