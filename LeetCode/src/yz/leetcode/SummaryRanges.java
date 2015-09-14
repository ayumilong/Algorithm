/**
 * File Name: SummaryRanges.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:55:20 AM Sep 7, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:55:20 AM Sep 7, 2015
 */
public class SummaryRanges {
	public List<String> summaryRanges1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<String> list = new ArrayList<>();
		int startPos = 0;
		for (int i = 1; i <= nums.length; ++i) {
			if (i == nums.length || nums[i] != nums[i - 1] + 1) {
				if (startPos == i - 1) {
					list.add(nums[startPos] + "");
				} else {
					list.add(nums[startPos] + "->" + nums[i - 1]);
				}
				startPos = i;
			}
		}
		return list;
	}

	public List<String> summaryRanges(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<String> list = new ArrayList<>();
		int start = nums[0];
		int end = start;

		for (int i = 1; i < nums.length; ++i) {
			while (i < nums.length && nums[i] == end + 1) {
				++i;
				++end;
			}
			if (start != end) {
				list.add(start + "->" + end);
			} else {
				list.add(start + "");
			}
			if (i != nums.length) { // A new range
				start = nums[i];
				end = start;
			}
		}
		if (start == end) { // The case of length = 1 and the last range only
							// has 1 element
			list.add(start + "");
		}
		return list;
	}
}
