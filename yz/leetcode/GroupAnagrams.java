/**
 * File Name: GroupAnagrams.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 4:08:46 PM Sep 13, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
/**
 * @author Yaolin Zhang
 * @time 4:08:46 PM Sep 13, 2015
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(strs.length == 0){
			return result;
		}
		HashMap<String, List<String>> hm = new HashMap<>();
		for(int i = 0; i < strs.length; ++i){
			char temp[] = strs[i].toCharArray();
			Arrays.sort(temp);
			String cur = new String(temp);
			if(!hm.containsKey(cur)){
				List<String> ls = new ArrayList<>();
				ls.add(strs[i]);
				hm.put(cur, ls);
			}else{
				hm.get(cur).add(strs[i]);
			}
		}
		for(List<String> list : hm.values()){
			list.sort(null);
			result.add(list);
		}
		
		return result;
	}
	
	//O(n2)
    public List<List<String>> groupAnagrams1(String[] strs) {
    		List<List<String>> result = new ArrayList<List<String>>();
    		if(strs.length == 0){
    			return result;
    		}
    		HashMap<Character, Boolean> hm = new HashMap<>();
    		boolean isFound[] = new boolean[strs.length];
    		int count = 0;
    		List<String> temp = new ArrayList<>();
    		for(int i = 0; i < strs.length; ++i){
    			if(!isFound[i]){
    				isFound[i] = true;
    				temp.add(strs[i]);
    				++count;
    				boolean findAll = false;
    				for(int j = 0; j < strs[i].length(); ++j){
    					hm.put(strs[i].charAt(j), true);
    				}
    				for(int j = i + 1; j < strs.length; ++j){
    					if(!isFound[j]){
    						boolean isAnagram = true;
    						for(int k = 0; k < strs[j].length(); ++k){
    							if(!hm.containsKey(strs[j].charAt(k))){
    								isAnagram = false;
    								break;
    							}
    						}
    						if(isAnagram){
    							isFound[j] = true;
    							temp.add(strs[j]);
    							++count;
    							if(count == strs.length){
    								findAll = true;
    								break;
    							}
    						}
    					}
    				}
    				temp.sort(null);
    				result.add(new ArrayList<String>(temp));
    				
    				if(findAll){
    					break;
    				}
    				temp.clear();
    				hm.clear();
    			}
    		}
    		return result;
    }
}
