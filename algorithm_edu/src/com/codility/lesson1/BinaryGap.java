package com.codility.lesson1;

public class BinaryGap {
	public static void main(String[] args) {
		System.out.println("result : " + solution(1147483600));
	}
	
	public static int solution(int n) {
		int result = 0;
		String binary = Integer.toBinaryString(n);
		
		int currentGap = 0;
		for(int i = 0; i < binary.length(); i++) {
			char chr = binary.charAt(i);
			if(chr == '0') {
				currentGap++;
			}else {
				if(currentGap > result ) {
					result = currentGap;
				}
				currentGap = 0;
			}
		}
		
		return result;
	}
}
