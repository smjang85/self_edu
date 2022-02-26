package com.codility.lesson7;

import java.util.Stack;

public class Fish {
	public static void main(String[] args) {
	    System.out.println(solution(new int[] {4,3,2,1,5}, new int[] {0,1,0,0,0}));
	    //System.out.println(solution(new int[] {4,3,2,1,5}, new int[] {1,0,1,0,1}));
	}

	public static int solution(int[] A, int[] B){
	    Stack<Integer> down = new Stack<Integer>();
	    int aliveUpFish = 0;
	    for(int i = 0 ; i < A.length ; i++) {
	        if(B[i] == 1) {  
	            down.push(A[i]);
	        }else {
	            while(!down.isEmpty()) {
	                int lastDownFish = down.peek();
	                if(lastDownFish > A[i]) { break;
	                }else {
	                    down.pop();
	                }
	            }
	            if(down.isEmpty()) aliveUpFish++;
	        }
	    }
	    return aliveUpFish + down.size();
	}
}
