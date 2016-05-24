/**
 * File Name: IntegerToRoman.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:55:52 PM Apr 16, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

/**
 * @author Yaolin Zhang
 * @time 10:55:52 PM Apr 16, 2016
 */
public class IntegerToRoman {
	//Generate
    public String intToRoman(int num) {
        int[] key = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] value = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder("");
        int index = 0;
        while(num > 0){
            if(num >= key[index]){
                num -= key[index];
                roman.append(value[index]);
            }else{
                ++index;
            }
        }
        return roman.toString();
    }
	//Store the map of each number to Roman
    public String intToRoman1(int num) {
        //char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        String[] hundredsStr = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tensStr = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] onesStr = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder romanNum = new StringBuilder("");
        int thousands = num / 1000;
        num = num % 1000;
        for(int i = 0; i < thousands; ++i){
            romanNum.append("M");
        }
        
        int hundreds = num / 100;
        num = num % 100;
        romanNum.append(hundredsStr[hundreds]);
        
        int tens = num / 10;
        num = num % 10;
        romanNum.append(tensStr[tens]);
        
        romanNum.append(onesStr[num]);
        return romanNum.toString();
    }
}
