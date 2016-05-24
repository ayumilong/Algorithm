/**
 * File Name: SqrtMe.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:16:37 PM Jan 6, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 8:16:37 PM Jan 6, 2016
 */
public class SqrtMe {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        while(low < high){
            int middle = low + (high - low) / 2;
            if(middle == x / middle){
                return middle;
            }
            if(middle > x / middle){
                high = middle;
            }else{
                low = middle + 1;
            }
        }
        return x == 1 ? 1 : low - 1;
    }
    public int mySqrt2(int num) {
        int res = 0;
        int bit = 1 << 30; // The second-to-top bit is set: 1 << 30 for 32 bits
 
        // "bit" starts at the highest power of four <= the argument.
        while (bit > num){
            bit >>= 2;
        }
        
        while (bit != 0) {
            if (num >= res + bit) {
                num -= res + bit;
                res = (res >> 1) + bit;
            }
            else{
                res >>= 1;
            }
            bit >>= 2;
        }
        return res;
    }
    
	int mySqrt1(int x){
		int high = 46340;
		high = high > (x / 2 + 1) ? x / 2 + 1 : high;
		int low = 1;
		int middle = (low + high) / 2;
		
		while(middle * middle != x){
		    if(middle * middle < x && ((middle + 1) * (middle + 1) > x || (middle + 1) * (middle + 1) < 0)){
		        return middle;
		    }
		    if(middle * middle < x){
		        low = middle + 1;
		    }else{
		        high = middle - 1;
		    }
		    middle = (low + high) / 2;
		}
		
		return middle;
	}
}
