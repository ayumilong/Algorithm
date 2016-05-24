/**
 * File Name: WordLadder.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:53:17 PM Apr 18, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 9:53:17 PM Apr 18, 2016
 */
public class WordLadder {
	/*
	 * 1. Return 0 if there is no such transformation sequence 
	 * 2. All words have the same length 
	 * 3. All words contain only lower case alphabetic characters
	 */
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Queue<String> level = new LinkedList<>();
		level.offer(beginWord);
		int len = 1;
		while (!level.isEmpty()) {
			++len;
			Queue<String> parent = level;
			level = new LinkedList<>();
			for (String s : parent) {
				char[] sh = s.toCharArray();
				for(int i = 0; i < sh.length; ++i){
					char c = sh[i];
					for(char ch = 'a'; ch <= 'z'; ++ch){
						sh[i] = ch;
						String temp = String.valueOf(sh);
						if(endWord.equals(temp)){
							return len;
						}
						if(wordList.contains(temp)){
							level.offer(temp);
							wordList.remove(temp);
						}
					}
					sh[i] = c;
				}
			}
		}
		return 0;
	}
	public int ladderLength1(String beginWord, String endWord, Set<String> wordList) {
		HashSet<String> st = new HashSet<String>();
		HashSet<String> end = new HashSet<String>();
		st.add(beginWord);
		end.add(endWord);

		return solve(st, end, wordList, 1);
	}

	public int solve(HashSet<String> st, HashSet<String> end, Set<String> wordList, int level) {
		if (st.isEmpty()) {
			return 0;
		}
		if (st.size() > end.size()) { // cut the loop
			return solve(end, st, wordList, level);
		}
		wordList.removeAll(end);
		wordList.removeAll(st);
		
		HashSet<String> set = new HashSet<String>();
		for (String s : st) {
			char[] chars = s.toCharArray();
			for (int i = 0; i < s.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char temp = chars[i];
					chars[i] = ch;
					String word = String.valueOf(chars);
					// found the word in other end(set)
					if (end.contains(word)) {
						return level + 1;
					}
					// if not, add to the next level
					if (wordList.contains(word)) {
						set.add(word);
					}
					chars[i] = temp;
				}
			}
		}
		return solve(set, end, wordList, level + 1);
	}
}
