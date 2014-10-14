package suanfas;

/**
 * 2011-11-11
 * Given a string S, find the longest palindromic substring in S. You may assume that 
 * the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * 
 * d a b c b a
 * 
 * 
 * @author leo
 *
 */





public class LongestPalindromicSubstring {

	
	private static void printT (int[][] table) {
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}
	
	/*
	 * Dynamic programming solution, 
	 * 
	 * Running time - O(n^2)
	 * Space - O(n^2)
	 */
    public static String longestPalindrome(String s) {
        
    	char[] sArr = s.toCharArray();
    	int[][] table = new int[sArr.length][sArr.length];
    	int m = 0, n = 0;
    	int ll = 0;
    	
    	//i==j => table[i][i]=1
    	//table 对角线
    	for (int i = 0; i < sArr.length; i++) {
    		table[i][i] = 1;
    		//record current longest substring
    		if(1 > ll) {
    			ll = 1;
    			m = i;
    			n = i;
    		}
    	}
    	
    	//sArr[i]==sArr[i+1] => table[i][i+1]=1
    	for (int i = 0; i < sArr.length-1; i++) {
    		if(sArr[i] == sArr[i+1]) {
    			table[i][i+1] = 1;
    			//record current longest substring
    			if(2 > ll) {
    				ll = 2;
    				m = i;
    				n = i+1;
    			}
    			
    		}	
    	}
    	
    	//table[i+1][j-1] == 1 && sArr[i] == sArr[j] => table[i][j] = 1
    	for (int i = sArr.length-3; i >= 0; i--) {
    		for(int j = i; j <sArr.length; j++) {
    			if( (i+1 <sArr.length && j-1 >= 0) && table[i+1][j-1] == 1 && sArr[i] == sArr[j]) {
    				table[i][j] = 1;
    				
    				//record current longest substring
    				int curLen = j-i+1;
    				if(ll < curLen) {
    					ll = curLen;
    					m = i;
    					n = j;
    				}
    				
    			}
    				
    		}
    	}
    	
    	return s.substring(m, n+1);
    }
	
	
	
	/*
	 * 
	 * "dabcba"
	 * 
	 * running time - O(n^2)
	 * space - O(1)
	 * 
	 * in pratical, this one is faster than dynamic programming
	 * 
	 */
    public static String longestPalindrome2 (String s) {
    	
    	char[] sArr = s.toCharArray();
    	int len = sArr.length;
    	int m = 0;
    	int n = 0;
    	int ll = 0;
    	
    	for (int i = 0; i < sArr.length; i++) {
    		int left = i;
    		int right = i;
    		//one char as the base string
    		while (left >= 0 && right < len) {
    			if(sArr[left] == sArr[right]) {
    				if((right - left + 1) > ll) {
    					ll = right - left + 1;
    					m = left;
    					n = right;
    				}
    			} else
    				break;
    			
    			left--;
    			right++;
    		}
    		
    		if(i < len-1 && sArr[i] == sArr[i+1]) {
    			left = i;
    			right = i+1;
    			//two adjacent chars as base string if they are equal
    			while (left >= 0 && right < len) {
        			if(sArr[left] == sArr[right]) {
        				if((right - left + 1) > ll) {
        					ll = right - left + 1;
        					m = left;
        					n = right;
        				}
        			} else
        				break;
        			
        			left--;
        			right++;
    			}
    		}
    		
    	}
    	
    	return s.substring(m, n+1);  	
    	
    }	
	
	
	
	public static void main(String[] args) {

		String s = "dabcba";
		String s2 = "aaaabaaa";
		
		longestPalindrome2(s2);
	}

}












































