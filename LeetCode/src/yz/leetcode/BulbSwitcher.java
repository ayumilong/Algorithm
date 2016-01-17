/**
 * File Name: BulbSwitcher.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:47:15 PM Jan 6, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 8:47:15 PM Jan 6, 2016
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        int count = 0;
        for(int i = 1; i * i <= n; ++i){
            ++count;
        }
        return count;
    }
}
