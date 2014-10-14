package suanfas;

import java.util.ArrayList;

/**
 * 2012-01-04
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author leo
 *
 */
public class PalindromeNumber {

	
    public static boolean isPalindrome(int x) {
    	
    	if(x < 0)
    		return false;
    	
    	if(x >= 0 && x < 10)
    		return true;
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	while (x >= 10) {
    		int cur = x % 10;
    		x = (x - cur)/10;
    		list.add(cur);
    	}
    	
    	list.add(x);
    	
    	int j = list.size()-1;
    	for (int i = 0; i < list.size(); i++) {
    		if(list.get(i) == list.get(j)) {
    			j--;
    		} else
    			return false;
    	}
    	
    	
    	return true;
    }
	
	
	
	
	
	
	public static void main (String[] args) {
		System.out.print(isPalindrome(1222332221));
	}
	
	
	
}
