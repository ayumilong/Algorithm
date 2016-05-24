/**
 * File Name: WordLadderII.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:52:18 PM Apr 18, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 9:52:18 PM Apr 18, 2016
 */
public class WordLadderII {

	public static void main(String args[]) {
		Set<String> wordList = new HashSet<>();
		//Scanner scan = new Scanner(System.in);
		//String[] words = scan.nextLine().split(",");
		//for(String w : words){
			//wordList.add(w.substring(1, w.length() - 1));
		//}
		//scan.close();
		 //wordList.add("ted"); wordList.add("tex"); wordList.add("red");
		 //wordList.add("tax"); wordList.add("tad"); wordList.add("den");
		 //wordList.add("rex"); wordList.add("pee");
		 
		wordList.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));

		WordLadderII wl = new WordLadderII();

		List<List<String>> results = wl.findLadders("hit", "cog", wordList);
		System.out.println("Results:");
		for (List<String> ls : results) {
			for (String s : ls) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		HashMap<String, List<String>> graph = new HashMap<>();
		HashMap<String, List<List<String>>> pathes = new HashMap<>();
		List<List<String>> allPath = new ArrayList<>();
		List<String> path = new ArrayList<>();
		path.add(beginWord);
		allPath.add(path);
		pathes.put(beginWord, allPath);
		wordList.add(endWord);
		List<List<String>> results = buildGraph(beginWord, endWord, wordList, graph, pathes);
		/*
		System.out.println(beginWord);
		List<String> child = graph.get(beginWord);
		while (child.size() != 0) {
			List<String> parent = child;
			child = new ArrayList<>();
			for (String s : parent) {
				System.out.print(s + " ");
				List<String> temp = graph.get(s);
				if (temp == null) {
					continue;
				}
				for (String ss : temp) {
					child.add(ss);
				}
			}
			System.out.println();
		}
		*/
		//findPath(endWord, path, results, graph);
		return results;
	}

	//Do not need to really build the Graph but only record all the paths
	public List<List<String>> findPaths(String beginWord, String endWord, Set<String> wordList,
			HashMap<String, List<List<String>>> paths) {
		List<String> level = new ArrayList<>();
		HashSet<String> inGraph = new HashSet<>();
		level.add(beginWord);
		inGraph.add(beginWord);
		boolean find = false;
		while (!level.isEmpty()) {
			List<String> parent = level;
			level = new ArrayList<>();
			for (String s : parent) {
				char[] sh = s.toCharArray();
				List<List<String>> onePath = paths.get(s);
				for (int i = 0; i < sh.length; ++i) {
					char c = sh[i];
					for (char ch = 'a'; ch <= 'z'; ++ch) {
						sh[i] = ch;
						String temp = String.valueOf(sh);
						if (temp.equals(endWord)) {
							find = true;
						}
						if (wordList.contains(temp) && (!inGraph.contains(temp))) {
							List<List<String>> tempPath = new ArrayList<>();
							for(List<String> l : onePath){
								List<String> p = new ArrayList<>(l);
								p.add(temp);
								tempPath.add(p);
							}
							if(paths.containsKey(temp)){
								List<List<String>> ll = paths.get(temp);
								for(List<String> l : tempPath){
									ll.add(l);
								}
							}else{
								paths.put(temp, tempPath);
								level.add(temp);
							}
						}
					}
					sh[i] = c;
				}
			}
			if (find) {
				return paths.get(endWord);
			}
			inGraph.addAll(level);
		}
		return new ArrayList<>();
	}
	
	//BFS to build the graph and find all paths at the same time
	public List<List<String>> buildGraph(String beginWord, String endWord, Set<String> wordList,
			HashMap<String, List<String>> graph, HashMap<String, List<List<String>>> paths) {
		List<String> level = new ArrayList<>();
		HashSet<String> inGraph = new HashSet<>();
		level.add(beginWord);
		inGraph.add(beginWord);
		boolean find = false;
		while (!level.isEmpty()) {
			List<String> parent = level;
			level = new ArrayList<>();
			for (String s : parent) {
				List<String> child = new ArrayList<>();
				char[] sh = s.toCharArray();
				List<List<String>> onePath = paths.get(s);//Get path from parent node
				for (int i = 0; i < sh.length; ++i) {
					char c = sh[i];
					for (char ch = 'a'; ch <= 'z'; ++ch) {
						sh[i] = ch;
						String temp = String.valueOf(sh);
						if (temp.equals(endWord)) {//Find the shortest path
							find = true;
						}
						if (wordList.contains(temp) && (!inGraph.contains(temp))) {
							child.add(temp);
							List<List<String>> tempPath = new ArrayList<>();
							for(List<String> l : onePath){//Need do deep copy
								List<String> p = new ArrayList<>(l);
								p.add(temp);
								tempPath.add(p);
							}
							if(paths.containsKey(temp)){
								List<List<String>> ll = paths.get(temp); //Merge paths
								for(List<String> l : tempPath){
									ll.add(l);
								}
							}else{
								paths.put(temp, tempPath); //Add new paths
								level.add(temp); //Avoid duplicate node
							}
						}
					}
					sh[i] = c;
				}
				graph.put(s, child);
			}
			if (find) {
				return paths.get(endWord);
			}
			inGraph.addAll(level); //All all the nodes in this level to HashSet
		}
		return new ArrayList<>();
	}
	//DFS to find all paths
	private void findPath(String endWord, List<String> path, List<List<String>> results,
			HashMap<String, List<String>> graph) {
		String cur = path.get(path.size() - 1);
		if (cur.equals(endWord)) {
			results.add(new ArrayList<>(path));
			return;
		}
		List<String> child = graph.get(cur);
		if (child == null) {
			return;
		}
		for (String s : child) {
			path.add(s);
			findPath(endWord, path, results, graph);
			path.remove(s);
		}
	}
}
