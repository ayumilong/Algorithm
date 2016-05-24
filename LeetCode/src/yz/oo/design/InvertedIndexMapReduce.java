/**
 * File Name: InvertedIndexMapReduce.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:24:00 PM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:24:00 PM Apr 23, 2016
 */
public class InvertedIndexMapReduce {
	private class OutputCollector<K, V>{
		public void collect(K key, V value){
			//Adds a key/value pair to the output buffer
		}
	}
	
	private class Document{
		int id;
		String content;
	}
	
    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] words = value.content.split(" ");
            Arrays.sort(words);
            String pre = "";
            for(String word : words){
                if(pre.equals(word)){
                    continue;
                }
                pre = word;
                output.collect(word, value.id);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> value = new ArrayList<>();
            while(values.hasNext()){
                value.add(values.next());
            }
            output.collect(key, value);
        }
    }
}
