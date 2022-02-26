package com.codility.lesson4;

import java.util.Arrays;

public class MaxCounters {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5,new int[]{3,4,4,6,1,4,4})));
	}

	public static int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		Arrays.fill(counters, 0);
		int maxCnt = 0;
		int excutedMaxCnt = 0;
		for(int i = 0; i < A.length; i++) {
		    int counterNo = A[i];
		    if(counterNo > N) {
		        excutedMaxCnt = maxCnt;
		    }else {
		        if(counters[counterNo-1] < excutedMaxCnt) {
		            counters[counterNo-1] = excutedMaxCnt;
		        }
		        counters[counterNo-1]++;
		        
		        maxCnt = Math.max(maxCnt, counters[counterNo-1]);
		    }
		    
		}
		
		for(int i = 0; i < counters.length; i++) {
		    int count = counters[i];
		    if(count < excutedMaxCnt) {
		        counters[i] = excutedMaxCnt;
		    }
		    
		}
		return counters;
	}
	
}
