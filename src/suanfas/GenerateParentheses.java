package suanfas;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 
 
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

 
 * @author leo
 *
 */


public class GenerateParentheses {

	
	private static void generate (StringBuilder aRes, List<String> ress, int n ,int depth, int left, int right) {
	
		if(depth == 2*n)
			ress.add(aRes.toString());
		
		if(left < n) {
			aRes.append('(');
			generate (aRes, ress, n, depth+1, left+1, right);
			aRes.deleteCharAt(aRes.length()-1);
		}
		
		if(right < left) {
			aRes.append(')');
			generate (aRes, ress, n, depth+1, left, right+1);
			aRes.deleteCharAt(aRes.length()-1);
		}
		
	}
	
	
	
    public static List<String> generateParenthesis(int n) {
        
    	List<String> ress = new ArrayList<String>();
    	StringBuilder aRes = new StringBuilder();
    	
    	generate(aRes, ress, n, 0, 0, 0);
    	
System.out.print(ress);    	
    	
    	return ress;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main (String[] args) {
		
		generateParenthesis(1);
	}
	
	
	
	
	
	
}
