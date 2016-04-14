/**
 * File Name: SpiralMatrixII.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 12:59:56 PM Apr 2, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

/**
 * @author Yaolin Zhang
 * @time 12:59:56 PM Apr 2, 2016
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        //@Lu
        if(n < 0){
            return null;
        }
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = n-1;
        int number = 1;
        while(left <= right && up <= down){
            for(int i = left; i <= right; i++){
                matrix[up][i] = number++;
            }
            for(int i = up + 1; i <= down; i++){
                matrix[i][right] = number++;
            }
            if(left == right || up == down){
                break;
            }
            for(int i = right -1; i >= left;i--){
                matrix[down][i] = number++;
            }
            for(int i = down -1; i >= left+1;i--){
                matrix[i][left] = number++;
            }
            up++;
            left++;
            down--;
            right--;
        }
        return matrix;
    }
    
    public int[][] generateMatrix1(int n) {
        // Write your code here
        int[][] matrix = new int[n][n];
        int startX = 0;
        int startY = 0;
        int number = 1;
        while(n > 1){
            int endX = startX + n;
            int endY = startY + n;
            
            int i = startX;
            int j = startY;
            //Go right
            while(j < endY - 1){
                matrix[i][j++] = number++;
            }
            //Go down
            while(i < endX - 1){
                matrix[i++][j] = number++;
            }
            //Go left
            while(j > startY){
                matrix[i][j--] = number++;
            }
            //Go up
            while(i > startX){
                matrix[i--][j] = number++;
            }
            n -= 2;
            ++startX;
            ++startY;
        }
        if(n == 1){
            matrix[startX][startY] = number;
        }
        return matrix;
    }
}
