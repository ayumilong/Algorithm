/**
 * File Name: ExcelSheetColumnTitle.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:02:47 PM Dec 11, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 9:02:47 PM Dec 11, 2015
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String result = "";
        while(n != 0){
            char c;
            int temp = n % 26;
            if(temp == 0){
                n -= 26;
                c = 'Z';
            }else{
                c = (char)(temp - 1 + 'A');
            }
            result = c + result;
            n = n / 26;
        }
        return result;
    }
}
