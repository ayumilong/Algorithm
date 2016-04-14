/**
 * File Name: StockMax.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 12:05:52 AM Apr 2, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:05:52 AM Apr 2, 2016
 */
public class StockMax {
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		while (cases > 0) {
			--cases;
			int len = scan.nextInt();
			long[] stock = new long[len];
			int index = 0;
			while (index < len) {
				stock[index] = scan.nextInt();
				++index;
			}
			System.out.println(maxProfit(stock, len));
		}
		scan.close();
	}
	
    private static long maxProfit(long[] stock, int len){
        long[] preSum = new long[len + 1];
        for(int i = 1; i <= len; ++i){
        		preSum[i] = preSum[i - 1] + stock[i - 1];
        }
        Stack<Long> max = new Stack<>();
        Stack<Integer> index = new Stack<>();
        max.push(Long.MAX_VALUE);
        index.push(-1);
        for(int i = 0; i < len; ++i){
            while(!max.isEmpty() && stock[i] > max.peek()){
                max.pop();
                index.pop();
            }
            max.push(stock[i]);
            index.push(i);
        }
        long profit = 0;
        long curMax = max.pop();
        int curIndex = index.pop();
        while(!max.isEmpty()){
            while(!max.isEmpty() && max.peek() < curMax){
                max.pop();
                index.pop();
            }
            profit += curMax * (curIndex - index.peek() - 1) - (preSum[curIndex] - preSum[index.peek() + 1]);
            curMax = max.pop();
            curIndex = index.pop();
        }
        return profit;
    }

	private static long maxProfit1(long[] stock, int len) {
		long maxProfit = 0;
		long[] preSum = new long[len + 1];
		preSum[0] = 0L;
		for (int i = 1; i <= len; ++i) {
			preSum[i] = preSum[i - 1] + stock[i - 1];
		}
		Stack<Long> max = new Stack<>();
		Stack<Long> profit = new Stack<>();
		Stack<Integer> index = new Stack<>();
		max.push(Long.MAX_VALUE);
		profit.push(0L);
		index.push(-1);

		for (int i = 0; i < len; ++i) {
			if (stock[i] > max.peek()) {
				while (!max.isEmpty() && stock[i] > max.peek()) {
					max.pop();
					maxProfit -= profit.pop();
					index.pop();
				}
				Long curProfit = ((long) i - index.peek() - 1L) * stock[i] - (preSum[i] - preSum[index.peek() + 1]);
				maxProfit += curProfit;
				max.push(stock[i]);
				index.push(i);
				profit.push(curProfit);
			} else {
				max.push(stock[i]);
				index.push(i);
				profit.push(0L);
			}
		}
		return maxProfit;
	}
}
