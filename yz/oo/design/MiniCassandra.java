/**
 * File Name: MiniCassandra.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:17:00 PM Apr 20, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:17:00 PM Apr 20, 2016
 */
public class MiniCassandra {
	private class Column{
		int key;
		String value;
		Column(int key, String value){
			this.key = key;
			this.value = value;
		}
	}
    HashMap<String, TreeMap<Integer, Column>> database;

    public MiniCassandra() {
        // initialize your data structure here.
        this.database = new HashMap<>();
    }
    
    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return void
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // Write your code here
        TreeMap<Integer, Column> value = database.get(raw_key);
        if(value == null){
            value = new TreeMap<>();
        }
        value.put(column_key, new Column(column_key, column_value));
        database.put(raw_key, value);
    }

    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        // Write your code here
        TreeMap<Integer, Column> value = database.get(raw_key);
        if(value == null){
            return new ArrayList<>();
        }
        return new ArrayList<>(value.subMap(column_start, column_end + 1).values());
    }
}
