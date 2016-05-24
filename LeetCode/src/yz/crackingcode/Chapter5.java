/**
 * File Name: Chapter5.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 4:23:19 PM Nov 26, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

import java.util.ArrayList;

import yz.leetcode.tools.BitInteger;

/**
 * @author Yaolin Zhang
 * @time 4:23:19 PM Nov 26, 2015
 */
public class Chapter5 {
	/*
	 * Question #1
	 */
    public int insert(int N, int M, int i, int j) {
        int mask = ~((1 << (j+1)) - (1 << i));
        M = M << i;
        N = (N & mask) | M;
        return N;       
    }
	int insertMToN(int m, int n, int i, int j){
		int left = (~0) << (j + 1);
		int right = (1 << i) - 1;
		int mask = left | right;
		n = n & mask;
		n = n | (m << i);
		return n;
	}
	 
	 /*
	  * Question #2
	  */
	 void binaryDisplay(double num){
		 if(num > 1 || num < 0){
			 System.out.println("ERROR");
			 return;
		 }
		 String result = ".";
		 double frac = 0.5;
		 while(num > 0){
			 if(result.length() >= 32){
				 System.out.println("ERROR");
				 System.out.println(result);
				 return;
			 }
			 if(num > frac){
				 result += "1";
				 num -= frac;
			 }else{
				 result += "0";
			 }
			 frac /= 2;
		 }
		 System.out.println(result);
	 }
	 void binaryDisplay2(double num){
		 if(num > 1 || num < 0){
			 System.out.println("ERROR");
			 return;
		 }
		 String result = ".";
		 while(num > 0){
			 if(result.length() >= 32){
				 System.out.println("ERROR");
				 System.out.println(result);
				 return;
			 }
			 double temp = 2 * num;
			 if(temp > 1){
				 result += "1";
				 num = temp - 1;
			 }else{
				 result += "0";
				 num = temp;
			 }
		 }
		 System.out.println(result);
	 }
	 void binaryDisplay1(double num){
		 String result = ".";
		 int count = 1;
		 double temp = 0;
		 while(count < 32){
			 temp += 1.0 / (1L << count);
			 if(temp == num){
				 result += "1";
				 System.out.println(result);
				 return;
			 }else if(temp < num){
				 result += "1";
			 }else{
				 result += "0";
				 temp -= 1.0 / (1 << count);
			 }
			 ++count;
		 }
		 System.out.println(result);
		 System.out.println("ERROR");
	 }
	 
	 /*
	  * Question #3
	  */
	 public static int getNext(int n){
		 boolean findOne = false;
		 int oneCount = 0;
		 for(int i = 0; i < 31; ++i){//n is positive integer
			 if((n & (1 << i)) != 0){
				 findOne = true;
				 ++oneCount;
			 }else if(findOne){//101110, i is 4
				 n |= (1 << i);//Set the zero bit to 1: 111110
				 n &= ~0 << i;//Clear all the bits after i: 110000
				 n |= ((1 << (oneCount - 1)) - 1);//110011
				 return n;
			 }
		 }
		 return -1;
	 }
	 
	 public static int getPrevious(int n){
		 int zeroCount = 0;
		 boolean findZero = false;
		 for(int i = 0; i < 31; ++i){
			 if((n & (1 << i)) == 0){
				 findZero = true;
				 ++zeroCount;
			 }else if(findZero){//1001001111, i should be 6
				 n &= ~((1 << (i + 1)) - 1);//Clear to 100000000
				 --zeroCount; //The right part will has one less zero cause we set ith 1 to 0
				 int oneCount = i - zeroCount;
				 int right = (1 << oneCount) - 1;
				 n |= (right << zeroCount);
				 return n;
			 }
		 }
		 return -1;
	 }
	 /*
	  * Question #5
	  */
	 int flipBitsCount(int num1, int num2){
		 int result = 0;
		 int temp = num1 ^ num2;
		 while(temp != 0){
			 ++result;
			 temp = temp & (temp - 1); //Clear the rightmost 1
		 }
		 return result;
	 }
	 
	 /*
	  * Question #6
	  */
	 int swapOddAndEvenBits(int num){
		 int oddMask = 0xAAAAAAAA;
		 int evenMask = 0x55555555;
		 return ((num & oddMask) >> 1) | ((num & evenMask) << 1);
	 }
	 
	 /*
	  * Question #7
	  */
	 int findMissing(ArrayList<BitInteger> nums){
		 int result = 0;
		 for(int i = 0; i < BitInteger.INTEGER_SIZE; ++i){
			 int temp = 0;
			 for(int j = 0; j < nums.size(); ++j){
				 temp ^= nums.get(j).fetch(i);
			 }
			 for(int j = 0; j < nums.size() + 1; ++j){
				 //BitInteger bitTemp = new BitInteger(j);
				 //temp ^= bitTemp.fetch(i);
				 temp ^= (((1 << BitInteger.INTEGER_SIZE - i - 1) & j) == 0 ? 0 : 1);
			 }
			 result = (result << 1) + temp;
		 }
		 return result;
	 }
}











