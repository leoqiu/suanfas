package suanfas;

import java.util.LinkedList;
import java.util.Stack;




/**
 * 
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 
 * 
 */




public class ValidParentheses {

    public boolean isValid(String s) {
        
    	if(s.length() <= 1 || s.length() % 2 == 1)
    		return false;
    	
    	
    	Stack<Character> stack = new Stack<Character>(); 
		stack.push(s.charAt(0));
    	
    	for (int i = 1; i < s.length(); i++) {
    		
    		char curC = s.charAt(i);
    		
    		if(stack.size() > 0) {
    			if ( (stack.peek() == '(' && curC == ')') || (stack.peek() == '[' && curC == ']') || (stack.peek() == '{' && curC == '}') )
    				stack.pop();
    			else
    				stack.push(curC);
    		}
    		
    	}
    	
    	
    	if(stack.size() == 0)
    		return true;
    	else
    		return false;
    }
    
    
    
    
    
    
    
    
    
    public static void main (String[] args) {
    	
    	
    	
    }
	
	
	
	
	
	
}
