package net.acmicpc.lesson16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test_1923 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[][] testCase = new int[cnt][cnt];
		int[][] result = new int[cnt][cnt];
		
		for(int i = 0; i < cnt; i++) {
			String line = br.readLine();
			String[] value = line.split(" ");
			for(int j = 0; j < value.length; j++) {
				testCase[i][j] = Integer.parseInt(value[j]);	
			}
		}
		
		result[0][0] = testCase[0][0];
	
		for(int i = 1; i < cnt; i++) {
			for(int j = 0; j < testCase[i].length; j++) {
				if(j == 0) {
					result[i][0] = testCase[i][0] + result[i-1][0];	
				}else if (j == testCase[i].length-1 ) {
					result[i][j] = testCase[i][j] + result[i-1][j-1];
				}else {
					result[i][j] = testCase[i][j] + Math.max(result[i-1][j-1], result[i-1][j]);
				}
			}
		}
		/*
		for(int i = 0; i < cnt; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
				
			}
			System.out.println("");
		}
		*/
		
		int maxVal = result[cnt-1][0];
		for(int i = 1; i < result[cnt-1].length; i++) {
			if(result[cnt-1][i] > maxVal) {
				maxVal = result[cnt-1][i];
			}
		}
		System.out.println(maxVal);
	}
}
