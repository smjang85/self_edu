package com.codility.lesson6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
	public static void main(String[] args) {
	    
	    System.out.println(solution(new int[]{1,1,2,2,2,3}));
	}

	public static int solution(int[] A){
	    Set<Integer> data = new HashSet<Integer>();
	    for(int i = 0; i < A.length; i++) {
	        data.add(A[i]);
	    }

	    return data.size();
	}
}
