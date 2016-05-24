/**
 * File Name: StringCompression.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:39:50 PM Apr 18, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 8:39:50 PM Apr 18, 2016
 */
public class StringCompression {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		StringCompression sc = new StringCompression();
		while(scan.hasNext()){
			String s = scan.nextLine();
			System.out.println(sc.compression(s));
		}
		
		scan.close();
	}
	public String compression(String original){
		if(original == null || original.length() == 0){
			return "";
		}
		String com = "";
		char pre = original.charAt(0);
		int count = 1;
		for(int i = 1; i < original.length(); ++i){
			if(pre == original.charAt(i)){
				++count;
			}else{
				com += pre + "" + count;
				pre = original.charAt(i);
				count = 1;
			}
		}
		com += pre + "" + count;
		return com.length() > original.length() ? original : com;
	}
	
	public String compression1(String original){
		if(original == null || original.length() == 0){
			return "";
		}
		
		String com = "";
		int len = original.length();
		for(int i = 0; i < len;){
			char pre = original.charAt(i);
			int j = i + 1;
			while(j < len && original.charAt(j) == pre){
				++j;
			}
			com += pre + "" + (j - i);
			i = j;
		}
		
		return com.length() > len ? original : com;
	}
}
