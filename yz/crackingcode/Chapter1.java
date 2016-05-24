/**
 * File Name: Chapter11.java
 * Package Name: yz.crackingcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 3:34:44 PM Aug 30, 2015
 * Author: Yaolin Zhang
 */
package yz.crackingcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 3:34:44 PM Aug 30, 2015
 */
public class Chapter1 {
	/*
	 * Question #1
	 * 
	 */
	/*
	 * Use HashMap
	 */
	public boolean isUnique1(String str){
		int len = str.length();
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i = 0; i < len; ++i){
			if(hm.containsKey(str.charAt(i))){
				return false;
			}
			hm.put(str.charAt(i), 1);
		}
		return true;
	}
	
	/*
	 * Assume there are only a-z chars
	 */
	public boolean isUnique2(String str){
		str = str.toLowerCase();
		int len = str.length();
		if(len > 26){
			return false;
		}
		int hm = 0;
		for(int i = 0; i < len; ++i){
			if((hm & (1 << str.charAt(i) - 'a')) != 0){
				return false;
			}
			hm |= (1 << str.charAt(i) - 'a');
		}
		return true;
	}
	
	/*
	 * Assume there are only ASCII characters
	 */
	public boolean isUnique3(String str){
		int len = str.length();
		if(len > 256){
			return false;
		}
		boolean ascii[] = new boolean[256]; //There are 256 ASCII characters
		for(int i = 0; i < len; ++i){
			if(ascii[str.charAt(i)]){
				return false;
			}
			ascii[str.charAt(i)] = true;
		}
		return true;
	}
	
	/*
	 * Question #3
	 */
	/*
	 * Use HashMap
	 */
	public boolean isPermutation(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 != len2){
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < len1; ++i){
			char c = s1.charAt(i);
			if(map.containsKey(c)){
				map.replace(c, map.get(c) + 1);
			}else{
				map.put(c, 1);
			}
		}
		for(int i = 0; i < len2; ++i){
			char c = s2.charAt(i);
			if(map.containsKey(c)){
				int count = map.get(c) - 1;
				if(count < 0){
					return false;
				}
				map.replace(c, count);
			}else{
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Question #4
	 */
	public void replace(char[] str, int len){
		int spaceCount = 0;
		for(int i = 0; i < len; ++i){
			if(str[i] == ' '){
				++spaceCount;
			}
		}
		if(spaceCount != 0){
			int realLen = len + spaceCount * 2;
			str[realLen] = '\0';
			for(int i = len - 1, j = realLen - 1; i >= 0; --i){
				if(str[i] == ' '){
					str[j--] = '0';
					str[j--] = '2';
					str[j--] = '%';
				}else{
					str[j--] = str[i];
				}
			}
		}
	}
	/*
	 * Question #5
	 */ 
	public String compress(String s){
		int len = s.length();
		if(len != 0){
			String result = "";
			char c = s.charAt(0);
			/*
			for(int i = 1; i < len; ++i){
				result += c;
				int count = 1;
				while(i < len && s.charAt(i) == c){
					++count;
					++i;
				}
				result += count;
				if(i == len){
					break;
				}
				c = s.charAt(i);
			}
			*/
			int i = 1;
			int count = 1;
			for(; i < len; ++i){
				if(s.charAt(i) == c){
					++count;
				}else{
					result += c + "" + count;
					count = 1;
					c = s.charAt(i);
				}
			}
			result += c + "" + count; //The last character
			
			if(result.length() > len){
				return s;
			}
			return result;
		}
		return "";
	}
	/*
	 * Question #6
	 */
	public void rotate(int[][] image, int N){ //Rotate to right for 90 degrees
		if(N > 1){
			for(int i = 0; i < N / 2; ++i){
				for(int j = i; j < N - 1 - i; ++j){
					int temp = image[i][j];
					image[i][j] = image[N - j - 1][i]; //Left to top
					image[N - j - 1][i] = image[N - i - 1][N - j - 1]; //Bottom to left
					image[N - i - 1][N - j - 1] = image[j][N - i - 1]; //Right to bottom
					image[j][N - i - 1] = temp; //Top to right
				}
			}
		}
	}
	public void rotate(int[][] matrix) {
        int N = matrix.length;
        if(N > 2){
			for(int i = 0; i < N / 2; ++i){
				for(int j = i; j < N - 1 - i; ++j){
					int temp = matrix[i][j];
					matrix[i][j] = matrix[N - j - 1][i]; //Left to top
					matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1]; //Bottom to left
					matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1]; //Right to bottom
					matrix[j][N - i - 1] = temp; //Top to right
				}
			}
		}
    }
}
