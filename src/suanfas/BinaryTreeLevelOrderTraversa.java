package suanfas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import suanfas.objects.TreeNode;

public class BinaryTreeLevelOrderTraversa {

	
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>(); 
    	
    	if(root == null)
    		return res;
    	else {
    		
    		Queue<TreeNode> queue = new LinkedList<TreeNode>();
    		queue.add(root);
    		queue.add(null); //separator
    		
    		List<TreeNode> list = new ArrayList<TreeNode>(); 
    		
    		while (!queue.isEmpty()) {
    			
    			root = queue.poll();
    			
    			if(root == null) {
    				
    				if(!queue.isEmpty())
    					queue.add(null); //add a separator
    				
    				List<Integer> li = new ArrayList<Integer>();
    				for (int i = 0; i < list.size(); i++) {
    					li.add(list.get(i).val);
    				}
    				
    				res.add(li);
    				list.clear();
    				
    			} else {
    				
    				list.add(root);
    				
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

	}

}
