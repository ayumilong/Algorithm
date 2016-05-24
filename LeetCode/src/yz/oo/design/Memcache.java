/**
 * File Name: Memcache.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:08:42 PM May 18, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:08:42 PM May 18, 2016
 */
public class Memcache {
    HashMap<Integer, int[]> cache;

    public Memcache() {
        // Initialize your data structure here.
        cache = new HashMap<>();
    }

    public int get(int curtTime, int key) {
        // Write your code here
        int[] value = cache.get(key);
        if(value == null || (value[0] != -1 && value[0] < curtTime)){
            return Integer.MAX_VALUE;
        }
        return value[1];
    }

    public void set(int curtTime, int key, int value, int ttl) {
        // Write your code here
        int[] valuePair = cache.get(key);
        if(valuePair == null){
            valuePair = new int[2];
        }
        valuePair[0] = ttl == 0 ? -1 : curtTime + ttl - 1;
        valuePair[1] = value;
        cache.put(key, valuePair);
    }

    public void delete(int curtTime, int key) {
        // Write your code here
        if(cache.get(key) != null){
            cache.remove(key);
        }
    }
    
    public int incr(int curtTime, int key, int delta) {
        // Write your code here
        int[] value = cache.get(key);
        if(value == null || (value[0] != -1 && value[0] < curtTime)){
            return Integer.MAX_VALUE;
        }
        value[1] += delta;
        return value[1];
    }

    public int decr(int curtTime, int key, int delta) {
        // Write your code here
        int[] value = cache.get(key);
        if(value == null || (value[0] != -1 && value[0] < curtTime)){
            return Integer.MAX_VALUE;
        }
        value[1] -= delta;
        return value[1];
    }
}
