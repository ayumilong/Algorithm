/**
 * File Name: TextJustfication.java
 * Package Name: yz.leetcode
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 7:56:02 PM Apr 26, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 7:56:02 PM Apr 26, 2016
 */
public class TextJustfication {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String[] words = new String[scan.nextInt()];
		int len = words.length;
		for(int i = 0; i < len; ++i){
			words[i] = scan.next();
		}
		System.out.print("[");
		for(String w : words){
			System.out.print("\"" + w + "\", ");
		}
		TextJustfication tj = new TextJustfication();
		List<String> result = tj.fullJustify(words, scan.nextInt());
		
		for(String s : result){
			System.out.println(s);
		}
		scan.close();
	}
	
	   public List<String> fullJustify(String[] words, int maxWidth) {
	        List<String> result = new ArrayList<>();
	        if(words == null || words.length == 0){
	            return result;
	        }
	        for(int i = 0; i < words.length;){
	            int len = 0;
	            int curLen = words[i].length();
	            int j = i;
	            int count = 0; //At least "count" number of spaces needed in this sentences
	            while(j < words.length && len + curLen + count <= maxWidth){
	                len += curLen;
	                ++j;
	                ++count;
	                if(j == words.length){
	                    break;
	                }
	                curLen = words[j].length();
	            }
	            int wordCount = j - i;
	            int spaceCount = maxWidth - len;
	            String currentLine = "";
	            if(wordCount == 1){
	                currentLine = words[i];
	                for(j = 0; j < spaceCount; ++j){
	                    currentLine += " ";
	                }
	            }else if(i + wordCount == words.length){//The last line should be processed specially
	                int noneEmptyCount = 0;
	                for(j = i; j < i + wordCount; ++j){
	                    if(words[j].length() == 0){//Skip empty string
	                        continue;
	                    }
	                    currentLine += words[j] + " ";
	                    ++noneEmptyCount;
	                }
	                for(j = 0; j < spaceCount - noneEmptyCount + 1; ++j){
	                    currentLine += " ";
	                }
	                if(currentLine.length() > maxWidth){//For some special cases, we maybe add more spaces
	                    currentLine = currentLine.substring(0, maxWidth);
	                }
	            }else{
	                int processed = 0;
	                for(j = i + wordCount - 1; j >= i; --j){
	                    currentLine = words[j] + currentLine;
	                    int curCount = wordCount - processed - 1;
	                    ++processed;
	                    curCount = curCount == 0 ? 1 : curCount;
	                    int curSpace = spaceCount / curCount;
	                    for(int k = 0; k < curSpace; ++k){
	                        currentLine = " " + currentLine;
	                    }
	                    spaceCount -= curSpace;
	                }
	            }
	            i = i + wordCount;
	            result.add(currentLine);
	        }
	        return result;
	    }
}
