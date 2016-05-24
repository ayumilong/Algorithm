/**
 * File Name: IntersectionOfStringLists.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:04:37 PM Apr 12, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:04:37 PM Apr 12, 2016
 */
public class IntersectionOfStringLists {
	public static void main(String args[]){
		List<List<String>> strs = new LinkedList<>();
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 3; ++i){
			List<String> temp = new LinkedList<>();
			for(int j = 0; j < 4; ++j){
				temp.add(scan.next());
			}
			strs.add(temp);
		}
		IntersectionOfStringLists iosl = new IntersectionOfStringLists();
		List<String> result = iosl.intersection(strs);
		for(String s : result){
			System.out.println(s);
		}
		scan.close();
	}
	
	public List<String> intersection(List<List<String>> strs){
		List<String> results = new LinkedList<>();
		HashMap<String, Integer> words = new HashMap<>();
		for(List<String> ss : strs){
			HashSet<String> cur = new HashSet<>();
			for(String w : ss){
				if(words.containsKey(w) && cur.add(w)){
					words.put(w, words.get(w) + 1);
				}else{
					words.put(w, 1);
					cur.add(w);
				}
			}
		}
		for(Map.Entry<String, Integer> e : words.entrySet()){
			if(e.getValue() == strs.size()){
				results.add(e.getKey());
			}
		}
		return results;
	}
}
