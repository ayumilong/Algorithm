/**
 * File Name: HappyNumber.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:51:23 PM Dec 7, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:51:23 PM Dec 7, 2015
 */
public class HappyNumber {
	public boolean isHappy1(int n) {
		int sum = n;
		while (n != 1 && n != 4) {
			sum = 0;
			while (n > 0) {
				sum += (n % 10) * (n % 10);
				n /= 10;
			}
			System.out.println(sum);
			n = sum;
		}
		return sum == 1;
	}

	public boolean isHappy(int n) {
		int num = n;
		HashSet<Integer> nums = new HashSet<>();
		while (num != 1) {
			int temp = 0;
			while (num != 0) {
				temp += (num % 10) * (num % 10);
				num = num / 10;
			}
			num = temp;
			System.out.println(num);
			if (!nums.add(num)) {
				return false;
			}
		}
		return true;
	}
}
