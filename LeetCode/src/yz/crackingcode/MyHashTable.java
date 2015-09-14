/**
 * File Name: MyHashTable.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 1:19:50 PM Aug 30, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 1:19:50 PM Aug 30, 2015
 */
public class MyHashTable implements Iterable<Integer>{
	private ArrayList<LinkedList<Integer>> table;
    private boolean empty;
    
    public MyHashTable(){
    		table = new ArrayList<>();
    		empty = true;
    }
    
    public boolean isEmpty(){
    		return empty;
    }
    
    public boolean add(int key, int value){
    		empty = false;
    		if(key >= table.size()){//New key
    			int len = table.size();
    			for(int i = len; i <= key; ++i){
    				table.add(new LinkedList<Integer>());
    			}
    		}
    		table.get(key).add(value);
    		return true;
    }
    
    public boolean find(int key, int value){
    		if(key < table.size()){
    			int index = table.get(key).indexOf(value);
    			if(index != -1){
    				return true;
    			}
    		}
    		return false;
    }
    
    public boolean remove(int key, int value){
    		if(key < table.size()){
    			return table.get(key).remove(new Integer(value));
    		}
    		return false;
    }

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
