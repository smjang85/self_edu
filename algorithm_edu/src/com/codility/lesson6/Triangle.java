package com.codility.lesson6;

import java.util.Arrays;

public class Triangle {
	public static void main(String[] args) {
	    
	    System.out.println(solution(new int[]{-3,1,2,-2,5,6}));
	}

	public static int solution(int[] A){
	    int n = A.length;
	    if (3 > n) return 0;
	    
	    Arrays.sort(A);
	    
	    for(int i = 0 ; i < n-2 ; i++) {
	        long P = A[i];
	        long Q = A[i+1];
	        long R = A[i+2];
	        if( (P + Q) > R ) return 1;
	    }
	    return 0;
	}
}
