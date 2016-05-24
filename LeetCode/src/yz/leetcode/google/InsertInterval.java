/**
 * File Name: InsertInterval.java
 * Package Name: yz.leetcode.google
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:50:32 PM May 16, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.google;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 12:50:32 PM May 16, 2016
 */
class Pair implements Comparable<Pair>{
    int val;
    int isStart; //0 is start, 1 is end
    
    Pair(int val, int isStart){
        this.val = val;
        this.isStart = isStart;
    }

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class Interval{
	int start;
	int end;
	
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class InsertInterval {
	//Binary Search, O(n)
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null){
            return new ArrayList<>(intervals);
        }
        List<Interval> result = new ArrayList<>();
        //Add for using when newInterval is the smallest interval
        intervals.add(0, new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE));
        //Add for using when newInterval is the greatest interval
        intervals.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE)); 
        
        int startIndex = binarySearch(intervals, newInterval.start, false);//Start compares to end
        int endIndex = binarySearch(intervals, newInterval.end, true);//End compares to start
        //Insert intervals smaller than newInterval
        for(int i = 1; i < startIndex; ++i){
            result.add(intervals.get(i));
        }
        //endIndex will present the first Interval in intervals that has start greater than newInterval.end
        if(endIndex < intervals.size() && intervals.get(endIndex).start == newInterval.end){
            ++endIndex;
        }
        //Merge
        result.add(new Interval(Math.min(intervals.get(startIndex).start, newInterval.start), Math.max(intervals.get(endIndex - 1).end, newInterval.end)));
        //Insert intervals greater than newInterval
        for(int i = endIndex; i < intervals.size() - 1; ++i){
            result.add(intervals.get(i));
        }
        return result;
    }
    
    private int binarySearch(List<Interval> intervals, int val, boolean isStart){
        int low = 0;
        int high = intervals.size();
        while(low < high){
            int middle = low + (high - low) / 2;
            Interval interval = intervals.get(middle);
            int curVal = interval.end;
            if(isStart){
                curVal = interval.start;
            }
            if(val == curVal){
                return middle;
            }else if(val > curVal){
                low = middle + 1;
            }else{
                high = middle;
            }
        }
        return low;
    }
	//Scan line solution, O(nlgn)
    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null){
            return new ArrayList<>(intervals);
        }
        PriorityQueue<Pair> pairs = new PriorityQueue<>(new Comparator<Pair>(){
           public int compare(Pair p1, Pair p2){
               if(p1.val != p2.val){
                   return p1.val - p2.val;
               }else{
                   return p1.isStart - p2.isStart;
               }
           } 
        });
        List<Interval> result = new ArrayList<>();
        pairs.offer(new Pair(newInterval.start, 0));
        pairs.offer(new Pair(newInterval.end, 1));
        for(Interval interval : intervals){
            pairs.offer(new Pair(interval.start, 0));
            pairs.offer(new Pair(interval.end, 1));
        }
        Pair pre = pairs.poll();
        int startCount = 1;
        int endCount = 0;
        while(!pairs.isEmpty()){
            Pair cur = pairs.poll();
            if(cur.isStart == 0){
                ++startCount;
                continue;
            }
            ++endCount;
            while(!pairs.isEmpty() && pairs.peek().isStart == 1){//Find the last end time
                cur = pairs.poll();
                ++endCount;
            }
            if(startCount == endCount){//Every new merged interval should have same Pairs
                result.add(new Interval(pre.val, cur.val));
                startCount = 1;
                endCount = 0;
                pre = pairs.poll();
            }
        }
        return result;
    }
}
