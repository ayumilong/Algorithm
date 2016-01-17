/**
 * File Name: RepeatedDNASequences.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:50:21 PM Dec 5, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:50:21 PM Dec 5, 2015
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> results = new ArrayList<>();
        if(s.length() < 10){
            return results;
        }
        int dna[] = new int[26];
        dna['A' - 'A'] = 0;
        dna['C' - 'A'] = 1;
        dna['G' - 'A'] = 2;
        dna['T' - 'A'] = 3;
        int sequence = 0;
        for(int i = 0; i < 9; ++i){
            sequence <<= 2;
            sequence |= dna[s.charAt(i) - 'A'];
        }
        HashSet<Integer> ones = new HashSet<>();
        HashSet<Integer> twos = new HashSet<>();
        for(int i = 9; i < s.length(); ++i){
            sequence <<= 2;
            sequence &= 0xFFFFF;
            sequence |= dna[s.charAt(i) - 'A'];
            if(!ones.add(sequence) && twos.add(sequence)){
                results.add(s.substring(i - 9, i + 1));
            }
        }
        return results;
    }
	/*
	 * HashMap
	 */
    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> results = new ArrayList<>();
        HashMap<String, Boolean> hm = new HashMap<>();
        int len = s.length();
        for(int i = 0; i + 10 <= len; ++i){
            String cur = s.substring(i, i + 10);
            if(hm.containsKey(cur)){
                if(hm.get(cur) == false){
                    results.add(cur);
                    hm.replace(cur, true);
                }
            }else{
                hm.put(cur, false);
            }
        }
        return results;
    }
    
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> results = new ArrayList<>();
        HashSet<String> ones = new HashSet<>();
        HashSet<String> twos = new HashSet<>();
        int len = s.length();
        for(int i = 0; i + 10 <= len; ++i){
            String cur = s.substring(i, i + 10);
            if(!ones.add(cur) && twos.add(cur)){
            		results.add(cur);
            }
        }
        return results;
    }
}
