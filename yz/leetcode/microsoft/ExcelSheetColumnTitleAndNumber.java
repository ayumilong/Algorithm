/**
 * File Name: ExcelSheetColumnTitleAndNumber.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:37:47 PM Apr 30, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

/**
 * @author Yaolin Zhang
 * @time 10:37:47 PM Apr 30, 2016
 */
public class ExcelSheetColumnTitleAndNumber {
    public int titleToNumber(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); ++i){
            num = num * 26 + (s.charAt(i) - 'A' + 1);
        }
        return num;
    }
	
    public String convertToTitle(int n) {
        String result = "";
        while(n != 0){
            int cur = n % 26;
            if(cur == 0){
                result  = 'Z' + result;
                n = (n - 26) / 26;
            }else{
                result = (char)(cur + 'A' - 1) + result;
                n /= 26;
            }
        }
        return result;
    }
}
