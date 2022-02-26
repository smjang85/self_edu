package com.codility.lesson5;

public class MinAvgTwoSlice2 {
	public static void main(String[] args) {
		//System.out.println(Arrays.toString(solution("CAGCCTA", new int[] {2,5,0}, new int[] {4,5,6})));
	    
	    //System.out.println(Arrays.toString(solution("A", new int[] {0}, new int[] {0})));
	    //'CC', [0, 0, 1], [0, 1, 1]
	    //System.out.println(Arrays.toString(solution("CC", new int[] {0,0,1}, new int[] {0,1,1})));
	    //'AC', [0, 0, 1], [0, 1, 1]
	    //System.out.println(Arrays.toString(solution("AC", new int[] {0,0,1}, new int[] {0,1,1})));
	    
	    System.out.println(solution(new int[]{4,2,2,5,1,5,8}));
	}

	public static int solution(int[] A){
	    float minAvg = (A[0] + A[1]) / 2f;
	    int minIndex = 0;
	    for(int i = 2; i < A.length; i++) {
	        float avg = (A[i] + A[i-1] + A[i-2]) / 3f;
	        if(minAvg > avg) {
	            minAvg = avg;
	            minIndex = i-2;
	        }
	        
	        avg = (A[i] + A[i-1]) /2f;
	        if(minAvg > avg) {
                minAvg = avg;
                minIndex = i-1;
            }
	    }
	    return minIndex;
	}
}
