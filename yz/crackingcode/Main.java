/**
 * File Name: Main.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:19:08 PM Aug 30, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

import java.io.*;
import java.io.IOException;
import java.util.*;

import yz.leetcode.tools.BitInteger;

/**
 * @author Yaolin Zhang
 * @time 1:19:08 PM Aug 30, 2015
 */
public class Main {
	public static ArrayList<BitInteger> initialize(int n, int missing) {
		BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();
		ArrayList<BitInteger> array = new ArrayList<BitInteger>();

		for (int i = 1; i <= n; i++) {
			array.add(new BitInteger(i == missing ? 0 : i));
		}

		// Shuffle the array once.
		for (int i = 0; i < n; i++) {
			int rand = i + (int) (Math.random() * (n - i));
			array.get(i).swapValues(array.get(rand));
		}

		return array;
	}

	public static int findOnePairs(int num) {
		int mask = 3;
		int result = 0;
		for (int i = 0; i < 31; ++i) {
			if ((num & (mask << i)) == (mask << i)) {
				++result;
			}
		}
		return result;
	}
	
    public static void main(String args[]) throws IOException{
    		System.out.println(Long.MAX_VALUE);
    		String tst = "1.2.3.4";
    		String[] sa = tst.split("/");
    		System.out.println(tst.equals("1.2.3.4"));
    	
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        while(cases > 0){
            --cases;
            int len = Integer.parseInt(reader.readLine());
            char pre = (char)reader.read();
            int firstCount = 1;
            int secondCount = 0;
            int thirdCount = 0;
            boolean isFirst = true;
            boolean isSecond = false;
            boolean isThird = false;
            boolean find = false;
            while(len > 1){
                --len;
                char cur = (char)reader.read();
                if(cur == pre){
                    if(isFirst){
                        ++firstCount;
                    }else if(isSecond){
                        ++secondCount;
                        if(secondCount > firstCount){//Need to restart
                        		isFirst = true;
                            isSecond = false;
                            firstCount = secondCount;
                            secondCount = 0;
                        }
                    }else if(isThird){
                        ++thirdCount;
                        if(thirdCount >= secondCount){//Find
                        		find = true;
                            break;
                        }
                    }
                }else {
                		if(isThird && thirdCount == secondCount){
                			find = true;
                			break;
                		}
                    if(cur == pre + 1){
                        if(!isSecond){//Second char
                            isFirst = false;
                            isSecond = true;
                            secondCount = 1;
                        }else if(!isThird){//Third char
                            isSecond = false;
                            isThird = true;
                            thirdCount = 1;
                        }else{//Make third one as first one, aaaabbbccddee, cc is third one and make it to first one
                        		isFirst = false;
                        		isSecond = true;
                        		isThird = false;
                        		firstCount = thirdCount;
                        		secondCount = 1;
                        		thirdCount = 0;
                        }
                        pre = cur;
                    }else{//Restart
                        isFirst = true;
                        isSecond = false;
                        isThird = false;
                        firstCount = 1;
                        secondCount = 0;
                        thirdCount = 0;
                        pre = cur;
                    }
                }
            }
            if(find || (thirdCount != 0 && thirdCount == secondCount)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            reader.skip(len);
        }
        reader.close();
    }
}
