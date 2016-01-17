/**
 * File Name: Woodhigh.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:05:19 PM Jan 14, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 7:05:19 PM Jan 14, 2016
 */
public class WoodCut {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
	
    public int woodCut(int[] L, int k) {
        if(L == null || L.length == 0){
            return 0;
        }
        int maxWood = L[0];
        double sum = L[0] / k;
        for(int i = 1; i < L.length; ++i){
            if(L[i] > maxWood){
                maxWood = L[i];
            }
            sum += L[i] / (double)k;
        }
        maxWood = maxWood > sum ? (int)sum : maxWood;
        int high = maxWood + 1;
        int low = 1;
        while(low < high){
            int middle = low + (high - low) / 2;
            int cutCount = 0;
            for(int i = 0; i < L.length; ++i){
                cutCount += L[i] / middle; //The minimum of middle is 1
                if(cutCount >= k){
                    break;
                }
            }
            if(cutCount >= k){
                low = middle + 1;
            }else{
                high = middle;
            }
        }
        return low - 1;
    }
}
