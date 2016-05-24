/**
 * File Name: WebLogger.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:13:36 PM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:13:36 PM Apr 23, 2016
 */
public class WebLogger {
    TreeMap<Integer, Integer> log;

    public WebLogger() {
        // initialize your data structure here.
        log = new TreeMap<>();
    }

    /**
     * @param timestamp an integer
     * @return void
     */
    public void hit(int timestamp) {
        // Write your code here
        if(!log.containsKey(timestamp)){
            log.put(timestamp, 1);
        }else{
            log.put(timestamp, log.get(timestamp) + 1);
        }
    }

    /**
     * @param timestamp an integer
     * @return an integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // Write your code here
        SortedMap<Integer, Integer> temp = log.subMap(timestamp - 299, timestamp + 1);
        int count = 0;
        for(Integer i : temp.values()){
            count += i;
        }
        return count;
    }
}
