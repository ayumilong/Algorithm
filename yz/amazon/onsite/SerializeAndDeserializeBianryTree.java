/**
 * File Name: SerializeAndDeserializeBianryTree.java
 * Package Name: yz.amazon.onsite
 * Project Name: Algorithm
 * Purpose:
 * Created Time: 12:24:50 AM Apr 17, 2016
 * Author: Yaolin Zhang
 */
package yz.amazon.onsite;

import java.util.*;
import yz.leetcode.tools.*;

/**
 * @author Yaolin Zhang
 * @time 12:24:50 AM Apr 17, 2016
 */
public class SerializeAndDeserializeBianryTree {
	public static void main(String args[]){
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		SerializeAndDeserializeBianryTree sa = new SerializeAndDeserializeBianryTree();
		String tree = "1 2 3 # # 4 5 # # 6 #";
		TreeNode root = sa.deserialize(tree);
		System.out.println(sa.serialize(root));
	}
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder tree = new StringBuilder("");
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        boolean hasNode = true;
        while(hasNode){
            hasNode = false;
            List<TreeNode> parent = cur;
            cur = new ArrayList<>();
            for(TreeNode t : parent){
                if(t == null){
                    tree.append("# ");
                }else{
                    tree.append(t.val + " ");
                    if(t.left != null || t.right != null){
                        hasNode = true;
                    }
                    cur.add(t.left);
                    cur.add(t.right);
                }
            }
        }
        return tree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] nodes = data.split(" ");
        if(nodes[0].equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        int index = 1;
        while(index < nodes.length){
            List<TreeNode> parent = cur;
            cur = new ArrayList<>();
            for(TreeNode t : parent){
                if(!nodes[index].equals("#")){
                    t.left = new TreeNode(Integer.parseInt(nodes[index]));
                    cur.add(t.left);
                }
                ++index;
                if(!nodes[index].equals("#")){
                    t.right = new TreeNode(Integer.parseInt(nodes[index]));
                    cur.add(t.right);
                }
                ++index;
            }
        }
        return root;
    }
	
	//Use pre-order traversal
    public String serialize2(TreeNode root) {
        if(root == null){
            return "# ";
        }
        StringBuilder tree = new StringBuilder(root.val + " ");
        tree.append(serialize(root.left));
        tree.append(serialize(root.right));
        return tree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] sa = data.split(" ");
        Queue<String> nodes = new LinkedList<>();
        for(String s : sa){
            nodes.offer(s);
        }
        return helper(nodes);
    }
    
    private TreeNode helper(Queue<String> nodes){
        if(nodes.size() == 0){
            return null;
        }
        String sval = nodes.poll();
        if(sval.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(sval));
        root.left = helper(nodes);
        root.right = helper(nodes);
        return root;
    }
    
    //[1,2,3,null,null,4,5] will be 1,0 2,1 3,2 4,3 5,4
    public String serialize1(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder tree = new StringBuilder("");
        List<TreeNode> level = new LinkedList<>();
        level.add(root);
        int index = 0;
        boolean hasNode = true;
        while(hasNode){
            hasNode = false;
            List<TreeNode> parent = level;
            level = new LinkedList<>();
            for(TreeNode n : parent){
                if(n != null){
                    tree.append(n.val + " " + index + " ");
                    level.add(n.left);
                    level.add(n.right);
                    hasNode = true;
                }else{
                    level.add(null);
                    level.add(null);
                }
                ++index;
            }
        }
        return tree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] nodes = data.split(" ");
        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        map.put(0, root);
        for(int i = 2; i < nodes.length; i += 2){
            int val = Integer.parseInt(nodes[i]);
            int index = Integer.parseInt(nodes[i + 1]);
            map.put(index, new TreeNode(val));
            int parent = (index - 1) / 2;
            if(parent * 2 + 1 == index){//Left child
                map.get(parent).left = map.get(index);
            }else{
                map.get(parent).right = map.get(index);
            }
        }
        
        return map.get(0);
    }
}
