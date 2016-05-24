/**
 * File Name: ReverseBits.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:52:58 PM Dec 5, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 8:52:58 PM Dec 5, 2015
 */
public class ReverseBits {
	public int reverseBits(int n) {
		int count = 0;
		for (int i = 0; i < 32 && n != 0; i++) {
			if ((n & 1) != 0) {
				count |= 1 << (31 - i);
			}
			n >>= 1;
		}
		return count;
	}

	public int reverseBits1(int n) {
		int rlt = 0;
		for (int i = 31; i >= 0; i--) {
			rlt |= (((n << (i)) >>> 31) << (i));
		}
		return rlt;
	}
}
