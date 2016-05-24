/**
 * File Name: PopulestItem.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 3:06:07 PM Apr 3, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 3:06:07 PM Apr 3, 2016
 */
public class PopulestVendor {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		scan.nextLine();
		String[][] vendors = new String[cases][];
		for(int i = 0; i < cases; ++i){
			String cur = scan.nextLine();
			vendors[i] = cur.split(",");
		}
		PopulestVendor pi = new PopulestVendor();
		List<String> results = pi.getVendors(vendors);
		for(String s : results){
			System.out.println(s);
		}
		scan.close();
	}
	
	public List<String> getVendors(String[][] vendors){		
		HashMap<String, Integer> counts = new HashMap<>();
		for(String[] items : vendors){
			for(int i = 1; i < items.length; ++i){
				if(counts.containsKey(items[i])){
					counts.put(items[i], counts.get(items[i]) + 1);
				}else{
					counts.put(items[i], 1);
				}
			}
		}
		
		int[] duplicates = new int[vendors.length];
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(String[] items : vendors){
			int cur = 0;
			for(int i = 1; i < items.length; ++i){
				if(counts.get(items[i]) > 1){
					++cur;
				}
			}
			max = max > cur ? max : cur;
			duplicates[index++] = cur;
		}
		List<String> results = new LinkedList<>();
		for(int i = 0; i < duplicates.length; ++i){
			if(duplicates[i] == max){
				results.add(vendors[i][0]);
			}
		}
		return results;
	}
}
