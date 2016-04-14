/**
 * File Name: CoinJam.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose: Google Code Jam 2016 Qualification Round: C
 * Created Time: 7:03:03 PM Apr 8, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.math.BigInteger;
import java.util.*;


/**
 * @author Yaolin Zhang
 * @time 7:03:03 PM Apr 8, 2016
 */
public class CoinJam {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int N = scan.nextInt();
		int J = scan.nextInt();
		
		String start = "1";
		for(int i = 0; i < N / 2 - 2; ++i){
			start += "0";
		}
		start += "1";
		long[][] divisors = new long[J][9];
		String[] jamcoins = new String[J];
		for(int i = 0; i < J; ++i){
			start = addTwo(start);
			jamcoins[i] = start + start;
			for(int j = 2; j <= 10; ++j){
				divisors[i][j - 2] = Long.parseLong(start, j);
			}
		}
		System.out.printf("Case #%d:\n", T);
		for(int i = 0; i < J; ++i){
			System.out.print(jamcoins[i] + " ");
			for(long d : divisors[i]){
				System.out.print(d + " ");
			}
			System.out.println();
		}
		scan.close();
	}
	public static String addTwo(String s){
		int index = s.length() - 2;
		String zeros = "";
		while(s.charAt(index) == '1'){
			zeros += "0";
			--index;
		}
		return s.substring(0, index) + "1" + zeros + "1";
	}
	
	public static String minusTwo(String s){
		int index = s.length() - 2;
		String ones = "";
		while(index > 0 && s.charAt(index) == '0'){
			ones += "1";
			--index;
		}
		return s.substring(0, index) + "0" + ones + "1";
	}
	
	public static void main1(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int N = scan.nextInt();
		int J = scan.nextInt();
		
		String[] jamcoins = new String[J];
		int index = 0;
		
		String start = "1";
		String end = "1";
		for(int i = 1; i < N - 1; ++i){
			start += "0";
			end += "1";
		}
		start += "1";
		end += "1";
		
		List<List<BigInteger>> divisors = new ArrayList<>();
		BigInteger negativeOne = new BigInteger("-1");
		while(!end.equals(start)){
			List<BigInteger> temp = new ArrayList<>();
			boolean isJamCoin = true;
			for(int i = 2; i <= 10; ++i){
				BigInteger div = findDivisor(new BigInteger(end, i));
				if(div.compareTo(negativeOne) == 0){
					isJamCoin = false;
					break;
				}
				temp.add(div);
			}
			//System.out.println("Add one: " + index);
			if(isJamCoin){
				jamcoins[index++] = end;
				divisors.add(temp);
				if(index == J){
					break;
				}
			}
			//start = addTwo(start);
			end = minusTwo(end);
		}
		System.out.printf("Case #%d:\n", T);
		for(int i = 0; i < J; ++i){
			System.out.print(jamcoins[i] + " ");
			for(BigInteger b : divisors.get(i)){
				System.out.print(b.toString() + " ");
			}
			System.out.println();
		}
		scan.close();
	}
	
	public static BigInteger findDivisor(BigInteger b){
		//System.out.println("DD");
		if(b.isProbablePrime(5)){
			return new BigInteger("-1");
		}
		BigInteger minusOne = b.subtract(BigInteger.ONE);
		if(minusOne.nextProbablePrime().compareTo(b) == 0){
			return new BigInteger("-1");
		}
		BigInteger start = new BigInteger("2");
		BigInteger end = new BigInteger("10000"); //To find small factor
		//BigInteger end = b.divide(start);
		//System.out.println("SS");
		while(start.compareTo(end) < 0){
			BigInteger cur = b.mod(start);
			if(cur.compareTo(BigInteger.ZERO) == 0){
				return start;
			}
			start = start.add(BigInteger.ONE);
			//System.out.println(start.toString() + " " + b.toString() + " " + cur.toString());
		}
		
		return new BigInteger("-1");
	}
}
