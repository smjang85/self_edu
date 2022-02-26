package com.codility.lesson9;

import java.util.HashMap;
/*
A non-empty array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
contains the following example double slices:




double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
double slice (3, 4, 5), sum is 0.
The goal is to find the maximal sum of any double slice.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

For example, given:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A has a sum of greater than 17.
 */
public class MaxDoubleSliceSum {
	public static void main(String[] args) {
	    System.out.println(solution(new int[] {3,2,6,-1,4,5,-1,2}));
	}

	public static int solution(int[] A){
        int n = A.length;
        
        int[] l_max_slice_sum = new int[n];
        int[] r_max_slice_sum = new int[n];
        
        for(int i = 1; i < n-2; i++) {
            l_max_slice_sum[i] = Math.max(l_max_slice_sum[i-1] + A[i] ,0);
        }
        
        for(int i = n-2; i > 0; i--) {
            r_max_slice_sum[i] = Math.max(r_max_slice_sum[i+1] + A[i] ,0);
        }
        
        int max_slice_sum = l_max_slice_sum[0] + r_max_slice_sum[2];
        
        for(int i = 1 ; i < n-1; i++) {
            max_slice_sum = Math.max(max_slice_sum, l_max_slice_sum[i-1] + r_max_slice_sum[i+1]);
        }
        
        return max_slice_sum;
	}
}
