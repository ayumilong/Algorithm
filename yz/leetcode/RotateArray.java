/**
 * File Name: RotateArray.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 5:38:42 PM Sep 6, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 5:38:42 PM Sep 6, 2015
 */
public class RotateArray {
	/*
	 * O(n*k) time and O(1) space
	 */
	public void rotate2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int len = nums.length;
		k = k % len;
		if (k == 0) {
			return;
		}
		for (int i = len - k; i < len; ++i) {
			int temp = nums[i];
			for (int j = i - 1; j >= (i - (len - k)); --j) {
				nums[j + 1] = nums[j];
			}
			nums[i - (len - k)] = temp;
		}
	}
	/*
	 * O(1) space and O(n) time
	 */
	
	private int getGcd(int n1, int n2){
		if(n2 == 0){
			return n1;
		}
		return getGcd(n2, n1 % n2);
	}
	
	public void rotate0(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int len = nums.length;
		k = k % len;
		
		if (k == 0) {
			return;
		}
		
		int gcd = getGcd(len, k);
		
		for(int i = 0; i < gcd; ++i){
			int j = i;
			int temp = nums[j];
			while (true) {
				//int next = (j - k < 0) ? j - k + len : j - k;
				int next = (j - k + len) % len;
				if (next == i) {
					nums[j] = temp;
					break;
				}
				nums[j] = nums[next];
				j = next;
			}
		}
		/*
		if(gcd == 1){ //GCD is 1, only one circle starting at 0
			int i = 0;
			int temp = nums[i];
			while (true) {
				int next = (i - k < 0) ? i - k + len : i - k;
				if (next == 0) {
					nums[i] = temp;
					break;
				}
				nums[i] = nums[next];
				i = next;
			}
		}else{//GCD is not 1, 
			int circles = (k <= len / 2) ? k : len - k;
			for(int i = 0; i < circles; ++i){
				int j = i;
				int temp = nums[j];
				while (true) {
					int next = (j - k < 0) ? j - k + len : j - k;
					if (next == i) {
						nums[j] = temp;
						break;
					}
					nums[j] = nums[next];
					j = next;
				}
			}
		}
		*/
	}

	/*
	 * O(n) time and O(n) space
	 */
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int len = nums.length;
		k = k % len;
		if (k == 0) {
			return;
		}
		boolean[] flag = new boolean[len];
		for (int j = 0; j < len; ++j) {
			if(flag[j]){
				continue;
			}
			int i = j;
			int temp = nums[i];
			while (true) {
				flag[i] = true;
				int next = (i - k < 0) ? i - k + len : i - k;
				if (flag[next]) {
					nums[i] = temp;
					break;
				}
				nums[i] = nums[next];
				i = next;
			}
		}
	}
}
