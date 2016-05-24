/**
 * File Name: TrieTree.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:12:04 PM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

/**
 * @author Yaolin Zhang
 * @time 12:12:04 PM Apr 23, 2016
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode last = root.find(word, 0);
        return last != null && last.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode last = root.find(prefix, 0);
        return last != null;
    }
}