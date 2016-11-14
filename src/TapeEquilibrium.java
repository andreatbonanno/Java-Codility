/*
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 */

public class TapeEquilibrium {
	
	public int solution(int[] A) {
		int sum = 0;
        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            
            // initialize minDiff to the maximum possible value
            minDiff += Math.abs(A[i]);
        }
        
        int sum_1 = 0;
        
        for (int i = 1; i < A.length; i++) {
            sum_1 += A[i-1];
            sum = sum - A[i-1];
            if(minDiff > Math.abs(sum_1 - sum))
                minDiff = Math.abs(sum_1 - sum);
        }
        
        return minDiff;
    }

}
