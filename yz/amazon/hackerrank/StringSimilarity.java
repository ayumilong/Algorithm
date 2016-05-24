/**
 * File Name: StringSimilarity.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:41:23 PM Apr 3, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

/**
 * @author Yaolin Zhang
 * @time 9:41:23 PM Apr 3, 2016
 */
public class StringSimilarity {
    public int[] StringSimilarity(String[] inputs) {
    	int[] results = new int[inputs.length];
        for(int i = 0; i < inputs.length; ++i){
            String cur = inputs[i];
            int len = cur.length();
            int fast = 0;
            int slow = 1;
            int similarity = len;
            while(slow < len){
                int next = slow + 1;
                while(slow < len && cur.charAt(slow) == cur.charAt(fast)){
                    ++slow;
                    ++fast;
                }
                similarity += fast;
                fast = 0;
                slow = next;
            }
            results[i] = similarity;
        }
        return results;
    }
}
