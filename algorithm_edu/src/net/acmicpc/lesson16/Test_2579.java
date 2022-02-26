package net.acmicpc.lesson16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test_2579 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] testCase = new int[301];
		int[] dp = new int[301];
		
		for(int i = 0; i < cnt; i++) {
			testCase[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = testCase[0];
		dp[1] = Math.max(testCase[0] + testCase[1],testCase[1]) ;
		dp[2] = Math.max(testCase[0] + testCase[2],testCase[1] + testCase[2]) ;
		
		for(int i = 3; i < cnt ; i++) {
			dp[i] = Math.max(dp[i-2] + testCase[i], dp[i-3] + testCase[i-1] + testCase[i]);
		}
		System.out.println(dp[cnt-1]);
		
		
	}
}
