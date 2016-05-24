/**
 * File Name: Fractiles.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose:  Google Code Jam 2016 Qualification Round: D
 * Created Time: 8:11:23 PM Apr 8, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:11:23 PM Apr 8, 2016
 */
public class Fractiles {
	public static void main(String args[]){
		System.out.println(Long.MAX_VALUE);
		System.out.println((long)Math.pow(10, 18));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			int K = scan.nextInt();
			int C = scan.nextInt();
			int S = scan.nextInt();
			int ans = (int)Math.ceil(K / (double)C);
			//System.out.println("ans: " + ans);
			if(ans > S){
				System.out.printf("Case #%d: IMPOSSIBLE\n", t);
				continue;
			}
			long[] pos = new long[ans];
			for(int i = 0; i < ans; ++i){
				int start = C * i + 1;
				int end = (i + 1) * C;
				end = end < K ? end : K;
				long cur = 0;
				long radix = 1L;
				for(int j = 0; j < C; ++j){
					cur += (end - 1) * radix;
					radix *= K;
					--end;
					end = end > start ? end : start;
				}
				pos[i] = cur + 1;
			}
			System.out.printf("Case #%d: ", t);
			for(long p : pos){
				System.out.print(p + " ");
			}
			System.out.println();
		}
		scan.close();
	}
	
	public static void main1(String args[]){
		Scanner scan = new Scanner(System.in);
		int k = 4;
		int c = 3;
		List<String> sequence = generate(k);
		List<String> level = new ArrayList<>();
		for(String s : sequence){
			level.add(s);
		}
		while(c > 1){
			int len = sequence.size();
			List<String> tempLevel = new ArrayList<>();
			for(int i = 0; i < len; ++i){
				String cur = level.get(i);
				String temp = "";
				String gg = "GGGG";
				for(int j = 0; j < cur.length(); ++j){
					if(cur.charAt(j) == 'G'){
						temp += gg;
					}else{
						temp += sequence.get(i);
					}
				}
				tempLevel.add(temp);
			}
			level = tempLevel;
			--c;
		}
		int[] count = new int[(int)Math.pow(k, 6)];
		for(String s : level){
			for(int i = 0; i < s.length();++i){
				if(s.charAt(i) == 'L'){
					count[i]++;
				}
			}
		}
		for(int n : count){
			System.out.print(n + " ");
		}
		System.out.println();
		for(String i : level){
			System.out.println(i);
		}
		scan.close();
	}
	
	public static List<String> generate(int k){
		List<String> result = new ArrayList<>();
		if(k == 1){
			result.add("G");
			result.add("L");
			return result;
		}
		List<String> temp = generate(k - 1);
		for(String s : temp){
			result.add("G" + s);
		}
		for(String s : temp){
			result.add("L" + s);
		}
		return result;
	}
}
