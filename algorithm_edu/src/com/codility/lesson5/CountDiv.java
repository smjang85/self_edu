package com.codility.lesson5;

public class CountDiv {
	public static void main(String[] args) {
	    //4,1,3,2
		System.out.println(solution(6, 11, 2));
	}

	public static int solution(int A, int B, int K){
	    int count = 0;
	    if(A % K == 0) count++;
	    count = count + (B/K - A/K);
	    return count;
	}
}
