package com.codility.lesson3;

public class PermMissingElem {
	public static void main(String[] args) {
		int[] test = {2,3,1,5};
		System.out.println(solution(test));
	}

	public static int solution(int[] A) {
		long n = A.length+1;
		long total = n*(n+1)/2;
		for(int i = 0; i < A.length; i++) {
			total = total - A[i];
		}
		return (int)total;
	}
	
}
