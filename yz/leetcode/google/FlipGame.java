/**
 * File Name: FlipGame.java
 * Package Name: yz.leetcode.google
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 6:39:58 PM May 15, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.google;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 6:39:58 PM May 15, 2016
 */
public class FlipGame {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String gameStr = scan.nextLine();
		}

		scan.close();
	}
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.length() == 0){
            return results;
        }
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length - 1; ++i){
            if(cs[i] == '+' && cs[i + 1] == '+'){
                cs[i] = '-';
                cs[i + 1] = '-';
                results.add(String.valueOf(cs));
                cs[i] = '+';
                cs[i + 1] = '+';
            }
        }
        return results;
    }
    
    //Backtracking
    public static boolean canWin(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length - 1; ++i){
            if(cs[i] == '+' && cs[i + 1] == '+'){
                cs[i] = '-';
                cs[i + 1] = '-';
                if(!canWin(String.valueOf(cs))){
                    return true;
                }
                cs[i] = '+';
                cs[i + 1] = '+';
            }
        }
        return false;
    }
    
    //Backtracking with memorization
    public boolean canWin1(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        return helper(s, new HashMap<String, Boolean>());
    }
    
    private boolean helper(String s, HashMap<String, Boolean> winHash){
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length - 1; ++i){
            if(cs[i] == '+' && cs[i + 1] == '+'){
                cs[i] = '-';
                cs[i + 1] = '-';
                String cur = String.valueOf(cs);
                if(winHash.get(cur) == null){
                    winHash.put(cur, helper(cur, winHash));
                }
                if(!winHash.get(cur)){
                    return true;
                }
                cs[i] = '+';
                cs[i + 1] = '+';
            }
        }
        return false;
    } 
}
