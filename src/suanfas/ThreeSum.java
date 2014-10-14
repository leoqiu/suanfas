package suanfas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2012-01-17
 
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

 * 
 * @author leo
 *
 */









public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
        
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	Arrays.sort(num);
    	
    	for (int i = 0; i < num.length-2; i++) {
    		
    		//eliminate first elem duplicate
    		if (i > 0 && num[i] == num[i - 1])  continue; 
    		
    		int first = num[i];
    		
    		int left = i+1;
    		int right = num.length-1;
    		
    		while (left < right) {
    			if( (first + num[left] + num[right]) > 0)
    				right--;
    			else if( (first + num[left] + num[right]) < 0)
    				left++;
    			else {
    				List<Integer> list = new ArrayList<Integer>();
    				list.add(first); list.add(num[left]); list.add(num[right]);
    				res.add(list);
    				left++;
    				right--;
    				
    				//eliminate 2nd and 3rd elem duplicate
    				while(left < right && num[left] == num[left-1]) left++;
    				while(left < right && num[right] == num[right+1]) right--;
    				
    			}
    		}
    	}
    	
    	return res;
    }
    
    
    
    
    
    
    
    
    
    public static void main (String[] args) {
    	
    	int[] num = {-1, 0, 1, 2, -1, -4};
    	int[] num1 = {0,0,0,0};
    	System.out.print(threeSum(num1));
    }
}




