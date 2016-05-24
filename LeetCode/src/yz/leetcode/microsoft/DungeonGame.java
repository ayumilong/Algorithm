/**
 * File Name: DungeonGame.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:11:05 AM May 21, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:11:05 AM May 21, 2016
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){//[],[[]]
            return 0;
        }
        int[][] flag = new int[dungeon.length][dungeon[0].length];
        int min = dfs(dungeon, flag, 0, 0);
        return min;
    }
    
    private int dfs(int[][] dungeon, int[][] flag, int x, int y){
        if(flag[x][y] != 0){
            return flag[x][y];
        }
        if(x == dungeon.length - 1 && y == dungeon[0].length - 1){//The down-right corner
            flag[x][y] = dungeon[x][y] < 0 ? -dungeon[x][y] + 1 : 1; //The minimum is 1
            return flag[x][y];
        }
        int min = Integer.MAX_VALUE;
        //go down
        if(x < dungeon.length - 1){
            int down = dfs(dungeon, flag, x + 1, y);
            min = min < down ? min : down; 
        }
        //go right
        if(y < dungeon[0].length - 1){
            int right = dfs(dungeon, flag, x, y + 1);
            min = min < right ? min : right;
        }
        if(dungeon[x][y] >= min){//If min is 6, dungeon[x][y] if 10, then min should be updated to 1
            min = 1;
        }else{//If min is 6, dungeon[x][y] is 3 or -3, then min should be updated to 3 or 9
            min = min - dungeon[x][y];
        }
        flag[x][y] = min;
        return min;
    }
}
