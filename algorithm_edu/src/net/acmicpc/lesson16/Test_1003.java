package net.acmicpc.lesson16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test_1003 {
	//1 1 2 3 5 8
	/*
	public static void main(String[] args) {
		for(int i = 0; i<20; i++ ) {
			System.out.println(fibonacci(i));
		}
	}
	
	 
	static int fibonacci(int n) {
	    if (n == 0) {
	        return 1;
	    } else if (n == 1) {
	        return 1;
	    } else {
	        return fibonacci(n-1) + fibonacci(n-2);
	    }
	}
	*/
	
	/*
	public static void main(String[] args) {
		int[] dp_array = fibonacci_dp(20);
		
		for(int i = 0; i<20; i++ ) {
			System.out.println(dp_array[i]);
		}
	}
	
	static int[] fibonacci_dp(int n) {
	    int[] dp_array = new int[n];
	    dp_array[0] = 1;
	    dp_array[1] = 1;
	    for(int i = 2; i<n; i++) {
	    	dp_array[i] = dp_array[i-1] + dp_array[i-2];
	    }
	    
	    return dp_array;
	}
	*/
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] testCase = new int[cnt];
		
		for(int i = 0; i < cnt; i++) {
			testCase[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < cnt; i++) {
			int target = testCase[i];
			int[][] dp_array = fibonacci_dp(target);
			System.out.println(dp_array[target][0] + " " + dp_array[target][1]);
			
		}
	}
	
	static int[][] fibonacci_dp(int n) {
	    int[][] dp_array = new int[n+1][2];
	    dp_array[0][0] = 1;
	    dp_array[0][1] = 0;
	    if(n == 0) {
	    	return dp_array;
	    }
	    
	    dp_array[1][0] = 0;
	    dp_array[1][1] = 1;
	    
	    if(n == 1) {
	    	return dp_array;
	    }
	    
	    for(int i = 2; i<=n; i++) {
	    	dp_array[i][0] = dp_array[i-1][0] + dp_array[i-2][0];
	    	dp_array[i][1] = dp_array[i-1][1] + dp_array[i-2][1];
	    }
	    
	    return dp_array;
	}
}
