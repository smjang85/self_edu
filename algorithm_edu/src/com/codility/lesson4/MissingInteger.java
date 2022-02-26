package com.codility.lesson4;

import java.util.Arrays;

public class MissingInteger {
	public static void main(String[] args) {
	    //-1000000,1,2,3,4,5,7
	    //-100,100
	    //2,3,6,5
	    //-600,1,2,3,4
	    // 40000
	    //1,3,6,4,1,2
	    //1,2,3
	    //4,3,3,3,1,1,2,2,2
		System.out.println(solution(new int[]{1,2,3}));
	}

	public static int solution(int[] A){
	    int n = A.length;
	    int total = 0;
	    int min_val = Integer.MAX_VALUE;
	    Arrays.sort(A);
		for(int i = 0; i < A.length; i++) {
		    if(A[i] > 0) {
		        if(i == 0 || A[i] != A[i-1]) {
		            total += A[i];
		        }else {
		            n--;
		        }
		        
		        min_val = Math.min(min_val, A[i]);
		    }else {
		        n--;
		    }
		}
		
		if(total == (n*(n+1))/2) {
		    return n+1;
		}
		
		if(A.length == 1 || min_val != 1) {
		    return 1;
		}
		
	    for(int i = 0; i < A.length -1; i++) {
            if(A[i] >= 0 && A[i+1] - A[i] > 1) {
                return A[i] + 1;
            }
        }
		
		return -1;
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
