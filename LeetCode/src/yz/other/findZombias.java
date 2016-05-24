/**
 * File Name: findZombias.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:51:18 PM May 23, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.util.HashSet;

/**
 * @author Yaolin Zhang
 * @time 8:51:18 PM May 23, 2016
 */
public class findZombias {
	public static void main(String[] args){
		String[] zombies = {"1010", "0101", "1010", "0101"};
		System.out.println(findClusters(zombies));
	}
	
	static int findClusters(String[] zombies){
		if(zombies == null || zombies.length == 0){
			return 0;
		}
		int[] fathers = new int[zombies.length];
		for(int i = 0; i < fathers.length; ++i){
			fathers[i] = i;
		}
		for(int i = 0; i < zombies.length; ++i){
			for(int j = 0; j < zombies.length; ++j){
				if(zombies[i].charAt(j) == '1'){
					union(fathers, i, j);
				}
			}
		}
		
		HashSet<Integer> count = new HashSet<>();
		for(int i = 0; i < fathers.length; ++i){
			int root = find(fathers, i);
			count.add(root);
		}
		return count.size();
	}
	
	static int find(int[] fathers, int index) {
		int root = index;
		while(root != fathers[root]){
			root = fathers[root];
		}
		int next = fathers[index];
		while(next != root){
			fathers[index] = root;
			index = next;
			next = fathers[index];
		}
		return root;
	}

	static void union(int[] fathers, int i, int j) {
		int x1 = find(fathers, i);
		int x2 = find(fathers, j);
		if (x1 != x2) {
			fathers[x2] = x1;
		}
	}
}
