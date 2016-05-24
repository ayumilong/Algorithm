/**
 * File Name: InvertedIndex.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:16:10 PM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:16:10 PM Apr 23, 2016
 */
public class InvertedIndex {
	private class Document{
		int id;
		String content;
	}
	
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> results = new HashMap<>();
        for(Document d : docs){
            String[] words = d.content.split(" ");
            Arrays.sort(words);
            String pre = "";
            for(String word : words){
                if(word.equals(pre)){
                    continue;
                }
                pre = word;
                List<Integer> list = results.get(word);
                if(list == null){
                    list = new ArrayList<>();
                }
                list.add(d.id);
                results.put(word, list);
            }
        }
        return results;
    }
}
