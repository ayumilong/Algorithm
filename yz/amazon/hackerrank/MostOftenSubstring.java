/**
 * File Name: MostOftenSubstring.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:35:00 PM Apr 3, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;
import java.time.*;

/**
 * @author Yaolin Zhang
 * @time 9:35:00 PM Apr 3, 2016
 */
public class MostOftenSubstring {
	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		int L = scan.nextInt();
		int M = scan.nextInt();
		scan.nextLine();
		// String str = scan.nextLine();
		String str = "";
		Random rand = new Random();
		System.out.println(LocalTime.now());
		for (int i = 0; i < 1000000; ++i) {
			int cur = rand.nextInt(26);
			str += (char) ('a' + cur);
		}
		//System.out.println(str);
		MostOftenSubstring so = new MostOftenSubstring();
		// for(int len = K; len <= L; ++len){
		HashMap<String, Integer> uniqeStr = new HashMap<>();
		HashMap<Integer, Integer> rabinKarp = new HashMap<>();
		int d = 26;
		int q = 101;
		int h = 1;
		for(int i = 0; i < K - 1; ++i){
			h = (h * d) % q;
		}
		int first = 0;
		for(int i = 0; i < K; ++i){
			first = (d * first + str.charAt(i)) % q;
		}
		rabinKarp.put(first, 1);
		for (int i = 0; i < str.length() - K; ++i) {
			first = (d * (first - str.charAt(i) * h) + str.charAt(i + K)) % q;
			if(first < 0){
				first = first + q;
			}
			if(rabinKarp.containsKey(first)){
				rabinKarp.put(first, rabinKarp.get(first) + 1);
			}else{
				rabinKarp.put(first, 1);
			}
			/*
			String cur = str.substring(i, i + K);
			if(so.uniqeChars(cur) > M){
				continue;
			}
			if(uniqeStr.containsKey(cur)){
				uniqeStr.put(cur, uniqeStr.get(cur) + 1);
			}else{
				uniqeStr.put(cur, 1);
			}
			*/
		}
		// }
		int max = 0;
		for(Integer i : rabinKarp.values()){
			max = max > i ? max : i;
		}
		System.out.println(max);
		scan.close();
		System.out.println(LocalTime.now());
	}

	public int uniqeChars(String s) {
		HashSet<Character> chars = new HashSet<>();
		char[] cs = s.toCharArray();
		for (char c : cs) {
			if (!chars.contains(c)) {
				chars.add(c);
			}
		}
		return chars.size();
	}
}
