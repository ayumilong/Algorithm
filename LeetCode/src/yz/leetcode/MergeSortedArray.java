/**
 * File Name: MergeSortedArray.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:04:28 PM Sep 7, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 7:04:28 PM Sep 7, 2015
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		//if (m == 0) {
		//	System.arraycopy(nums2, 0, nums1, 0, n);
		//}
		int flag = m + n - 1; //
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums2[j] >= nums1[i]) {
				nums1[flag--] = nums2[j--];
			} else {
				nums1[flag--] = nums1[i--];
			}
		}
		while(j >= 0){
			nums1[flag--] = nums2[j--];
		}
	}
	
	
	
}
