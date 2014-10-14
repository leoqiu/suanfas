package suanfas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import suanfas.objects.TreeNode;

/**
 * 
 
 Binary Tree Level Order Traversal II
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 
 
 
 
 
 
 
 
 
 * @author leo
 *
 */








public class BinaryTreeLevelOrderTraversalII {

	
	
	
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if(root == null)
    		return res;
    	else {
    		
    		Queue<TreeNode> queue = new LinkedList<TreeNode>();
    		queue.add(root);
    		queue.add(null);
    		
    		while (!queue.isEmpty()) {
    			
    			root = queue.poll();
    			
    			if(root == null) {
    				
    				if(queue.isEmpty())
    					queue.add(null);
    				
    				
    			} else {
    				
    				if(root.left != null)
    					queue.add(root.left);
    				
    				if(root.right != null)
    					queue.add(root.right);
    				
    			}
    			
    			
    			
    		}
    		
    	}
    	
    	
    	
    	return res;
    }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
















































