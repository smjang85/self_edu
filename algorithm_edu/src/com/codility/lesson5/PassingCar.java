package com.codility.lesson5;

public class PassingCar {
	public static void main(String[] args) {
	    
	    System.out.println(solution(new int[]{0,1,0,1,0,1,1}));
	}

	public static int solution(int[] A){
	    int n = A.length;
	    int count = 0;
	    int carry = -1;
	    boolean startFlag = false;
	    for(int i = 0; i < n; i++) {
	        if(A[i] == 0) {
	            carry++;
	            startFlag = true;
	        }else {
	            if(startFlag == true) {
	                count = (count + 1) + carry;
	                if(count > 1000000000) {
	                    return -1;
	                }
	            }
	        }
	    }
	    return count;
	}
}
