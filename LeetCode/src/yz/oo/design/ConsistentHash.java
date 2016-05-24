/**
 * File Name: ConsistentHash.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:15:48 PM Apr 20, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:15:48 PM Apr 20, 2016
 */
public class ConsistentHash {
    private int n;
    private int k;
    private HashMap<Integer, List<Integer>> machines;
    private HashMap<Integer, Integer> shardsToMachine;

    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    public static ConsistentHash create(int n, int k) {
        // Write your code here
        return new ConsistentHash(n, k);
    }
    
    public ConsistentHash(int n, int k){
        this.n = n;
        this.k = k;
        machines = new HashMap<>();
        shardsToMachine = new HashMap<>();
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        if(machines.containsKey(machine_id)){
            return machines.get(machine_id);
        }else{
            Random rnd = new Random();
            List<Integer> shards = new ArrayList<>();
            for(int i = 0; i < k; ++i){
                int r = rnd.nextInt(n);
                while(shardsToMachine.containsKey(r)){
                    r = rnd.nextInt(n);
                }
                shards.add(r);
                shardsToMachine.put(r, machine_id);
            }
            machines.put(machine_id, shards);
            return shards;
        }
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        for(int i = hashcode; i < n; ++i){
            if(shardsToMachine.containsKey(i)){
                return shardsToMachine.get(i);
            }
        }
        for(int i = 0; i < hashcode; ++i){
            if(shardsToMachine.containsKey(i)){
                return shardsToMachine.get(i);
            }
        }
        return -1;
    }
}
