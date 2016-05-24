/**
 * File Name: BestTimeToBuyAndSellStockIII.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:52:08 PM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

/**
 * @author Yaolin Zhang
 * @time 11:52:08 PM Apr 17, 2016
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[] leftProfit = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] <= min){
                min = prices[i];
                leftProfit[i] = leftProfit[i - 1];
            }else{
                leftProfit[i] = leftProfit[i - 1] > prices[i] - min ? leftProfit[i - 1] : prices[i] - min;
            }
        }
        
        int[] rightProfit = new int[prices.length];
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; --i){
            if(prices[i] >= max){
                max = prices[i];
                rightProfit[i] = rightProfit[i + 1];
            }else{
                rightProfit[i] = rightProfit[i + 1] > max - prices[i] ? rightProfit[i + 1] : max - prices[i];
            }
        }
        
        int maxProfit = rightProfit[0];
        for(int i = 0; i < prices.length - 1; ++i){
            int cur = leftProfit[i] + rightProfit[i + 1];
            maxProfit = maxProfit > cur ? maxProfit : cur;
        }
        return maxProfit;
    }
}
