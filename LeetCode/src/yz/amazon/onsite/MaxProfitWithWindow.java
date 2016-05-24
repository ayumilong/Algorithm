/**
 * File Name: MaxProfitWithWindow.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:57:28 PM Apr 16, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.awt.Graphics;
import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 11:57:28 PM Apr 16, 2016
 */
public class MaxProfitWithWindow {
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		MaxProfitWithWindow mpw = new MaxProfitWithWindow();
		while(T > 0){
			--T;
			int N = scan.nextInt();
			int[] prices = new int[N];
			for(int i = 0; i < N; ++i){
				prices[i] = scan.nextInt();
			}
			System.out.println(mpw.maxProfit(prices));
		}
		
		scan.close();
	}
	//Two Pointers
	public int maxProfit(int[] prices){
		if(prices == null || prices.length == 0){
			return 0;
		}
		int low = 0;
		int high = prices.length - 1;
		int max = 0;
		while(low <= high){
			int cur = 0;
			if(prices[low] < prices[high]){
				cur = prices[low] * (high - low + 1);
				++low;
			}else{
				cur = prices[high] * (high - low + 1);
				--high;
			}
			max = max > cur ? max : cur;
		}
		
		return max;
	}
}
