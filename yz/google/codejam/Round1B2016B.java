/**
 * File Name: Round1B2016B.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 11:44:56 AM Apr 30, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 11:44:56 AM Apr 30, 2016
 */
public class Round1B2016B {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			String s1 = scan.next();
			String s2 = scan.next();
			String[] result = helper(s1, s2);
			System.out.printf("Case #%d: %s %s\n", t, result[0], result[1]);
		}
		scan.close();
	}
	
	private static String[] helper(String s1, String s2){
		String[] results = new String[2];
		results[0] = "";
		results[1] = "";
		int status = 0; //0 is equal, 1 is s1 large, 2 is s2 large
		for(int i = 0; i < s1.length(); ++i){
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);

			if(status == 0 && c1 != '?' && c2 != '?' && c1 != c2){
				if(c1 < c2){
					status = 2;
				}else{
					status = 1;
				}
			}
			if(status == 0){
				if(c1 == '?' && c2 == '?'){
					if(i != s1.length() - 1){
						char next1 = s1.charAt(i + 1);
						char next2 = s2.charAt(i + 1);
						if(next1 != '?' && next2 != '?'){
						if(next1 - next2 > 5){
							results[0] +='0';
							results[1] +='1';
							status = 2;
						}else if(next2 - next1 > 5){
							results[0] += '1';
							results[1] += '0';
							status = 1;
						}else{
							results[0] += '0';
							results[1] += '0';
						}
						}else{
							results[0] += '0';
							results[1] += '0';
						}
					}else{
						results[0] += '0';
						results[1] += '0';
					}
				}else if(c1 == '?'){
					if(i != s1.length() - 1){
						char next1 = s1.charAt(i + 1);
						char next2 = s2.charAt(i + 1);
						if(next1 != '?' && next2 != '?'){
						if(next1 - next2 > 5){
							results[0] +='0';
							results[1] +='1';
							status = 2;
						}else if(next2 - next1 > 5){
							results[0] += '1';
							results[1] += '0';
							status = 1;
						}else{
							results[0] += '0';
							results[1] += '0';
						}
						}else{
							results[0] += '0';
							results[1] += '0';
						}
					}else{
						results[0] += c2;
						results[1] += c2;
					}
				}else{
					results[0] += c1;
					results[1] += c1;
				}
			}else if(status == 1){//s1 is large
				if(c1 == '?'){
					results[0] += '0';
				}else{
					results[0] += c1;
				}
				if(c2 == '?'){
					results[1] += '9';
				}else{
					results[1] += c2;
				}
			}else if(status == 2){
				if(c1 == '?'){
					results[0] += '9';
				}else{
					results[0] += c1;
				}
				if(c2 == '?'){
					results[1] += '0';
				}else{
					results[1] += c2;
				}
			}
		}
		return results;
	}
}
