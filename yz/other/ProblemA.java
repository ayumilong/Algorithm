/**
 * File Name: ProblemA.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:36:13 AM May 15, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:36:13 AM May 15, 2016
 */
public class ProblemA {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger max = new BigInteger("9973");
		while (scan.hasNext()) {
			int N = scan.nextInt();
			String word = scan.next();
			BigInteger[] hashValues = hash(word);
			for (int i = 0; i < N; ++i) {
				int start = scan.nextInt();
				int end = scan.nextInt();
				System.out.println(hashValues[end].divide(hashValues[start - 1]).mod(max));
			}
		}

		scan.close();
	}

	private static BigInteger[] hash(String str){
		BigInteger[] values = new BigInteger[str.length() + 1];
		values[0] = new BigInteger("1");
		for(int i = 1; i <= str.length(); ++i){
			values[i] = values[i - 1].multiply(new BigInteger((str.charAt(i - 1) - 28) + ""));
		}
		return values;
	}
}
