/**
 * File Name: StandingOvation.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose: Google Code Jam 2015 Qualification Round: A
 * Created Time: 7:59:54 PM Apr 7, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:59:54 PM Apr 7, 2016
 */
public class StandingOvation {
		public static void main(String args[]){
			Scanner scan = new Scanner(System.in);
			int T = scan.nextInt();
			for(int t = 1; t <= T; ++t){
				int maxShyness = scan.nextInt();
				String s = scan.nextLine().trim();
				int len = s.length();
				int standUp = 0; //How many audiences stand up
				int friends = 0; //Add how many friends
				for(int i = 0; i < len; ++i){
					int cur = s.charAt(i) - '0';
					if(cur == 0){
						continue;
					}
					if(standUp < i){
						friends += (i - standUp);
						standUp = i;
					}
					standUp += cur;
				}
				System.out.println("Case #" + t + ": " + friends);
			}
			scan.close();
		}
}
