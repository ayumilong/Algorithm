/**
 * File Name: FindPath.java
 * Package Name: yz.other
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 2:07:26 AM Apr 23, 2016
 * Author: Yaolin Zhang
 */
package yz.other;

/**
 * @author Yaolin Zhang
 * @time 2:07:26 AM Apr 23, 2016
 */
public class FindPath {
	  public static void main(String args[]){
		    String[] strs = {".........", ".........", ".........", ".........", ".........", "........."};
		    System.out.println(Integer.toBinaryString(8388608));
		    System.out.println(Integer.toBinaryString(65536));
		    
		    System.out.println(Integer.toBinaryString(128));
		    System.out.println(Integer.toBinaryString(131072));
		    
		    System.out.println(Integer.toBinaryString(-1963139005));
		    System.out.println(Integer.toBinaryString(120168));
		    
		    System.out.println(Integer.toBinaryString(305419896));
		    System.out.println(Integer.toBinaryString(48704));
		    
		    System.out.println(7 * 26 * 26 + 7 * 26 + 7);
		    
		    System.out.println(Puzzle1((byte)64));
		  }
	  public static Boolean Puzzle1(byte n) {
	        int count = 0;
	        for(int i = 0; i < 8; ++i){
	            if((n & (1 << i)) == 0){
	                ++count;
	            }
	        }
	        return count % 2 != 0;
	    }
		  
		  // (r1,c1) and (r2,c2) are pairs of x-y coordinates
		    public static String Puzzle(int r1, int c1, int r2, int c2, String[] strs) {
		        int rows = strs.length;
		        int cols = strs[0].length();
		        int steps = dfs(r1, c1, r2, c2, strs);
		        return (steps == -1) ? "No path found!" : (steps + "");
		    }
		    
		    private static int dfs(int x1, int y1, int x2, int y2, String[] strs){
		        if(x1 == x2 && y1 == y2){
		            return 0;
		        }
		        strs[x1] = strs[x1].substring(0, y1) + '#' + strs[x1].substring(y1 + 1);
		      System.out.println(x1 + " " + y1);
		      for(String s : strs){
		        System.out.println(s);
		      }
		        int[] dx = {0, 1, -1, 0};
		        int[] dy = {1, 0, 0, -1};
		        int min = Integer.MAX_VALUE;
		        for(int i = 0; i < 4; ++i){
		            int newX = dx[i] + x1;
		            int newY = dy[i] + y1;
		            if(newX < 0 || newX >= strs.length || newY < 0 || newY >= strs[0].length()){
		                continue;
		            }
		            if(strs[newX].charAt(newY) == '.'){
		                int curSteps = dfs(newX, newY, x2, y2, strs);
		                if(curSteps != -1 && curSteps < min){
		                    min = curSteps;
		                }
		                if(min != Integer.MAX_VALUE){
		                		return min + 1;
		                }
		            }
		        }
		        strs[x1] = strs[x1].substring(0, y1) + '.' + strs[x1].substring(y1 + 1);
		        min = min == Integer.MAX_VALUE ? -1 : min + 1;
		        System.out.println(min);
		        return min;
		    }
}
