/*
 * Find value that occurs in odd number of elements.
 */

import java.util.HashMap;

public class OddOccurrencesInArray {
	
	public static int solution(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i: A) {
		    Integer x = new Integer(i);
			if (map.containsKey(x)) {
				map.put(x, new Integer(map.get(x).intValue() + 1));
			}
			else {
				map.put(x, 1);
			}
		}
		
		
		for (Integer k: map.keySet()) {
			if(map.get(k).intValue() % 2 == 1)
				return k;
		}
		
		return 0;
        
    }

}
