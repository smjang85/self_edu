package com.codility.lesson5;

import java.util.Arrays;

public class GenomicRangeQuery {
	public static void main(String[] args) {
		//System.out.println(Arrays.toString(solution("CAGCCTA", new int[] {2,5,0}, new int[] {4,5,6})));
	    
	    //System.out.println(Arrays.toString(solution("A", new int[] {0}, new int[] {0})));
	    //'CC', [0, 0, 1], [0, 1, 1]
	    //System.out.println(Arrays.toString(solution("CC", new int[] {0,0,1}, new int[] {0,1,1})));
	    //'AC', [0, 0, 1], [0, 1, 1]
	    //System.out.println(Arrays.toString(solution("AC", new int[] {0,0,1}, new int[] {0,1,1})));
	}

	public static int[] solution(String S, int[] P, int[] Q){
	    int[] a = new int[S.length()+1];
	    int[] c = new int[S.length()+1];
	    int[] g = new int[S.length()+1];
	    
        int a_count = 0;
        int c_count = 0;
        int g_count = 0;
 	    for(int i = 0; i < S.length() ; i++) {
	        if(S.charAt(i) == 'A') {
	            a_count++;
	        }else if(S.charAt(i) == 'C') {
	            c_count++;
	        }else if(S.charAt(i) == 'G') {
	            g_count++;
	        }
	        a[i+1] = a_count;
	        c[i+1] = c_count;
	        g[i+1] = g_count;
	    }
	    
	    int[] result = new int[P.length];
	    
	    for(int i = 0; i < P.length; i++) {
	        int startIdx = P[i];
	        int endIdx = Q[i];
	        
	        if(startIdx == endIdx) {
                if(S.charAt(startIdx) == 'A') {
                    result[i] = 1;
                }else if(S.charAt(startIdx) == 'C') {
                    result[i] = 2;
                }else if(S.charAt(startIdx) == 'G') {
                    result[i] = 3;
                }else {
                    result[i] = 4;
                }
	        }else {
	            if(a[startIdx] != a[endIdx+1]) {
	                result[i] = 1;
	            }else if(c[startIdx] != c[endIdx+1]) {
	                result[i] = 2;
	            }else if(g[startIdx] != g[endIdx+1]) {
	                result[i] = 3;
	            }else {
	                result[i] = 4;
	            }
	        }
	    }
	    return result;
	}
}
