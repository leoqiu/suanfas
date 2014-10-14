package suanfas;

import java.util.ArrayList;



/**
 * 
 * 	Maximum Product Subarray
	Find the contiguous subarray within an array (containing at least one number) which has the largest product.

	For example, given the array [2,3,-2,4],
	the contiguous subarray [2,3] has the largest product = 6.
	
	
	
 * 
 * 
 * ******** solution *********
 * compute maxHere base on maxPre & minPre
 * 
 * compute maxSofar base on maxHere & maxSofar 
 * 
 * @author leo
 *
 */



public class MaximumProductSubarray {

	
	/*
	private int positiveNumsProduct (ArrayList<Integer> list) {
		int product = 1;
		for (int i = 0; i < list.size(); i++)
			product = product * list.get(i);
		
		return product;
	}
	
	
	private int negativeNumsProduct (ArrayList<Integer> list) {
		if(list.size() % 2 == 0)
			return positiveNumsProduct(list);
		else {
			list.remove(list.size()-1);
			return positiveNumsProduct(list);
		}
	}
	
	private int maxProductOutContinousIntegers (ArrayList<Integer> list) {
		
		if(list.size() == 1)
			return list.get(0);
		else {
			
			int size = list.size();
			
			//all positive numbers
			if(list.get(0) > 0) 
				return positiveNumsProduct(list);
			
			//all negative numbers
			if(list.get(size-1) < 0) {
				return negativeNumsProduct(list);
			}
			
			//have negative, positive and 0
//			if (list.get(size - 1) > 0 && list.get(0) < 0) {
//				
//			}
				
			
			
			
			
		}
		
		
		
		return 0;
	}
	
	
	
	
    public int maxProduct(int[] A) {
        
    	if(A.length == 1)
    		return A[0];
    	
    	ArrayList<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>(); 
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	for (int i = 0; i < A.length; i++) {
    		
    		if(A[i] != 0 && i < A.length-1 && (A[i] == A[i+1]-1 || A[i] == A[i+1])) {
    			list.add(A[i]);
    		} else if (A[i] == 0 && list.size() != 0) {
    			listOfList.add(new ArrayList<Integer>(list));
    			list.clear();
    		}else if(A[i] != 0) {
    			list.add(A[i]);
    			listOfList.add(new ArrayList<Integer>(list));
    			list.clear();
    		}
    		
    	}
    	
    	
    	
    	int max = 0;
    	for (int i = 0; i < listOfList.size(); i++) {
    		max = Math.max(maxProductOutContinousIntegers(listOfList.get(i)), max);
    	}
    	
    	
    	
    	return max;
    }
	*/
	
    
    
    public int maxProduct4 (int[] A) {
    	
    	int maxPre = A[0];
    	int minPre = A[0];
    	int maxSofar = A[0];
    	int maxHere = A[0];
    	
    	for (int i = 1; i < A.length; i++) {
    		maxHere = Math.max(Math.max(maxPre*A[i], minPre*A[i]), A[i]); 
    		minPre = Math.min(Math.min(maxPre*A[i], minPre*A[i]), A[i]);
    		maxPre = maxHere;
    		maxSofar = Math.max(maxHere, maxSofar);
    	}
    	
    	return maxSofar;
    }
    
    
	
	public static void main (String[] args) {
		
		//int[] A = {2, 3, -2, -4};
		//int[] A = { -2 };
		int[] A = {0, 2};
		int[] B = {-5, -3, -2, -1, 0, 4, 5, 6};
		int[] C = {-4,-3};
		int[] D = {-2,0,-1};
		int max = new MaximumProductSubarray().maxProduct4(C);
		System.out.println(max);
	}
	

}
