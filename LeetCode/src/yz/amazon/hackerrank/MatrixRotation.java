/**
 * File Name: MatrixRotation.java
 * Package Name: yz.geeksforgeeks
 * Project Name: LeetCode
 * Purpose: https://www.hackerrank.com/challenges/matrix-rotation-algo
 * Created Time: 7:45:37 PM Apr 1, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 7:45:37 PM Apr 1, 2016
 */
public class MatrixRotation {
	public static void main1(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		int N = scan.nextInt();
		int R = scan.nextInt();
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {
				matrix[i][j] = scan.nextInt();
			}
		}
		{
			rotateMatrix(matrix, R);
		}
		for (int[] m : matrix) {
			for (int n : m) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
		scan.close();
	}

	private static int copy(int[][] square, int i, int j, int pre) {
		int temp = square[i][j];
		square[i][j] = pre;
		return temp;
	}

	// Can handle 1 row matrix and 1 column matrix
	private static void rotateMatrix(int[][] matrix, int r) {
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		while (top <= bottom && left <= right) {
			int rows = bottom - top + 1;
			int cols = right - left + 1;
			int count = 0;
			if(rows == 1){
				count = cols;
			}else if(cols == 1){
				count = rows;
			}else{
				count = 2 * rows + 2 * cols - 4;
			}
			int curR = r % count;
			while (curR > 0) {
				--curR;
				int pre = matrix[top][left];
				for (int i = top + 1; i <= bottom; i++) {
					pre = copy(matrix, i, left, pre);
				}
				for (int i = left + 1; i <= right; i++) {
					pre = copy(matrix, bottom, i, pre);
				}
				if (top == bottom || left == right) {
					matrix[top][left] = pre;
					break;
				}
				for (int i = bottom - 1; i >= top; i--) {
					pre = copy(matrix, i, right, pre);
				}
				for (int i = right - 1; i >= left; i--) {
					pre = copy(matrix, top, i, pre);
				}
			}
			top++;
			bottom--;
			left++;
			right--;
		}
	}

	private static void rorateOneRow(int[][] matrix, int r, int cols) {
		int[] temp = new int[cols];
		for (int i = 0; i < cols; ++i) {
			temp[(i + r) % cols] = matrix[0][i];
		}
		for (int i = 0; i < cols; ++i) {
			matrix[0][i] = temp[i];
		}
	}

	private static void rorateOneCol(int[][] matrix, int r, int rows) {
		int[] temp = new int[rows];
		for (int i = 0; i < rows; ++i) {
			temp[(i + r) % rows] = matrix[i][0];
		}
		for (int i = 0; i < rows; ++i) {
			matrix[i][0] = temp[i];
		}
	}

	// Do not consider 1 row matrix or 1 column matrix
	private static void rotateMatrix2(int[][] matrix, int r) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int startX = 0;
		int startY = 0;
		while (rows > 1 && cols > 1) {
			int count = 2 * rows + 2 * cols - 4; // How many numbers need to
													// rotate
			int curR = r % count; // Rotate how many times
			int[] curArray = new int[count];
			get(matrix, curArray, startX, startY, startX + rows, startY + cols, curR, count);
			restore(matrix, curArray, startX, startY, startX + rows, startY + cols);
			rows -= 2;
			cols -= 2;
			++startX;
			++startY;
		}
	}

	private static void restore(int[][] matrix, int[] array, int startX, int startY, int endX, int endY) {
		int index = 0;
		int i = startX;
		int j = startY;
		while (i < endX - 1) {
			matrix[i++][j] = array[index++];
		}
		while (j < endY - 1) {
			matrix[i][j++] = array[index++];
		}
		while (i > startX) {
			matrix[i--][j] = array[index++];
		}
		while (j > startY) {
			matrix[i][j--] = array[index++];
		}
	}

	private static void get(int[][] matrix, int[] array, int startX, int startY, int endX, int endY, int r, int count) {
		int index = 0;
		int i = startX;
		int j = startY;
		while (i < endX - 1) {
			array[(index + r) % count] = matrix[i][j];
			++i;
			++index;
		}
		while (j < endY - 1) {
			array[(index + r) % count] = matrix[i][j];
			++j;
			++index;
		}
		while (i > startX) {
			array[(index + r) % count] = matrix[i][j];
			--i;
			++index;
		}
		while (j > startY) {
			array[(index + r) % count] = matrix[i][j];
			--j;
			++index;
		}
	}

	// Cannot handle 1 row matrix and 1 column matrix
	private static void rotateMatrix1(int[][] matrix, int r) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int startX = 0;
		int startY = 0;
		while (rows > 1 && cols > 1) {
			int count = 2 * rows + 2 * cols - 4; // How many numbers need to
													// rotate
			int curR = r % count; // Rotate how many times
			while (curR > 0) {
				--curR;
				int i = startX;
				int j = startY;
				int endX = i + rows;
				int endY = i + cols;
				// Go down
				int pre = matrix[i][j];
				while (i < endX - 1) {
					pre = copy(matrix, ++i, j, pre);
				}
				// Go right
				while (j < endY - 1) {
					pre = copy(matrix, i, ++j, pre);
				}
				if (rows == 1 || cols == 1) {
					break;
				}
				// Go up
				while (i > startX) {
					pre = copy(matrix, --i, j, pre);
				}
				// Go left
				while (j > startY) {
					pre = copy(matrix, i, --j, pre);
				}
			}
			rows -= 2;
			cols -= 2;
			++startX;
			++startY;
		}
	}
}
