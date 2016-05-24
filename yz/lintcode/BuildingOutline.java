/**
 * File Name: BuildingOutline.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 2:59:44 PM Mar 5, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 2:59:44 PM Mar 5, 2016
 */
public class BuildingOutline {

    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    private class Building{
        int pos;
        int height;
        int start;
        Building(int x, int h, int s){
            pos = x;
            height = h;
            start = s;
        }
    }
    
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        
        if(buildings == null || buildings.length == 0 || buildings[0] == null){
            return results;
        }
        PriorityQueue<Building> pq = new PriorityQueue<>(1, new Comparator<Building>(){
           public int compare(Building b1, Building b2){
               if(b1.pos != b2.pos){
                   return b1.pos - b2.pos;
               }else if(b1.height != b2.height){
                   return b1.height - b2.height;
               }else{
                   return b1.start - b2.start;
               }
           } 
        });
        for(int i = 0; i < buildings.length; ++i){
            pq.offer(new Building(buildings[i][0], buildings[i][2], 0));//Start
            pq.offer(new Building(buildings[i][1], buildings[i][2], 1));//end
        }
        Stack<Building> heights = new Stack<>();
        Building pre = pq.poll();
        heights.push(pre);
        while(!pq.isEmpty()){
            Building cur = pq.poll();
            System.out.println(pre.pos + " " + pre.height + "   " + cur.pos + " " + cur.height);
            ArrayList<Integer> outline = new ArrayList<>();
            if(pre.start == 0){//pre is a start of a building
                if(cur.start == 0){//cur is also a start
                    if(cur.height > pre.height && cur.pos != pre.pos){
                        outline.add(pre.pos);
                        outline.add(cur.pos);
                        outline.add(pre.height);
                        pre = cur;
                    }
                }else{//cur is an end
                    if(pre.height == cur.height){
                        outline.add(pre.pos);
                        outline.add(cur.pos);
                        outline.add(pre.height);
                        pre = cur;
                    }
                }
            }else{//pre is an end
                if(cur.start == 0){//cur is a start of building
                    Building temp = heights.peek();
                    while(!heights.isEmpty() && heights.peek().start == 0){
                        while(heights.peek().start == 1){
                            temp = heights.pop();
                        }
                        if(temp.height == heights.peek().height){
                            temp = heights.pop();
                        }
                    }
                    if(!heights.isEmpty() && heights.peek().height < cur.height){
                        outline.add(pre.pos);
                        outline.add(cur.pos);
                        outline.add(heights.peek().height);
                        pre = cur;
                    }
                }else{//cur is also an end
                    outline.add(pre.pos);
                    outline.add(cur.pos);
                    outline.add(cur.height);
                    pre = cur;
                }
            }
            if(outline.size() != 0){
                results.add(outline);
            }
            heights.push(cur);
        }
        return results;
    }


}
