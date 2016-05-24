/**
 * File Name: DesignTicTacToe.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:08:59 PM May 11, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

/**
 * @author Yaolin Zhang
 * @time 7:08:59 PM May 11, 2016
 */
public class TicTacToe {
    private char[][] board;
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int dimension;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new char[n][n];
        this.rows = new int[n];
        this.cols = new int[n];
        this.dimension = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(row < 0 || row >= this.dimension || col < 0 || col >= this.dimension || board[row][col] != 0){
            return 0;
        }
        if(player < 1 || player > 2){
            return 0;
        }
        board[row][col] = player == 1 ? '1' : '2';
        int value = player == 1 ? 1 : -1;
        rows[row] += value;
        cols[col] += value;
        if(row == col){
            this.diagonal += value;
        }
        if(row + col == this.dimension - 1){
            this.antiDiagonal += value;
        }
        int threshold = value * this.dimension;
        if(rows[row] == threshold || cols[col] == threshold || this.diagonal == threshold || this.antiDiagonal == threshold){
            return player;
        }
        return 0;
    }
}
