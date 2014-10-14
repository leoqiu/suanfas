package suanfas;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 2011-12-05
 * 
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". PAHNAPLSIIGYIR
 * 
 * 
 * 
 * @author leo
 *
 */
public class ZigZagConversion {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 
	 		00    02    04    06
	 		10 11 12 13 14 15 16
	 		30    22    24
	 
	 */
	
    public static String convert(String s, int nRows) {
        
    	if(nRows == 1)
    		return s;
    	
    	HashMap<Integer, StringBuilder> map = new HashMap<Integer, StringBuilder>();
    	char[] sArr = s.toCharArray();
    	int i = 0, j = 0;
    	for (int m = 0; m < nRows; m++) {
    		map.put(m, new StringBuilder(""));
    	}
    	
    	boolean isZig = true;
    	
    	
    	for (int k = 0; k < sArr.length; k++) {
    		
    		if(i == 0)
    			isZig = true;
    		
    		if(i == (nRows-1))
    			isZig = false;
    		
    		//move vertically
    		if(isZig) {
    			map.put(i, map.get(i).append(sArr[k]));
    			i++;
    		} else { //move diagonal
    			map.put(i, map.get(i).append(sArr[k]));
    			i--;
    			j++;
    		}

    	}
    	
    	StringBuilder res = new StringBuilder("");
    	for(int m = 0; m < nRows; m++) {
    		res.append(map.get(m));
    	}
    	
    	return res.toString();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main (String[] args) {
		
		String s = "PAYPALISHIRING";
		
		String s2 = "ABC";
		System.out.println(convert(s2, 2));
	}
}























