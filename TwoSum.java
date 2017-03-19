package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/* #1 Two Sum
 * href: https://leetcode.com/problems/two-sum/ */
public class TwoSum {
	
	public static int[] solve(int[] list, int target){		
		int dual;
		/* Key = a number from the list, Value = Index of that number */
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<list.length; i++){
			dual = target - list[i];
			if(map.containsKey(dual)){
				return new int[]{map.get(dual), i};
			}
			
			map.put(list[i], i);
		}
		
		throw new IllegalArgumentException("No Solution for provided arguments");
	}

	public static void main(String[] args) {
		int[] list = new int[]{3, 2, 4};
		int target = 6;
		
		System.out.println(Arrays.toString( solve(list, target) ));
	}
}
