/**
 * File Name: BitInteger.java
 * Package Name: yz.leetcode.tools
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 11:01:40 PM Nov 27, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode.tools;

/**
 * @author Yaolin Zhang
 * @time 11:01:40 PM Nov 27, 2015
 */
public class BitInteger {
    public static int INTEGER_SIZE;
    private boolean[] bits;
    public BitInteger() {
            bits = new boolean[INTEGER_SIZE];
    }
    /* Creates a number equal to given value. Takes time proportional 
     * to INTEGER_SIZE. */
    public BitInteger(int value){
            bits = new boolean[INTEGER_SIZE];
            for (int j = 0; j < INTEGER_SIZE; j++){
                    if ((value & 1) == 1) {
                    		bits[INTEGER_SIZE - 1 - j] = true;
                    }else {
                    		bits[INTEGER_SIZE - 1 - j] = false;
                    }
                    value >>= 1;
            }
    }
    
    /** Returns k-th least-significant bit. */ 
    public int fetch(int k){
            if (bits[k]) {
            		return 1;
            }else {
            		return 0;
            }
    }
    
    /** Sets k-th least-significant bit. */
    public void set(int k, int bitValue){
            if (bitValue == 0 ) {
            		bits[k] = false;
            }else{
            		bits[k] = true;
            }
    }
    
    /** Sets k-th least-significant bit. */
    public void set(int k, char bitValue){
            if (bitValue == '0' ) bits[k] = false;
            else bits[k] = true;
    }
    
    /** Sets k-th least-significant bit. */
    public void set(int k, boolean bitValue){
            bits[k] = bitValue;
    }       
    
    public void swapValues(BitInteger number) {
            for (int i = 0; i < INTEGER_SIZE; i++) {
                    int temp = number.fetch(i);
                    number.set(i, this.fetch(i));
                    this.set(i, temp);
            }
    }
            
    public int toInt() {
            int number = 0;
            for (int j = INTEGER_SIZE - 1; j >= 0; j--){
                    number = number | fetch(j);
                    if (j > 0) {
                            number = number << 1;
                    }
            }
            return number;
    }
}
