package com.codility.lesson8;

import java.util.HashMap;
/*
An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.
 */
public class Dominator {
	public static void main(String[] args) {
	    System.out.println(solution(new int[] {3,4,3,2,3,-1,3,3}));
	    //System.out.println(solution(new int[] {}));
	}

	public static int solution(int[] A){
        HashMap<Integer,Integer> data = new HashMap<Integer, Integer>();
        int max_count = Integer.MIN_VALUE;
        int dominator = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            int value = A[i];
            data.put(value, data.getOrDefault(value, 0) + 1);
            
            int value_count = data.get(value);
            if(value_count > max_count) {
                dominator = i;
                max_count = value_count;
            }
        }
        
        if(dominator == Integer.MIN_VALUE) {
            return -1;
        }
        
        
        return max_count > A.length / 2 ? dominator : -1;
	}
}
