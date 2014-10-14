package suanfas;

import java.util.HashSet;

/**
 * 2012-01-17
 * 
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * 
 * 
 * 
 * @author leo
 *
 */

public class LongestCommonPrefix {

	
    public static String longestCommonPrefix(String[] strs) {
        
    	if (strs.length == 0)
            return "";
    	
    	//find the shortest length
    	int sLen = Integer.MAX_VALUE;
    	for (int i = 0; i < strs.length; i++)
    		sLen = Math.min(strs[i].length(), sLen);
    	
    	if(sLen == 0)
    		return "";
    	
    	int curIndex = 0;
    	HashSet<Character> set = new HashSet<Character>();
    	boolean isLooping = true;
    	
    	while (curIndex < sLen && isLooping) {
        	
    		char firstChar = strs[0].charAt(curIndex);
    		set.add(firstChar);
    		
    		for (int i = 1; i < strs.length; i++) {	
        		if(!set.contains(strs[i].charAt(curIndex))) {
        			curIndex--;
        			isLooping = false;
        			break;
        		}
        	}
    		
    		curIndex++;
    		set.clear();
    	}
    	
    	
    	return strs[0].substring(0, curIndex);
    }
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String[] strs = {"aab", "aabcc", "aabbbbbccc"};
		
		String[] strs1 = {};
		
		System.out.print(longestCommonPrefix(strs1));
	}

}
