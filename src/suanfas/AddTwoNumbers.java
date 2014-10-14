package suanfas;

import suanfas.objects.ListNode;


/**
 * 2011-11-01
 * 
 * You are given two linked lists representing two non-negative numbers. The digits are stored 
 * in reverse order and each of their nodes contain a single digit. Add the two numbers and 
 * return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
 * 
 * 
 * 
 * @author leo
 *
 */


public class AddTwoNumbers {

	public static void add (boolean isL1Base, ListNode l1, ListNode l2) {
	
		ListNode baseList = null;
		ListNode noBaseList = null;
		ListNode lastN = null;
		boolean isCarry = false;
		
		if(isL1Base) {
			baseList = l1;
			noBaseList = l2;
		}		
		
		
		while (noBaseList != null) {
			int sum = baseList.val + noBaseList.val;
			if(isCarry)
				sum = sum + 1;
			
			if(sum >= 10) {
				isCarry = true;
				baseList.val = sum - 10;
			} else {
				isCarry = false;
				baseList.val = sum;
			}
			
			baseList = baseList.next;
			noBaseList = noBaseList.next;
		}
		
		
		if(isCarry) {
			while (baseList != null) {
				int sum = baseList.val;
				if(isCarry)
					sum = baseList.val + 1;
				
				if(sum >= 10) {
					isCarry = true;
					baseList.val = sum - 10;
				} else {
					isCarry = false;
					baseList.val = sum;
				}
				
				lastN = l1;
				baseList = baseList.next;
			}
			
			if(isCarry) 
				lastN.next = new ListNode(1);
		}	
	}
	
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		
		ListNode res = null;
		int l1Len = 0;
		int l2Len = 0;
		
		//calculate len of l1 and l2
		ListNode lTmp = l1;
		while (lTmp != null) {
			l1Len++;
			lTmp = lTmp.next;
		}
		
		lTmp = l2;
		while (lTmp != null) {
			l2Len++;
			lTmp = lTmp.next;
		}
		
		//
		boolean isCarry = false;
		ListNode lastN = null;
		if(l1Len > l2Len) {
			
			res = l1;
			add (true, l1, l2);
			
		} else if(l1Len == l2Len) {
			res = l1;
			
			while (l2 != null) {
				int sum = l1.val + l2.val;
				if(isCarry)
					sum = sum + 1;
				
				if(sum >= 10) {
					isCarry = true;
					l1.val = sum - 10;
				} else {
					isCarry = false;
					l1.val = sum;
				}
				
				lastN = l1;
				l1 = l1.next;
				l2 = l2.next;
			}
			
			if(isCarry) 
				lastN.next = new ListNode(1);
		} else {
			res = l2;
			add (false, l1, l2);
		}
		
		return res;
	}
	
	
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    	//boolean isCarry = false;
    	ListNode res = new ListNode(0);
    	ListNode cur = res;
    	boolean isCarry = false;
    	
    	while (l1.next != null && l2.next != null) {
    		int sum = l1.val + l2.val;
    		
    		if(sum >= 10) {
    			cur.val = sum - 10;
    			isCarry = true;
    		} else {
    			cur.val = sum;
    			isCarry = false;
    		}
    		
    		
    		ListNode nextN = new ListNode(0);
    		if(isCarry)
    			nextN.val = 1;
    		
    		cur.next = nextN;
    		cur = nextN;
    	}
    	
    	if(l1.next == null && l2.next == null) {
    		if(isCarry) {
    			ListNode nextN = new ListNode(1);
    			cur.next = nextN;
    		} 
    	}
    	
    	if(l1.next == null && l2.next != null) {
    		if(isCarry) {
    			
    			ListNode secondHalf = l2.next;
    			l2 = secondHalf;
    			
    			while (l2.next != null) {
    				int sum = l2.val + 1;
    				
    				if(sum >= 10) {
    					l2.val = sum - 10;
    					isCarry = true;
    				} else {
    					l2.val = sum;
    					isCarry = false;
    				}
    			}
    			
    			if (isCarry) {
    				ListNode nextN = new ListNode(0);
    				l2.next = nextN;
    			}
    			
    			cur.next = secondHalf;
    			
    		} else {
    			cur.next = l2.next;
    		}
    	}
    	
    	
    	
    	if(l1.next != null && l2.next == null) {
    		if(isCarry) {
    			
    			ListNode secondHalf = l1.next;
    			l1 = secondHalf;
    			
    			while (l1.next != null) {
    				int sum = l1.val + 1;
    				
    				if(sum >= 10) {
    					l1.val = sum - 10;
    					isCarry = true;
    				} else {
    					l1.val = sum;
    					isCarry = false;
    				}
    			}
    			
    			if (isCarry) {
    				ListNode nextN = new ListNode(0);
    				l1.next = nextN;
    			}
    			
    			cur.next = secondHalf;
    			
    		} else {
    			cur.next = l1.next;
    		}
    	}
    	
    	return res;
    }
	

	
	public static void main (String[] args) {
		/*
		 	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
			Output: 7 -> 0 -> 8
			
			{9}, {1,9,9,9,9,9,8,9,9,9}
			
			
		 */
		
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(9);
		ListNode n13 = new ListNode(8);
		ListNode n14 = new ListNode(9);
		n11.next = n12; n12.next = n13;
		n13.next=n14;
		
		ListNode n21 = new ListNode(9);
//		ListNode n22 = new ListNode(6);
//		ListNode n23 = new ListNode(4);
//		n21.next = n22; n22.next = n23;
		
		
		ListNode res = addTwoNumbers2(n11, n21);
		
		
		System.out.print("");
		
	}
	
	
}


































