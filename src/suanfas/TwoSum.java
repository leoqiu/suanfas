package suanfas;

import java.util.HashMap;

public class TwoSum {

	
	
	
	
	
	/**          2011-03-13
	 * 
	 * 
	 *  Given an array of integers, find two numbers such that they add up to a specific target number.
		The function twoSum should return indices of the two numbers such that they add up to the target, where 
		index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
		You may assume that each input would have exactly one solution.
		
		Input: numbers={2, 7, 11, 15}, target=9
		Output: index1=1, index2=2
			
	 *	
	 ********** Solution **********
	 *
	 * Use Hashmap to check if sum of two nums equals to target
	 *
	 * Case : when curNum*2 == target
	 *
	 */
	
	
	
	
	

	
	public int[] twoSum (int[] numbers, int target) {
		
		int[] indexs = new int[2];
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < numbers.length; i++) {
			
			int curNum = numbers[i];
			int curDiff = target - curNum;
			
			if (!map.containsKey(curNum)) {
				
				if(map.containsKey(curDiff)) {
					indexs[0] = map.get(curDiff);
					indexs[1] = i;
					return indexs;
				} else
					map.put(curNum, i);
				
			} else {
				//if 2*curNum
				if(2*curNum == target) {
					indexs[0] = map.get(curNum);
					indexs[1] = i;
					return indexs;
				} else
					map.put(curNum, i);
			}

		}
		
		return indexs;
	}
		
	
	public static void main (String[] args) {
		
		
		
	}
	
}






































