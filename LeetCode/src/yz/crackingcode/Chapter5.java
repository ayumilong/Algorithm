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
	 int insertMToN1(int m, int n, int i, int j){
		 int count = j - i;
		 while(count >= 0){
			 int mask = ~(1 << (i + count));
			 n = n & mask; //Clear the i + count bit
			 mask = 1 << count;
			 mask = (m & mask) == 0 ? 0 : (1 << (i + count));
			 if(mask != 0){
				 n = n | mask; //Set the i + count bit
			 }
			 --count;
		 }
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
	 int getPrevious(int num){
		 int c0 = 0;
		 int c1 = 0;
		 int c = num;
		 while((c & 1) != 0){
			 ++c1;
			 c >>= 1;
		 }
		 while((c & 1) == 0 && c != 0){
			 ++c0;
			 c >>= 1;
		 }
		 if((c0 + c1) == 31 || (c0 + c1) == 0){
			 return -1;
		 }
		 int p = c0 + c1;
		 num = num & (~0 << (p + 1));
		 //num = num & ~((1 << (p + 1)) - 1);
		 //num = num | (((1 << p) - 1) & ~((1 << (c0 - 1)) - 1));
		 //num = num | (((1 << (c1 + 1)) - 1) << (c0 - 1));
		 num = num | ((1 << (c1 + c0)) - (1 << (c0 - 1)));
		 return num;
	 }
	 
	 int getNext(int num){//num is a positive number
		 int c1 = 0; //The count of ones after non-trailing zeroPos
		 int zeroPos = 0;
		 while(zeroPos < 31){
			 if(((1 << zeroPos) & num) != 0){
				 ++c1;
				 if(((1 << (zeroPos + 1)) & num) == 0){
					 ++zeroPos;
					 break;
				 }
			 }
			 ++zeroPos;
		 }
		 if(zeroPos == 31){
			 return -1; //Invalid 
		 }
		 num = num | (1 << zeroPos); 
		 int mask = ~0 << zeroPos; // mask is 1111...1000.000
		 //int mask = ~((1 << zeroPos) - 1);
		 num = num & mask;
		 mask = (1 << (c1 - 1)) - 1; //mask is 000000....0111...1
		 num = num | mask;
		 return num;
	 }
	 
	 /*
	  * Brute force
	  */
	 int onesCount(int num){
		 int count = 0;
		 int temp = 1;
		 for(int i = 0; i < 32; ++i){
			 if((num & temp) != 0){
				 ++count;
			 }
			 temp = temp << 1;
		 }
		 return count;
	 }
	 
	 void getSmallerAndGreater(int num){
		 int count = onesCount(num);
		 int smaller = num;
		 int smallerCount;
		 do{
			 --smaller;
			 smallerCount = onesCount(smaller);
		 }while(smallerCount != count);
		 System.out.println(smaller);
		 
		 int greater = num;
		 int greaterCount;
		 do{
			 ++greater;
			 greaterCount = onesCount(greater);
		 }while(greaterCount != count);
		 System.out.println(greater);
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











