/**
 * File Name: ParkingLot.java
 * Package Name: yz.oo.design
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:14:40 PM Apr 20, 2016
 * Author: Yaolin Zhang
 */
package yz.oo.design;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:14:40 PM Apr 20, 2016
 */
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
    VehicleSize size;
}

class Motorcycle extends Vehicle {
    // Write your code here
    public Motorcycle(){
        size = VehicleSize.Motorcycle;
    }
}

class Car extends Vehicle {
    // Write your code here
    public Car(){
        size = VehicleSize.Compact;
    }
}

class Bus extends Vehicle {
    // Write your code here
    public Bus(){
        size = VehicleSize.Large;
    }
}

/* Represents a level in a parking garage */
class Level {
    // Write your code here
    private int id;
    private int rows;
    private int spots;
    private boolean[][] grid;
    private HashMap<Vehicle, Position> vehicles;
    
    public Level(int i, int r, int s){
        id = i;
        rows = r;
        spots = s;
        grid = new boolean[rows][spots];
        vehicles = new HashMap<>();
    }
    
    public int getId(){
        return id;
    }
    
    public Position getPosition(Vehicle vehicle){
        if(vehicles.containsKey(vehicle)){
            return vehicles.get(vehicle);
        }
        return null;
    }
    
    public boolean isEmpty(int row, int spot){
        return !grid[row][spot];
    }
    
    public boolean addVehicle(Vehicle vehicle, int row, int spot){
        int count = (vehicle.size == VehicleSize.Large) ? 5 : 1;
        int k = spot;
        while(k < spots && k < spot + count && !grid[row][k]){
            ++k;
        }
        if(k != spot + count){
            return false;
        }
        Position pos = new Position(row, spot);
        vehicles.put(vehicle, pos);
        for(int i = spot; i < spot + count; ++i){
            grid[row][i] = true;
        }
        return true;
    }
    
    public void removeVehicle(Vehicle vehicle){
        Position pos = getPosition(vehicle);
        if(vehicle.size == VehicleSize.Large){
            for(int i = pos.spot; i < pos.spot + 5; ++i){
                grid[pos.row][i] = false;
            }
        }else{
            grid[pos.row][pos.spot] = false;
        }
        vehicles.remove(vehicle);
    }
}

class Position{
    int row;
    int spot;
    
    Position(int r, int s){
        row = r;
        spot = s;
    }
}

public class ParkingLot {
    int n;
    int rows;
    int spots;
    private HashMap<Integer, Level> levels;
    private HashMap<Vehicle, Integer> vehicleToLevel;
    
    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        this.n = n;
        this.rows = num_rows;
        this.spots = spots_per_row;
        levels = new HashMap<>();
        for(int i = 0; i < n; ++i){
            levels.put(i, new Level(i, num_rows, spots_per_row));
        }
        vehicleToLevel = new HashMap<>();
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        if(!vehicleToLevel.containsKey(vehicle)){
            int start = 0;
            if(vehicle.size == VehicleSize.Compact){
                start = spots / 4;
            }
            if(vehicle.size == VehicleSize.Large){
                start = spots / 4 * 3;
            }
            for(Map.Entry<Integer, Level> e : levels.entrySet()){
                Level cur = e.getValue();
                for(int i = 0; i < rows; ++i){ //The for-loop should be moved to Level.addVehicle
                    for(int j = start; j < spots; ++j){
                        if(cur.isEmpty(i, j) && cur.addVehicle(vehicle, i, j)){
                            vehicleToLevel.put(vehicle, cur.getId());
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        if(vehicleToLevel.containsKey(vehicle)){
            Level cur = levels.get(vehicleToLevel.get(vehicle));
            cur.removeVehicle(vehicle);
            vehicleToLevel.remove(vehicle);
        }
    }
}