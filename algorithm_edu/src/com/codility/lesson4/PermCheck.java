package com.codility.lesson4;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
	public static void main(String[] args) {
	    //4,1,3,2
		System.out.println(solution(new int[]{4,1,3}));
	}

	public static int solution(int[] A){
	    Set<Integer> data = new HashSet<Integer>();
	    for(int i = 0; i < A.length; i++) {
	        if(A[i] > A.length) {
	            return 0;
	        }
	        
	        if(data.contains(A[i])) {
	            return 0;
	        }
	        
	        data.add(A[i]);
	    }
	    return 1;
	}
	
    /*public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int a : A) {
            set.add(a);
        }
        for(int i=1; i<=Integer.MAX_VALUE; i++) {
            if(!set.contains(i)) { return i; }
        }
        return -1;
    }*/
	
}
