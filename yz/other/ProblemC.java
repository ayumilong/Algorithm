/**
 * File Name: ProblemC.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 1:39:42 AM May 15, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 1:39:42 AM May 15, 2016
 */
public class ProblemC {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		TreeSet<String> dict = new TreeSet<String>();
		for(int i = 0; i < N; ++i){
			String op = scan.next();
			if(op.equals("size")){
				System.out.println("size: " + dict.size());
				for(String s : dict){
					System.out.print(s + " ");
				}
				System.out.println();
				continue;
			}
			String word = scan.next().toLowerCase();
			if(op.equals("insert")){
				dict.add(word);
			}else if(op.equals("search")){
				String first = dict.ceiling(word);
				if(first == null || !first.contains(word)){
					System.out.println("No");
				}else{
					System.out.println("Yes");
				}
			}else if(op.equals("delete")){
				String original = word;
				word = dict.ceiling(word);
				while(word != null && word.contains(original)){
					dict.remove(word);
					word = dict.ceiling(word);
				}
			}
		}
		
		scan.close();
	}
}
