/**
 * File Name: SortColors.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:21:43 PM Sep 28, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 8:21:43 PM Sep 28, 2015
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int len = nums.length;
		int red = -1;
		int blue = len ;
		for(int i = 0; i < blue; ++i){
			if(nums[i] == 0){
				nums[i] = nums[++red];
				nums[red] = 0;
			}else if(nums[i] == 2){
				nums[i] = nums[--blue]; //nums[blue] is a new element, need to judge again
				--i;
				nums[blue] = 2;
			}
		}
	}

	/*
	 * O(3n)
	 */
	public void sortColors2(int[] nums) {
		int len = nums.length;
		int curColor = 0;
		for (int i = 0; i < len && curColor < 3;) {
			while (i < len && nums[i] == curColor) {
				++i;
			}
			if (i == len) {
				break;
			}
			int j = i + 1;
			while (true) {
				while (j < len && nums[j] != curColor) {
					++j;
				}
				if (j == len) {
					++curColor;
					break;
				}
				nums[j++] = nums[i];
				nums[i++] = curColor;
			}
		}
	}

	/*
	 * Count sort O(2n)
	 */
	public void sortColors1(int[] nums) {
		int redCount = 0;
		int whiteCount = 0;
		int blueCount = 0;
		int len = nums.length;
		for (int i = 0; i < len; ++i) {
			switch (nums[i]) {
			case 0:
				++redCount;
				break;
			case 1:
				++whiteCount;
				break;
			case 2:
				++blueCount;
				break;
			}
		}
		for (int i = 0; i < redCount; ++i) {
			nums[i] = 0;
		}
		for (int i = redCount; i < redCount + whiteCount; ++i) {
			nums[i] = 1;
		}
		for (int i = redCount + whiteCount; i < redCount + whiteCount + blueCount; ++i) {
			nums[i] = 2;
		}
	}
}
