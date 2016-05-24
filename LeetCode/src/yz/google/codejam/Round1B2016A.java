/**
 * File Name: Round1B2016A.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:49:11 AM Apr 30, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 10:49:11 AM Apr 30, 2016
 */
public class Round1B2016A {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			String s = scan.next();
			System.out.printf("Case #%d: %s\n", t, phoneNumber(s));
		}
		scan.close();
	}
	
	private static String[] numStr = {"ZERO", "ONE", "TWO", "THREE",
			"FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"
	};
	
	public static String phoneNumber(String s){
		int[] count = new int[26];
		for(char c : s.toCharArray()){
			count[c - 'A']++;
		}
		String result = "";
		for(int i = 0; i < 10;){
			if(hasNum(count, i)){
				for(char c : numStr[i].toCharArray()){
					count[c - 'A']--;
				}
				int[] newCount = new int[26];
				for(int j = 0; j < 26; ++j){
					newCount[j] = count[j];
				}
				if(isValid(newCount, i)){
					result += i;
				}else{
					for(char c : numStr[i].toCharArray()){
						count[c - 'A']++;
					}
				}
			}else{
				++i;
			}
		}
		return result;
	}
	
	private static boolean isValid(int[] count, int start){
		for(int i = start; i < 10; ++i){
			if(hasNum(count, i)){
				for(char c : numStr[i].toCharArray()){
					count[c - 'A']--;
				}
				int[] newCount = new int[26];
				for(int j = 0; j < 26; ++j){
					newCount[j] = count[j];
				}
				if(!isValid(newCount, i)){
					for(char c : numStr[i].toCharArray()){
						count[c - 'A']++;
					}
				}
			}
		}
		for(int i : count){
			if(i != 0){
				return false;
			}
		}
		return true;
	}
	
	private static boolean hasNum(int[] count, int cur){
		for(char c : numStr[cur].toCharArray()){
			if(count[c - 'A'] < 1){
				return false;
			}
		}
		return true;
	}
}
