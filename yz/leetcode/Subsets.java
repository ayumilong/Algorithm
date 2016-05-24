/**
 * File Name: Subsets.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 5:48:31 PM Dec 5, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 5:48:31 PM Dec 5, 2015
 */
public class Subsets {
	private void subsets(int[] nums, int start, List<Integer> path, List<List<Integer>> results){
		if(start == nums.length){
			results.add(new ArrayList<>(path));
			return;
		}
		path.add(nums[start]);
		subsets(nums, start + 1, path, results);
		path.remove(path.size() - 1);
		subsets(nums, start + 1, path, results);
	}
	
	public List<List<Integer>> subsets(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		subsets(nums, 0, path, results);
		return results;
	}
	public List<List<Integer>> subsets3(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		int len = (1 << nums.length);
		for(int i = 0; i < len; ++i){
			List<Integer> cur = new ArrayList<>();
			int count = 0;
			while(count < nums.length){
				if((i & (1 << count)) != 0){
					cur.add(nums[count]);
				}
				++count;
			}
			results.add(cur);
		}
		return results;
	}
	public List<List<Integer>> subsets2(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		results.add(new ArrayList<>());
		for(int i = 0; i < nums.length; ++i){
			int size = results.size();
			for(int j = 0; j < size; ++j){
				List<Integer> temp = new ArrayList<>(results.get(j));
				temp.add(nums[i]);
				results.add(temp);
			}
		}
		return results;
	}
	
	//Recursion
	public List<List<Integer>> subsets(int[] nums, int start) {
		List<List<Integer>> results = new LinkedList<>();
		if (nums.length != start) {
			LinkedList<Integer> temp = new LinkedList<>();
			temp.add(nums[start]);
			results.add(temp);
			List<List<Integer>> tempResults;
			tempResults = subsets(nums, start + 1);
			for (int j = 0; j < tempResults.size(); ++j) {
				results.add(tempResults.get(j));
				LinkedList<Integer> ll = new LinkedList<>(tempResults.get(j));
				ll.addFirst(nums[start]);
			}
		}
		return results;
	}

	public List<List<Integer>> subsets1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = subsets(nums, 0);
		results.add(new LinkedList<>());
		return results;
	}
}
