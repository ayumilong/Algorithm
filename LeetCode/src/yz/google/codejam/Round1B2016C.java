/**
 * File Name: Round1B2016C.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:32:18 PM Apr 30, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.Scanner;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:32:18 PM Apr 30, 2016
 */
public class Round1B2016C {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			int N = scan.nextInt();
			scan.nextLine();
			String[][] topics = new String[N][2];
			for(int i = 0; i < N; ++i){
				topics[i] = scan.nextLine().split(" ");
			}
			int count = fakeNumber(topics);
			System.out.printf("Case #%d: %d\n", t, count);
		}
		scan.close();
	}
	
	private static int fakeNumber(String[][] topics){
		HashMap<String, Integer> first = new HashMap<>();
		HashMap<String, Integer> second = new HashMap<>();
		for(String[] sa : topics){
			if(first.containsKey(sa[0])){
				first.put(sa[0], first.get(sa[0]) + 1);
			}else{
				first.put(sa[0], 1);
			}
			if(second.containsKey(sa[1])){
				second.put(sa[1], second.get(sa[1]) + 1);
			}else{
				second.put(sa[1], 1);
			}
		}
		for(Map.Entry<String, Integer> e : first.entrySet()){
			System.out.println(e.getKey() + " " + e.getValue());
		}
		System.out.println();
		for(Map.Entry<String, Integer> e : second.entrySet()){
			System.out.println(e.getKey() + " " + e.getValue());
		}
		int count = 0;
		for(String[] sa : topics){
			if(first.get(sa[0]) >= 2 && second.get(sa[1]) >= 2){
				first.put(sa[0], first.get(sa[0]) - 1);
				second.put(sa[1], second.get(sa[1]) - 1);
				++count;
			}
		}
		System.out.println();
		for(Map.Entry<String, Integer> e : first.entrySet()){
			System.out.println(e.getKey() + " " + e.getValue());
		}
		System.out.println();
		for(Map.Entry<String, Integer> e : second.entrySet()){
			System.out.println(e.getKey() + " " + e.getValue());
		}
		return count;
	}
}
