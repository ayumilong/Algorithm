/**
 * File Name: ZigzagConversion.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 7:25:01 PM Aug 28, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

/**
 * @author Yaolin Zhang
 * @time 7:25:01 PM Aug 28, 2015
 */
public class ZigzagConversion {
	//Louise
	public String convert0(String s, int numRows) {
        if(numRows == 1){
        	 return s;
        }
        String aswRows[] = new String[numRows];
        for(int i = 0; i < numRows; i++){
            aswRows[i] = "";
        }
        String convert = "";
    //  System.out.println(convert);
        for(int i = 0; i < s.length(); i++ ){       
            if((i/(numRows - 1)) % 2 == 0){
                aswRows[i - ((numRows - 1) * (int)(i/(numRows - 1)))] += s.charAt(i); 
                //System.out.println(s.charAt(i));
            }else{
                aswRows[(numRows - 1) - (i % (numRows-1))] += s.charAt(i);
                //System.out.println(s.charAt(i));
            }       
        }
    for(int i=0; i< numRows; i++){
        convert += aswRows[i];      
    }
    return convert;
            
    
        
    }
	/*
	 * A  G  N  T
	 * B FH MO S
	 * CE JL PR
	 * D  K  Q
	 * 
	 */
	public String convert(String s, int numRows){
		if(numRows == 1){
			return s;
		}
		String result = "";
		int len = s.length();
		for(int i = 0; i < numRows; ++i){
			int first = (numRows - i - 1) * 2;
			int second = i * 2;
			
			for(int j = i; j < len;){
				result += s.charAt(j);
				if(i != 0 && i != numRows - 1){
					if(j + first < len){
						result += s.charAt(j + first);
					}
				}
				j += first + second;
			}
		}
		return result;
	}
	
	/*
	 * A G M
	 * BFHL
	 * CEIK
	 * D J 
	 * 
	 * A G M
	 * B H N
	 * CFILO
	 * D J P
	 * E K
	 * 
	 */
	public String convertVoid(String s, int numRows) {
		StringBuffer sb = new StringBuffer("");
        if(numRows % 2 == 0){
        		for(int i = 0; i < numRows; ++i){
        			for(int j = i; j < s.length();){
        				sb.append(s.charAt(j));
        				if(i == numRows/2 || i == (numRows/2 - 1)){
        					j += (numRows/2 + 1);
        				}else{
        					j += (numRows + 2);
        				}
        			}
        		}
        }else{
        		for(int i = 0; i < numRows; ++i){
        			for(int j = i; j < s.length();){
        				sb.append(s.charAt(j));
        				if(i == numRows / 2){//The middle row
        					j += (numRows + 1)/2;
        				}else{
        					j += (numRows + 1);
        				}
        			}
        		}
        }
		return sb.toString();
    }
}
