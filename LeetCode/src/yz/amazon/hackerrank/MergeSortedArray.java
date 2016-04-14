/**
 * File Name: MergeSortedArray.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:04:28 PM Sep 7, 2015
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

/**
 * @author Yaolin Zhang
 * @time 7:04:28 PM Sep 7, 2015
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		//copy from back to front
		int index = m + n - 1; 
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums2[j] >= nums1[i]) {
				nums1[index--] = nums2[j--];
			} else {
				nums1[index--] = nums1[i--];
			}
		}
		while(j >= 0){
			nums1[index--] = nums2[j--];
		}
	}
}
