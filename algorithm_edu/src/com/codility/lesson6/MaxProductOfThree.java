package com.codility.lesson6;

import java.util.Arrays;

public class MaxProductOfThree {
	public static void main(String[] args) {
	    
	    System.out.println(solution(new int[]{-3,1,2,-2,5,6}));
	}

	public static int solution(int[] A){
	    Arrays.sort(A);
	    int n = A.length - 1;
	    int result = A[n] * A[n-1] * A[n-2];
	    if(A[0] < 0 && A[1] < 0 && A[n] > 0) {
	        int result2 = A[0] * A[1] * A[n];
	        if(result2 > result) result = result2;
	    }
	    
	    return result;
	}
}
