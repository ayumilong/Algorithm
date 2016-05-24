/**
 * File Name: NumberOfDigitOne.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:56:31 PM Jan 6, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 7:56:31 PM Jan 6, 2016
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int count = 0;
        int pre = n % 10;
        if(pre >= 1){
            count = 1;
        }
        n = n / 10;
        int base = 1;
        int index = 1;
        while(n > 0){
          int cur = n % 10;
          count += (base * index * cur);
          if(cur == 1){
              count += (pre + 1);
          }else if(cur > 1){
              count += base * 10;
          }
          base *= 10;
          ++index;
          n = n / 10;
          pre = cur * base + pre;
        }
        return count;
    }
}
