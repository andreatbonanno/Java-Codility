/*
 * Check whether array A is a permutation.
 */

import java.util.HashMap;

public class PermCheck {
	public static int solution(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = A[0];
        for(Integer i: A) {
            Integer a = new Integer(i);
            if(map.containsKey(a)){
                return 0;
            }
                
            map.put(a,1);
            if(max < a)
                max = a;
        }
        
        for(int i = 1; i <= max; i++) {
            if (!map.containsKey(i))
                return 0;
        }
        
        return 1;
        
    }
}
