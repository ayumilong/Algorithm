/**
 * File Name: TrieTree.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:10:12 PM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:10:12 PM Apr 23, 2016
 */
public class TrieNode {
	   // Initialize your data structure here.
    private char c;
    public boolean isWord;
    private HashMap<Character, TrieNode> children;
        
    public TrieNode(char v, boolean word){
        c = v;
        isWord = word;
        children = new HashMap<>();
    }
        
    public TrieNode(){
        c = '$';
        isWord = false;
        children = new HashMap<>();
    }
    
    
    public void insert(String word, int index){
        if(word == null || word.length() == index){
            isWord = true;
            return;
        }
        char cur = word.charAt(index);
        if(!children.containsKey(cur)){
            children.put(cur, new TrieNode(cur, false));
        }
        children.get(cur).insert(word, index + 1);
    }
    
    public TrieNode find(String word, int index){
        if(word == null || word.length() == index){
            return this;
        }
        char cur = word.charAt(index);
        if(children.containsKey(cur)){
            return children.get(cur).find(word, index + 1);
        }
        return null;
    }
}

/*
class TrieNode {
    // Initialize your data structure here.
    private char c;
    public boolean isWord;
    private TrieNode[] children = new TrieNode[26];
        
    public TrieNode(char v, boolean word){
        c = v;
        isWord = word;
    }
        
    public TrieNode(){
        c = '$';
        isWord = false;
    }
    
    public void insert(String word, int index){
        if(word == null || index == word.length()){
            isWord = true;
            return;
        }
        int childIndex = word.charAt(index) - 'a';
        if(children[childIndex] == null){
            children[childIndex] = new TrieNode(word.charAt(index), false);
        }
        children[childIndex].insert(word, index + 1);
    }
    
    public TrieNode find(String word, int index){
        if(word == null || index == word.length()){
            return this;
        }
        int childIndex = word.charAt(index) - 'a';
        if(children[childIndex] == null){
            return null;
        }
        return children[childIndex].find(word, index + 1);
    }
}
*/
