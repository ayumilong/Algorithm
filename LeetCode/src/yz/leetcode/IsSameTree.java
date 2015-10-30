/**
 * File Name: isSameTree.java
 * Package Name: yz.leetcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 10:35:55 PM Oct 25, 2015
 * Author: Yaolin Zhang
 */
package yz.leetcode;

import yz.crackingcode.TreeNode;
import java.util.*;

/**
 * @author Yaolin Zhang
 * @time 10:35:55 PM Oct 25, 2015
 */
public class IsSameTree {
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
			if (pCur == null || qCur == null || pCur.val != qCur.val) {
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
