/**
 * File Name: AlientDictionary.java
 * Package Name: yz.leetcode.google
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 10:11:37 PM May 16, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.google;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:11:37 PM May 16, 2016
 */
class GraphNode{
    int inDegree;
    char c;
    List<GraphNode> children;
    
    GraphNode(int in, char c){
        this.inDegree = in;
        this.c = c;
        this.children = new ArrayList<>();
    }
}

public class AlientDictionary {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }
        HashMap<Character, GraphNode> graph = buildGraph(words);
        
        String result = "";
        Queue<GraphNode> bfs = new LinkedList<>();
        for(GraphNode gn : graph.values()){
            if(gn.inDegree == 0){
                bfs.offer(gn);
            }
        }
        while(!bfs.isEmpty()){//Toplogical sort
            GraphNode cur = bfs.poll();
            for(GraphNode gn : cur.children){
                gn.inDegree--;
                if(gn.inDegree == 0){
                    bfs.offer(gn);
                }
            }
            result += cur.c;
        }
        if(result.length() == graph.size()){
            return result;
        }
        return "";
    }
    
    private HashMap<Character, GraphNode> buildGraph(String[] words){
        String pre = words[0];
        HashMap<Character, GraphNode> nodes = new HashMap<>();
        for(String w : words){//Create each node
            for(char c : w.toCharArray()){
                if(nodes.get(c) == null){
                    nodes.put(c, new GraphNode(0, c));
                }
            }
        }
        for(int i = 1; i < words.length; ++i){
            String cur = words[i];
            int j = 0;
            //Find an edge
            while(j < pre.length() && j < cur.length() && pre.charAt(j) == cur.charAt(j)){
                ++j;
            }
            if(j == pre.length() || j == cur.length()){
                pre = cur;
                continue;
            }
            //Add a edge
            nodes.get(pre.charAt(j)).children.add(nodes.get(cur.charAt(j)));
            nodes.get(cur.charAt(j)).inDegree++;
            pre = cur;
        }
        return nodes;
    }
}
