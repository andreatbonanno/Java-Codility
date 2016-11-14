/*
 	Calculate the values of counters after applying all alternating operations: 
 	increase counter by 1; set value of all counters to current maximum.
 	
	Given N counters, initially set to 0, and you have two possible operations on them:
	
	increase(X) − counter X is increased by 1,
	max counter − all counters are set to the maximum value of any counter.
	A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:
	
	if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
	if A[K] = N + 1 then operation K is max counter.
	For example, given integer N = 5 and array A such that:
	
	    A[0] = 3
	    A[1] = 4
	    A[2] = 4
	    A[3] = 6
	    A[4] = 1
	    A[5] = 4
	    A[6] = 4
	the values of the counters after each consecutive operation will be:
	
	    (0, 0, 1, 0, 0)
	    (0, 0, 1, 1, 0)
	    (0, 0, 1, 2, 0)
	    (2, 2, 2, 2, 2)
	    (3, 2, 2, 2, 2)
	    (3, 2, 2, 3, 2)
	    (3, 2, 2, 4, 2)
	The goal is to calculate the value of every counter after all operations.

 */

public class MaxCounters {
	
	public int[] solution(int N, int[] A) {
		int local_max = 0;
        int max = 0;
        int max_index = -1;
        int[] counters = new int[N];
        
        for (int i = 0; i < N; i++) {
        	counters[i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
        	if (A[i] <= N) {
        		counters[A[i]-1] = Math.max(counters[A[i]-1] + 1, max + 1);
        		if(counters[A[i]-1] > local_max)
        			local_max = counters[A[i]-1];
        	}
        	else if(A[i] == N+1) {
        		max_index = i;
        		max = local_max;
        	}
        }
        
        for (int i = 0; i < N; i++) {
        	counters[i] = max;
        }
        for (int i = max_index + 1; i < A.length; i++) {
        	counters[A[i]-1] += 1;
        }
        
        return counters;
    }
}
