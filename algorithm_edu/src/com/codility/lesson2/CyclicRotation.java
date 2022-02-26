package com.codility.lesson2;

import java.util.Scanner;

public class CyclicRotation {
	public static void main(String[] args) {
		int len = 0;
		int cnt = 0;
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("배열 길이를 입력하세요:");	
			len = scan.nextInt(); // 키보드 문자 입력	
		}while(len < 0 || len > 100);

		
		
		int[] test = new int[len];
		for(int i = 0 ; i < len; i++) {
			int data = -2000;
			do {
				Scanner scan1 = new Scanner(System.in);
				System.out.println("배열" + i + "번째를 입력하세요:");
				try {
					data = scan1.nextInt();	
				}catch(Exception e){
					System.out.println("올바른 값을 입력해주세요.");
				}
				test[i] = data;
			}while(data < -1000 || data > 1000);
		}
		
		
		do {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("반복 횟수를 입력하세요:");
			cnt = scan2.nextInt(); // 키보드 문자 입력	
		}while(cnt < 0 || cnt > 100);
		

		System.out.println("배열 길이 : " +len);
		System.out.println("반복 횟수 : " +cnt);
		System.out.println("대상 배열 내용");
		for (int i = 0  ; i < test.length ; i++) {
			System.out.print(test[i]);
			if(i != test.length-1) {
				System.out.print(",");
			}
		}
		System.out.println("");
		System.out.println("결과 배열 내용");
		int[] result = solution(test, cnt);
		for (int i = 0  ; i < result.length ; i++) {
			System.out.print(result[i]);
			if(i != result.length-1) {
				System.out.print(",");
			}
		}
	}

	public static int[] solution(int[] n, int k) {
	    int len = n.length;
		int[] result = new int[len];

		for (int i = 0; i < len; i++) {
			result[(i+k)%len] = n[i];
		}

		return result;
	}

	/*public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        
        int[] a = new int[A.length];
        
        for(int i = 0 ; i < A.length ; i++){
            a[(i+K)%a.length] = A[i];
        }
        
        return a;
    }*/
}
