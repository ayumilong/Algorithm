/**
 * File Name: InfiniteHouseOfPancakes.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose: Google Code Jam 2015 Qualification Round: B
 * Created Time: 8:18:08 PM Apr 7, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:18:08 PM Apr 7, 2016
 */
public class InfiniteHouseOfPancakes {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			int D = scan.nextInt();
			int[] diners = new int[D];
			for(int i = 0; i < D; ++i){
				diners[i] = scan.nextInt();
			}
			int[] counts = new int[1001];
			int max = 0;
			for(int n : diners){
				++counts[n];
				max = max > n ? max : n;
			}
			int minitues = max;
			for(int i = 1; i <= max; ++i){
				int cur = i;
				for(int j = i + 1; j <= max; ++j){
					cur += ((j - 1) / i) * counts[j];
				}
				minitues = minitues < cur ? minitues : cur;
			}
			System.out.printf("Case #%d: %d\n", t, minitues);
		}
		
		scan.close();
	}
	
	
	
	public static void main1(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			int D = scan.nextInt();
			//Big-heap
			PriorityQueue<Integer> diners = new PriorityQueue<>(new Comparator<Integer>(){
				public int compare(Integer i1, Integer i2){
					return i2 - i1;
				}
			});
			for(int i = 0; i < D; ++i){
				diners.offer(scan.nextInt());
			}
			System.out.println("Case #" + t + ": " + endBreakfast(diners));
		}
		scan.close();
	}
	public static int endBreakfast(PriorityQueue<Integer> diners){
		int minitues = diners.peek();
		int pre = 0;
		while(!diners.isEmpty()){
			int cur = diners.poll();
			if(pre >= minitues || cur == 1){
				break;
			}
			int count = 1;
			while(!diners.isEmpty() && diners.peek() == cur){
				++count;
				diners.poll();
			}
			int preCut = cur;
			int small = cur / 2;
			int big = cur - cur / 2;
			int div = 2;
			int curCut = count * (div - 1) + big;
			int low = 0;
			if(!diners.isEmpty()){
				low = diners.peek() - diners.peek() / 2;
			}
			while(curCut < preCut && small >= low){
				++div;
				preCut = curCut;
				small = cur / div;
				big = cur - (cur / div) * (div - 1);
				curCut = count * (div - 1) + big;
			}
			if(small == cur / 2){
				return minitues;
			}
			int amount = count * (div - 2);
			pre += amount; //Add special minitues
			small = cur / (div - 1);
			big = cur - (cur / (div - 1)) * (div - 2);
			while(amount > 0){
				--amount;
				diners.offer(small);
			}
			while(count > 0){
				--count;
				diners.offer(big);
			}
			int curTop = diners.peek();
			minitues = minitues < (pre + curTop) ? minitues : (pre + curTop);
		}
		return minitues;
	}	
}
