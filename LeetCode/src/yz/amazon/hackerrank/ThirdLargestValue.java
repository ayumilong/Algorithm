/**
 * File Name: ThirdLargestValue.java
 * Package Name: yz.amazon.hackerrank
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:58:12 PM Apr 4, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.hackerrank;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:58:12 PM Apr 4, 2016
 */
public class ThirdLargestValue {
	public static void main(String args[]){
		
	}
	
    public int ThirdLargest(int[] arr) {
        int[] max = new int[3];
        max[0] = arr[0];
        max[1] = arr[1];
        max[2] = arr[2];
        Arrays.sort(max); //This is O(3) time which means O(1)
        
        for(int i = 3; i < arr.length; ++i){
            if(arr[i] <= max[0]){
                continue;
            }
            max[0] = arr[i];
            if(max[0] > max[1]){
                swap(max, 0, 1);
            }
            if(max[1] > max[2]){
                swap(max, 1, 2);
            }
        }
        return max[0];
    }
    
    private void swap(int[] max, int i, int j){
        int temp = max[i];
        max[i] = max[j];
        max[j] = temp;
    }
}
