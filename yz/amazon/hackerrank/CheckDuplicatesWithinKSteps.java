/**
 * File Name: CheckDuplicatesWithinKSteps.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 2:15:22 PM Apr 2, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 2:15:22 PM Apr 2, 2016
 */
public class CheckDuplicatesWithinKSteps {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		if(rows < 1){
			scan.close();
			return;
		}
		scan.nextLine();
		int[][] matrix = new int[rows][];
		int index = 0;
		while(index < rows){
			String line = scan.nextLine();
			String[] nums = line.split(" ");
			matrix[index] = new int[nums.length];
			for(int i = 0; i < nums.length; ++i){
				matrix[index][i] = Integer.parseInt(nums[i]);
			}
			++index;
		}
		int k = scan.nextInt();
		if(findDuplicate(matrix, k)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		if(checkDupilcate(matrix, k)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		scan.close();
	}
	
	private static boolean findDuplicate(int[][] matrix, int k){
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0; i < rows; ++i){
			for(int j = 0; j < cols; ++j){
				int steps = k;
				HashSet<Integer> set = new HashSet<>();
				Queue<Integer> indexX = new LinkedList<>();
				Queue<Integer> indexY = new LinkedList<>();
				boolean[][] flag = new boolean[rows][cols];
				indexX.offer(i);
				indexY.offer(j);
				flag[i][j] = true;
				set.add(matrix[i][j]);
				int[] dx = {-1, 1, 0, 0};
				int[] dy = {0, 0, -1, 1};
				while(steps > 0 && !indexX.isEmpty()){
					int x = indexX.poll();
					int y = indexY.poll();
					--steps;
					for(int m = 0; m < 4; ++m){
						int curX = dx[m] + x;
						int curY = dy[m] + y;
						if(curX >= 0 && curX < rows && curY >= 0 && curY < cols){
							if(flag[curX][curY]){
								continue;
							}
							if(set.contains(matrix[curX][curY])){
								return true;
							}else{
								indexX.offer(curX);
								indexY.offer(curY);
								flag[curX][curY] = true;
								set.add(matrix[curX][curY]);
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private static class Index{
		int x;
		int y;
		Index(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean checkDupilcate(int[][] matrix, int k){
		int rows = matrix.length;
		int cols = matrix[0].length;
		HashMap<Integer, List<Index>> duplicates = new HashMap<>();
		for(int i = 0; i < rows; ++i){
			for(int j = 0; j < cols; ++j){
				int cur = matrix[i][j];
				if(duplicates.containsKey(cur)){
					duplicates.get(cur).add(new Index(i, j));
				}else{
					List<Index> curList = new LinkedList<>();
					curList.add(new Index(i, j));
					duplicates.put(cur, curList);
				}
			}
		}
		
		for(List<Index> li : duplicates.values()){
			int len = li.size();
			for(int i = 0; i < len; ++i){
				for(int j = i + 1; j < len; ++j){
					if(isDuplicate(li.get(i), li.get(j), k)){
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private static boolean isDuplicate(Index i1, Index i2, int k){
		int distance = Math.abs(i1.x - i2.x) + Math.abs(i1.y - i2.y);
		return distance <= 2 * k;
	}
}
