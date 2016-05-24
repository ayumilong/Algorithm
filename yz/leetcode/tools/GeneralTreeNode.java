/**
 * File Name: GeneralTreeNode.java
 * Package Name: yz.leetcode.tools
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 8:49:17 PM Apr 12, 2016
 * Author: Yaolin Zhang
 */
package yz.leetcode.tools;

import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 8:49:17 PM Apr 12, 2016
 */
public class GeneralTreeNode {
	public int val;
	public int index;
	public List<GeneralTreeNode> children;
	public GeneralTreeNode(int v, int i){
		val = v;
		index = i;
	}
}
