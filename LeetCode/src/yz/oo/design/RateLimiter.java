/**
 * File Name: RateLimiter.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:14:33 PM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:14:33 PM Apr 23, 2016
 */
public class RateLimiter {
    private HashMap<String, TreeMap<Integer, Integer>> eventCounts = new HashMap<>();
    
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // Write your code here
        int intRate = 0;
        try{
            intRate = Integer.parseInt(rate.substring(0, rate.length() - 2));
        }catch(NumberFormatException e){
            return false;
        }
        char type = rate.charAt(rate.length() - 1);
        int count = 0;
        switch(type){
            case 's':
                count = getCount(event, timestamp, timestamp + 1);
                break;
            case 'm':
                count = getCount(event, timestamp - 59, timestamp + 1);
                break;
            case 'h':
                count = getCount(event, timestamp - 60 * 60 - 1, timestamp + 1);
                break;
            case 'd':
                count = getCount(event, timestamp - 60 * 60 * 24 - 1, timestamp + 1);
                break;
            default:
                return true;
        }
        if(count >= intRate){
            return true;
        }
        if(increment){
            TreeMap<Integer, Integer> counts = eventCounts.get(event);
            if(counts == null){
                counts = new TreeMap<>();
            }
            if(counts.containsKey(timestamp)){
                counts.put(timestamp, counts.get(timestamp) + 1);
            }else{
                counts.put(timestamp, 1);
            }
            eventCounts.put(event, counts);
        }
        return false;
    }
    
    private int getCount(String event, int startTime, int endTime){
        TreeMap<Integer, Integer> counts = eventCounts.get(event);
        if(counts == null){
            return 0;
        }
        SortedMap<Integer, Integer> temp = counts.subMap(startTime, endTime);
        int count = 0;
        for(int i : temp.values()){
            count += i;
        }
        return count;
    }
}
