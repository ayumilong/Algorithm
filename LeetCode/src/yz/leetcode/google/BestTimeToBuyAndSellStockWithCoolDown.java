/**
 * File Name: BestTimeToBuyAndSellStockWithCoolDown.java
 * Package Name: yz.leetcode.google
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 4:21:50 PM May 15, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.google;

/**
 * @author Yaolin Zhang
 * @time 4:21:50 PM May 15, 2016
 */
public class BestTimeToBuyAndSellStockWithCoolDown {
	//O(n) DP solution
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        int[] sell = new int[len]; //sell[i] means must sell at day i
        int[] cooldown = new int[len]; //cooldown[i] means day i is cooldown day
        sell[1] = prices[1] - prices[0];
        for(int i = 2; i < prices.length; ++i){
            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
            sell[i] = prices[i] - prices[i - 1] + Math.max(sell[i - 1], cooldown[i - 2]);
        }
        return Math.max(sell[len - 1], cooldown[len - 1]);
    }
    
	//O(n*n) DP solution
    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int[] profit = new int[prices.length];
        //profit[i] means prices[0...i]'s max profit
        //profit[i] = Math.max(oneTransaction[i], profit[i - 1], 
        // Math.max(profit[i - j] + prices[i] - Math.min(prices[j + 2...i - 1])));
        // k is from 0 to i - 3
        int min = prices[0] < prices[1] ? prices[0] : prices[1];
        profit[1] = prices[1] - min;
        for(int i = 2; i < prices.length; ++i){
            min = min < prices[i] ? min : prices[i];
            profit[i] = prices[i] - min > profit[i - 1] ? prices[i] - min : profit[i - 1];
            int max = 0;
            for(int j = i - 3; j >= 0; --j){
                max = (prices[i] - prices[j + 2]) > max ? (prices[i] - prices[j + 2]) : max;
                profit[i] = profit[i] > profit[j] + max ? profit[i] : profit[j] + max;
            }
        }
        return profit[prices.length - 1];
    }
	
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int inclusive = 0;
        int exclusive = 0;
        for(int i = 1; i < prices.length; ++i){
            int curProfit = prices[i] - prices[i - 1];
            int newInclusive = Math.max(inclusive + curProfit, exclusive);
            exclusive = Math.max(inclusive, exclusive);
            inclusive = newInclusive;
        }
        return inclusive > exclusive ? inclusive : exclusive;
    }
}
