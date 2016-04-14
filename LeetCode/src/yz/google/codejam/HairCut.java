/**
 * File Name: HairCut.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose: Google Code Jam 2015 Round 1A: B
 * Created Time: 11:52:14 PM Apr 9, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 11:52:14 PM Apr 9, 2016
 */
public class HairCut {
	//Binary Search
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			int B = scan.nextInt();
			int N = scan.nextInt();
			int[] M = new int[B];
			for(int i = 0; i < B; ++i){
				M[i] = scan.nextInt();
			}
			
			long low = 1;
			long high = N * 100000L; //Maximum time needed
			while(low < high){
				long mid = low + (high - low) / 2;
				if(check(M, mid, N)){
					high = mid;
				}else{
					low = mid + 1;
				}
			}
			int sum = 0;
			for(int i = 0; i < B; ++i){
				sum += (low - 1) / M[i] + 1;
			}
			int cut = 0;
			for(int i = 0; i < B; ++i){
				if(low % M[i] == 0){
					++cut;
					if(cut == N - sum){
						cut = i + 1;
						break;
					}
				}
			}
			System.out.printf("Case #%d: %d\n", t, cut);
		}
		scan.close();
	}
	
	public static boolean check(int[] M, long time, int N){
		long sum = 0;
		for(int i = 0; i < M.length; ++i){
			sum += time / M[i] + 1;
		}
		return sum >= N;
	}
	
	
	//Can only process small input data
	public static void main1(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			int B = scan.nextInt();
			int N = scan.nextInt();
			int[] M = new int[B];
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < B; ++i){
				M[i] = scan.nextInt();
				min = min < M[i] ? min : M[i];
			}
			//Smallest Common Multiple
			int SCM = M[0];
			for(int i = 1; i < B; ++i){
				int big = SCM > M[i] ? SCM : M[i];
				int small = SCM < M[i] ? SCM : M[i];
				int GCD = findGCD(big, small);
				SCM = (SCM / GCD) * M[i];
			}
			int sum = 0;
			for(int m : M){
				sum += (int)Math.ceil(SCM / (double)m);
			}
			System.out.println(SCM + " " + sum);
			N = (N - 1) % sum + 1;
			int cutCount = 0;
			int cutTime = 0;
			int i = 0;
			while(cutCount < N){
				++cutTime;
				i = 0;
				for(; i < B; ++i){
					if((cutTime % M[i]) == 1 || M[i] == 1){
						++cutCount;
						if(cutCount == N){
							break;
						}
					}
				}
			}
			System.out.printf("Case #%d: %d\n", t, i + 1);
		}
		scan.close();
	}
	
	public static int findGCD(int n1, int n2){
		if(n2 == 0){
			return n1;
		}
		return findGCD(n2, n1 % n2);
	}
}
