/**
 * File Name: Candy.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:07:27 PM Apr 2, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:07:27 PM Apr 2, 2016
 */
public class Candy {
	public int candy(int[] ratings){
		if(ratings == null || ratings.length == 0){
			return 0;
		}
		int[] count = new int[ratings.length];
		Arrays.fill(count, 1);
		for(int i = 1; i < ratings.length; ++i){
			if(ratings[i] > ratings[i - 1]){
				count[i] = count[i - 1] + 1;
			}
		}
		int sum = 0;
		for(int i = ratings.length; i >= 1; --i){
			sum += count[i];
			if(ratings[i - 1] > ratings[i] && count[i - 1] <= count[i]){
				count[i - 1] = count[i] + 1;
			}
		}
		sum += count[0];
		return sum;
	}
	
    public int candy1(int[] ratings) {
        // Write your code here
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        int len = ratings.length;
        int sum = 1;
        int pre = 1;
        for(int i = 1; i < len; ++i){
            if(ratings[i] > ratings[i - 1]){
                ++pre;
                sum += pre;
            }else{//Find a decrease sequence
                int curSum = 1;
                int curPre = 1;
                int j = i; //Store i for use later
                while(i < len - 1 && ratings[i] > ratings[i + 1]){
                    ++i;
                    ++curPre;
                    curSum += curPre;
                }
                sum += curSum;
                //Update the candy number of current summit
                if(curPre >= pre && ratings[j] != ratings[j - 1]){
                    sum += (curPre - pre + 1);
                }
                pre = 1;
            }
        }
        return sum;
    }
}
