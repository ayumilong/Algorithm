/**
 * File Name: BestTimeToBuyAndSellStock.java
 * Package Name: yz.leetcode.microsoft
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:39:17 PM Apr 30, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.microsoft;

/**
 * @author Yaolin Zhang
 * @time 7:39:17 PM Apr 30, 2016
 */
public class BestTimeToBuyAndSellStock {
	//Can make only one transaction
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] > min){
                profit = profit > prices[i] - min ? profit : prices[i] - min;
            }else{
                min = prices[i];
            }
        }
        return profit;
    }
    
    //Can make as many transactions as possible
    public int maxProfitAny(int[] prices) {
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
    
    //Can make two transactions
    public int maxProfitTwo(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[] leftProfit = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; ++i){
            if(min < prices[i]){
                leftProfit[i] = prices[i] - min > leftProfit[i - 1] ? prices[i] - min : leftProfit[i - 1];
            }else{
                min = prices[i];
                leftProfit[i] = leftProfit[i - 1];
            }
        }
        int[] rightProfit = new int[prices.length];
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; --i){
            if(max > prices[i]){
                rightProfit[i] = max - prices[i] > rightProfit[i + 1] ? max - prices[i] : rightProfit[i + 1];
            }else{
                max = prices[i];
                rightProfit[i] = rightProfit[i + 1];
            }
        }
        int profit = rightProfit[0];
        for(int i = 0; i < prices.length - 1; ++i){
            profit = profit > leftProfit[i] + rightProfit[i + 1] ? profit : leftProfit[i] + rightProfit[i + 1];
        }
        return profit;
    }
}
