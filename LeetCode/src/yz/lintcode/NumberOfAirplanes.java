/**
 * File Name: NumberOfAirplanes.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 8:32:58 PM Feb 28, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:32:58 PM Feb 28, 2016
 */
public class NumberOfAirplanes {
    private class Plane{
        public int time;
        public boolean isLanding;
        public Plane(int t, boolean i){
            time = t;
            isLanding = i;
        }
    }
    private class Interval{
    		public int start;
    		public int end;
    		public Interval(int s, int e){
    			start = s;
    			end = e;
    		}
    }
    private LinkedList<Interval> airplanes = new LinkedList<>();
    
    public void run(){
    		airplanes.add(new Interval(1, 10));
    		airplanes.add(new Interval(2,3));
    		airplanes.add(new Interval(5,8));
    		airplanes.add(new Interval(4,7));
    		int count = countOfAirplanes(airplanes);
    		System.out.println(count);
    }
    private static Comparator<Plane> com = new Comparator<Plane>(){

		@Override
		public int compare(Plane o1, Plane o2) {
			// TODO Auto-generated method stub
			return o1.time - o2.time;
		}
    		
    };
    
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        //ayumi_Long
        PriorityQueue<Plane> pq = new PriorityQueue<>(com);
		
		for(int i = 0; i < airplanes.size(); ++i){
		    pq.offer(new Plane(airplanes.get(i).start, false));
		    pq.offer(new Plane(airplanes.get(i).end, true));
		}
		int count = 0;
		int max = 0;
		while(!pq.isEmpty()){
		    Plane p = pq.poll();
		    if(pq.peek().time == p.time){
		    		if(!p.isLanding && pq.peek().isLanding){
		    			pq.poll();
		    			continue;
		    		}
		    }
		    if(p.isLanding){
		        --count;
		    }else{
		        ++count;
		        if(count > max){
		        		max = count;
		        }
		    }
		}
		return max;
    }
}
