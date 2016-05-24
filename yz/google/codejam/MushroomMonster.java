/**
 * File Name: MushroomMonster.java
 * Package Name: yz.google.codejam
 * Project Name: Algorithm
 * Purpose: Google Code Jam 2015 Round 1A: A
 * Created Time: 1:30:41 PM Apr 9, 2016
 * Author: Yaolin Zhang
 */
package yz.google.codejam;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 1:30:41 PM Apr 9, 2016
 */
public class MushroomMonster {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 1; t <= T; ++t){
			int N = scan.nextInt();
			int[] mushrooms = new int[N];
			int firstCase = 0;
			int maxSpeed = 0;
			mushrooms[0] = scan.nextInt();
			for(int i = 1; i < N; ++i){
				mushrooms[i] = scan.nextInt();
				int sub = mushrooms[i - 1] - mushrooms[i];
				maxSpeed = maxSpeed > sub ? maxSpeed : sub;
				if(sub > 0){
					firstCase += sub;
				}
			}
			int secondCase = 0;
			for(int i = 0; i < N - 1; ++i){
				if(mushrooms[i] >= maxSpeed){
					secondCase += maxSpeed;
				}else{
					secondCase += mushrooms[i];
				}
			}
			System.out.printf("Case #%d: %d %d\n", t, firstCase, secondCase);
		}
		
		scan.close();
	}
}
