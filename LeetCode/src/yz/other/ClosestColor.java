/**
 * File Name: ClosestColor.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 9:10:15 PM May 3, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yaolin Zhang
 * @time 9:10:15 PM May 3, 2016
 */
public class ClosestColor {
	private static class ColorPair{
		double distance;
		String color;
		ColorPair(double dis, String c){
			distance = dis;
			color = c;
		}
	}
	public static void findClosestColor(String[] colors){
		for(String color : colors){
			ColorPair[] distances = new ColorPair[5];
			distances[0] = new ColorPair(distance(color, 0, 0, 0), "Black");
			distances[1] = new ColorPair(distance(color, 255, 0, 0), "Red");
			distances[2] = new ColorPair(distance(color, 0, 255, 0), "Green");
			distances[3] = new ColorPair(distance(color, 0, 0, 255), "Blue");
			distances[4] = new ColorPair(distance(color, 255, 255, 255), "White");
			Arrays.sort(distances, new Comparator<ColorPair>(){
				public int compare(ColorPair o1, ColorPair o2) {
					return (int)(o1.distance - o2.distance);
				}
				
			});
			if(distances[0].distance < distances[1].distance){
				System.out.println(distances[0].color);
			}else{
				System.out.println("Ambiguous");
			}
		}
	}
	
	private static double distance(String color, int red, int green, int blue){
		int curRed = Integer.parseInt(color.substring(0, 8), 2);
		int curGreen = Integer.parseInt(color.substring(8, 16), 2);
		int curBlue = Integer.parseInt(color.substring(16, 24), 2);
		return Math.pow(curRed - red, 2) + Math.pow(curGreen - green, 2) + Math.pow(curBlue - blue, 2); 
	}
}
