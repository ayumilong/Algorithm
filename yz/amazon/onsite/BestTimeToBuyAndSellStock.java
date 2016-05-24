/**
 * File Name: BestTimeToBuyAndSellStock.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:42:42 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

/**
 * @author Yaolin Zhang
 * @time 11:42:42 PM Apr 17, 2016
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int p : prices){
            if(p < min){
                min = p;
            }else{
                max = max > (p - min) ? max : p - min;
            }
        }
        return max;
    }
}
