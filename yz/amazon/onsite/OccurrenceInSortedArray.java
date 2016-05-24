/**
 * File Name: OccurrenceInSortedArray.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:35:15 PM Apr 18, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.Scanner;

/**
 * @author Yaolin Zhang
 * @time 9:35:15 PM Apr 18, 2016
 */
public class OccurrenceInSortedArray {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		OccurrenceInSortedArray os = new OccurrenceInSortedArray();
		while(scan.hasNext()){
			int len = scan.nextInt();
			int target = scan.nextInt();
			int[] num = new int[len];
			for(int i = 0; i < len; ++i){
				num[i] = scan.nextInt();
			}
			System.out.println(os.occurrence(num, target));
		}
		scan.close();
	}
	public int occurrence(int[] num, int target){
		if(num == null || num.length == 0){
			return 0;
		}
		int low = 0;
		int high = num.length;
		boolean find = false;
		while(low < high){
			int middle = low + (high - low) / 2;
			if(num[middle] == target){
				low = middle - 1;
				high = middle;
				find = true;
				break;
			}else if(num[middle] < target){
				low = middle + 1;
			}else{
				high = middle;
			}
		}
		int count = 0;
		if(low == num.length || !find){
			return 0;
		}else{
			while(low >= 0 && num[low] == target){
				++count;
				--low;
			}
			while(high < num.length && num[high] == target){
				++count;
				++high;
			}
		}
		return count;
	}
}
