package suanfas;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * 
	 * 2011-05-15
	 * 
	 * 
	 * Given a string, find the length of the longest substring without repeating characters. For example, 
	 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For 
	 * "bbbbb" the longest substring is "b", with the length of 1.
	 * 
	 * 
	 * *********Solution************
	 * dabcabcbb, use hashmap's key to track unrepeated characters, hashmap's value to the first repeated char's
	 * index and use it as the begin of the window.
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static int lengthOfLongestSubstring (String s) {
		
		char[] cArr = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int ll = 0;
		
		for (int i = 0; i < cArr.length; ) {
			
			while (i< cArr.length) {
				
				if(!map.containsKey(cArr[i])) {
					map.put(cArr[i], i);
					i++;
				} else {
					i = map.get(cArr[i]) + 1;
					break;
				}
					
				
			}
			
			if(ll < map.size())
				ll = map.size();
			
			map.clear();
			
		}
		
		return ll;
	}

	
	public static void main (String[] args) {
		String s = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac";
		String s1 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.print(lengthOfLongestSubstring(s1));
	}
	
}

























