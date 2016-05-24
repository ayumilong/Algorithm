/**
 * File Name: SameTree.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 9:43:44 PM Oct 24, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 9:43:44 PM Oct 24, 2015
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		Queue<TreeNode> pNodes = new LinkedList<>();
		Queue<TreeNode> qNodes = new LinkedList<>();
		pNodes.add(p);
		qNodes.add(q);
		while (!pNodes.isEmpty()) {
			TreeNode pCur = pNodes.poll();
			TreeNode qCur = qNodes.poll();
			if (pCur == null && qCur == null) {
				continue;
			}
			if (pCur == null || qCur == null) {
				return false;
			}
			if (pCur.val != qCur.val) {
				return false;
			}
			pNodes.add(pCur.left);
			pNodes.add(pCur.right);
			qNodes.add(qCur.left);
			qNodes.add(qCur.right);
		}

		return true;
	}
}
