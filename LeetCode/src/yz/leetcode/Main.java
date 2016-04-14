/**
 * File Name: Main.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose: Start point of the application
 * Created Time: 9:53:36 PM Aug 18, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

import yz.leetcode.tools.*;
import yz.crackingcode.*;

/**
 * @author Yaolin Zhang
 * @time 9:53:36 PM Aug 18, 2015
 */

public class Main {
	public static double myPow(double x, int n) {
		System.out.println(x);
	    
	    if (n == 0) {
	        return 1;
	    }

	    int nSign = n < 0 ? -1 : 1;
	    n = Math.abs(n);

	    double result = myPow(x, n / 2);
	    result *= result;
	    if (n % 2 != 0) {
	        result *= x;
	    }

	    return nSign < 0 ? 1 / result : result;
	}
	
	public static void main(String args[]) {
		System.out.println("Please input something: ");
		Scanner sc = new Scanner(System.in);
		
		ValidPalindrome vp = new ValidPalindrome();
		
		Set<String> dict = new HashSet<>();
		for(String s : dict){
			
		}
		while(sc.hasNext()){
			System.out.println(vp.isPalindrome(sc.nextLine()));	
		}
		
		sc.close();
	}
}
