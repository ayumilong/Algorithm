/**
 * File Name: GroupImage.java
 * Package Name: yz.amazon.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:10:04 PM Apr 16, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.amazon;

/**
 * @author Yaolin Zhang
 * @time 10:10:04 PM Apr 16, 2016
 */
public class GroupImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int n = matrix.length;
		for (int i = 0; i < n / 2; ++i) {
			// Set (i, j) -> (j, n - i - 1) -> (n - i - 1, n - j - 1)
			// -> (n -j - 1, i) -> (i, j)
			for (int j = i; j < n - i - 1; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}
}
