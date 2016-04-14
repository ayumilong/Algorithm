/**
 * File Name: StringCombinations.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:54:50 PM Apr 13, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.util.*;

/**
 * @author Yaolin Zhang
 */
public class StringCombinations {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		List<List<String>> strs = new ArrayList<>();
		int levels = scan.nextInt();
		scan.nextLine();
		while (levels > 0) {
			String[] words = scan.nextLine().split(" ");
			List<String> cur = new ArrayList<>();
			for (String w : words) {
				cur.add(w);
			}
			strs.add(cur);
			--levels;
		}
		
		StringCombinations sc = new StringCombinations();
		sc.printCombinations(strs);
		System.out.println();
		
		List<String> results = sc.generateCombinations(strs);
		for(String s : results){
			System.out.println(s);
		}
		scan.close();
	}

	/*
	 * Generate all the combinations with a word from each List<String>
	 */
	public List<String> generateCombinations(List<List<String>> strs) {
		List<String> results = new ArrayList<>();
		if (strs == null || strs.size() == 0) {
			return results;
		}
		results.add("");
		for (List<String> ls : strs) {
			List<String> parent = results;
			results = new ArrayList<>();
			for (String s : parent) {
				HashSet<String> uniqe = new HashSet<>();
				for (String word : ls) {
					if(uniqe.add(word)){
						results.add(s + word + " ");
					}
				}
			}
		}
		return results;
	}

	/*
	 * Generate all the combinations with a word from each List<String> Print
	 * each combination once it is generated
	 */
	public void printCombinations(List<List<String>> strs) {
		if (strs == null || strs.size() == 0) {
			return;
		}
		Stack<String> wordStack = new Stack<>(); // Store the word for current
													// combination
		Stack<Integer> indexStack = new Stack<>(); // Store the according index
													// in the List<String> of
													// the word
		int levels = strs.size();

		wordStack.push(strs.get(0).get(0));// Push the first word in to index
		indexStack.push(0);
		while (!wordStack.isEmpty()) {
			if (wordStack.size() == levels) {
				printCombination(wordStack);// Print the current combination
				List<String> lastLevel = strs.get(levels - 1);// Last
																// List<String>
				int lastLen = lastLevel.size();

				wordStack.pop();
				int index = indexStack.pop() + 1;
				while (index < lastLen) {
					wordStack.push(lastLevel.get(index));
					printCombination(wordStack);
					wordStack.pop();
					++index;
				}
				// If the current level has no next word, we go to previous
				// level
				while (!indexStack.isEmpty() && indexStack.peek() == strs.get(wordStack.size() - 1).size() - 1) {
					indexStack.pop();
					wordStack.pop();
				}
				if (wordStack.isEmpty()) {
					break;
				}
				wordStack.pop();
				index = indexStack.pop() + 1;

				// Push the next word of the current level
				wordStack.push(strs.get(wordStack.size()).get(index));
				indexStack.push(index);
			} else {
				// Push the first word of next level
				wordStack.push(strs.get(wordStack.size()).get(0));
				indexStack.push(0);
			}
		}
	}

	private void printCombination(Stack<String> oneLine) {
		for (String s : oneLine) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
