/**
 * File Name: BestTimeToBuyAndSellStockII.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:48:27 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

/**
 * @author Yaolin Zhang
 * @time 11:48:27 PM Apr 17, 2016
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
