/**
 * File Name: FindnumsayPivot.java
 * Package Name: yz.geeksforgeeks
 * Project Name: LeetCode
 * Purpose: http://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
 * Created Time: 8:03:26 PM Oct 26, 2015
 * Author: Yaolin Zhang
 */
package yz.geeksforgeeks;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:03:26 PM Oct 26, 2015
 */
public class FindArrayPivot {
	public int findPivot(List<Integer> nums) {
		System.out.println(Arrays.toString(nums.toArray()));
		// Find the first pivot that meets the requirements
		boolean foundFirst = true;
		int indexFirst = 0;
		int curMax = nums.get(indexFirst); // Store the max value so far
		for (int i = 1; i < nums.size(); ++i) {
			if (nums.get(i) > curMax) {
				if (!foundFirst) {
					indexFirst = i;
					foundFirst = true;
				}
				curMax = nums.get(i); // Store the max value so far
			} else if (nums.get(i) <= nums.get(indexFirst)) { // Current value is smaller or equal to current pivot
				foundFirst = false; // Then the current pivot will be invalid, need to find again
			}
		}

		// Find the last pivot that meets the requirements
		boolean foundLast = true;
		int indexLast = nums.size() - 1;
		int curMin = nums.get(indexLast);
		for (int i = nums.size() - 2; i >= 0; --i) {
			if (nums.get(i) < curMin) {
				if (!foundLast) {
					indexLast = i;
					foundLast = true;
				}
				curMin = nums.get(i);
			} else if (nums.get(i) >= nums.get(indexLast)) {
				foundLast = false;
			}
		}
		System.out.println(indexFirst + "  " + foundFirst + "  " + indexLast + "  " + foundLast);

		if (foundFirst && foundLast) {
			if (indexFirst == indexLast) {// Only one pivot that meets the requirements
				return indexFirst;
			} else {// indexFirst < indexLast
				if (indexFirst < nums.size() / 2 && indexLast > nums.size() / 2) {
					// 1,2,2,2,4 indexFirst = 0 indexLast = 4 should return 0
					// 1,1,3,4,4,5,5,6 indexFirst = 2 indexLast = 7 return 2
					// Need to examine again
					// Still not work for 1,1,2,3,4,5
					List<Integer> subNums = new ArrayList<>(nums.subList(indexFirst + 1, indexLast));
					int middleIndex = findPivot(subNums);
					if (middleIndex != -1) {
						return middleIndex + indexFirst + 1;
					}
				}
				int a = Math.abs(indexFirst - nums.size() / 2);
				int b = Math.abs(indexLast - nums.size() / 2);
				return a > b ? indexLast : indexFirst;

			}
		} else {
			return -1;
		}
	}
}
