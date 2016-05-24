/**
 * File Name: LongestWordPath.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:01:33 PM May 19, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:01:33 PM May 19, 2016
 */
public class LongestWordPath {
	public static void main(String[] args){
		String[] words = {"q", ""};
		System.out.println(wordPath(words).toString());
	}
	
	public static List<String> wordPath(String[] words){
		if(words == null || words.length == 0){
			return new ArrayList<>();
		}
		HashMap<String, String> dict = new HashMap<>();
		for(String s : words){
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			dict.put(String.valueOf(temp), s);
		}
		HashMap<String, List<String>> path = new HashMap<>();
		List<String> maxPath = new ArrayList<>();
		for(String start : dict.keySet()){
			List<String> temp = helper(start, path, dict);
			if(maxPath.size() < temp.size()){
				maxPath = temp;
			}
		}
		return maxPath;
	}
	
	private static List<String> helper(String start, HashMap<String, List<String>> path, HashMap<String, String> dict){
		if(path.containsKey(start)){
			return path.get(start);
		}
		List<String> maxPath = new ArrayList<>();
		for(int i = 0; i < start.length(); ++i){
			String cur = start.substring(0, i) + start.substring(i + 1);
			if(dict.containsKey(cur)){
				List<String> temp = helper(cur, path, dict);
				if(maxPath.size() < temp.size()){
					maxPath = temp;
				}
			}
		}
		List<String> result = new ArrayList<>();
		result.add(dict.get(start));
		for(String s : maxPath){
			result.add(s);
		}
		path.put(start, result);
		return result;
	}
}
