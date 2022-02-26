package net.acmicpc.lesson16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test_1149 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[][] testCase = new int[cnt][3];
		
		for(int i = 0; i < cnt; i++) {
			String line = br.readLine();
			String[] value = line.split(" ");
			testCase[i][0] = Integer.parseInt(value[0]);
			testCase[i][1] = Integer.parseInt(value[1]);
			testCase[i][2] = Integer.parseInt(value[2]);
		}
		
		int[][] result = new int[cnt][3];
		result[0][0] = testCase[0][0];
		result[0][1] = testCase[0][1];
		result[0][2] = testCase[0][2];
	
		for(int i = 1; i < cnt; i++) {
			result[i][0] = testCase[i][0] + Math.min(result[i-1][1], result[i-1][2]);
			result[i][1] = testCase[i][1] + Math.min(result[i-1][0], result[i-1][2]);
			result[i][2] = testCase[i][2] + Math.min(result[i-1][0], result[i-1][1]);
		}
		System.out.println(Math.min(Math.min(result[cnt-1][0], result[cnt-1][1]),result[cnt-1][2]));
	}
}
