/**
 * File Name: LongestIncreasingPathInMatrix.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 6:41:03 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

/**
 * @author Yaolin Zhang
 * @time 6:41:03 PM Apr 17, 2016
 */
public class LongestIncreasingPathInMatrix {
	//DFS with Memory Searching
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }   
        int max = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] pathLen = new int[rows][cols];
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(pathLen[i][j] == 0){
                    dfs(matrix, i, j, pathLen);
                }
                max = max > pathLen[i][j] ? max : pathLen[i][j];
            }
        }
        
        return max;
    }
    
    private void dfs(int[][] matrix, int x, int y, int[][] pathLen){
        int max = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 4; ++i){
            int curX = x + dx[i];
            int curY = y + dy[i];
            if(curX < 0 || curX >= matrix.length || curY < 0 || curY >= matrix[0].length){
                continue;
            }
            if(matrix[curX][curY] > matrix[x][y]){
                if(pathLen[curX][curY]  == 0){
                    dfs(matrix, curX, curY, pathLen);
                }
                max = max > pathLen[curX][curY] + 1  ? max : pathLen[curX][curY] + 1;
            }
        }
        pathLen[x][y] = max;
    }
}
