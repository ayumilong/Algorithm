/**
 * File Name: ProblemD.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 2:19:56 AM May 15, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 2:19:56 AM May 15, 2016
 */
public class ProblemD {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		HashMap<String, Integer> names = new HashMap<String, Integer>();
		for(int i = 0; i < N; ++i){
			char[] name = scan.next().toCharArray();
			Arrays.sort(name);
			String nameStr = String.valueOf(name).toLowerCase();
			if(names.containsKey(nameStr)){
				int preCount = names.get(nameStr);
				System.out.println(preCount);
				names.put(nameStr, preCount + 1);
			}else{
				System.out.println(0);
				names.put(nameStr, 1);
			}
		}
		
		scan.close();
	}
}
