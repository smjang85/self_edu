package com.codility.lesson2;

import java.util.Scanner;

public class CyclicRotation {
	public static void main(String[] args) {
		int len = 0;
		int cnt = 0;
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("�迭 ���̸� �Է��ϼ���:");	
			len = scan.nextInt(); // Ű���� ���� �Է�	
		}while(len < 0 || len > 100);

		
		
		int[] test = new int[len];
		for(int i = 0 ; i < len; i++) {
			int data = -2000;
			do {
				Scanner scan1 = new Scanner(System.in);
				System.out.println("�迭" + i + "��°�� �Է��ϼ���:");
				try {
					data = scan1.nextInt();	
				}catch(Exception e){
					System.out.println("�ùٸ� ���� �Է����ּ���.");
				}
				test[i] = data;
			}while(data < -1000 || data > 1000);
		}
		
		
		do {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("�ݺ� Ƚ���� �Է��ϼ���:");
			cnt = scan2.nextInt(); // Ű���� ���� �Է�	
		}while(cnt < 0 || cnt > 100);
		

		System.out.println("�迭 ���� : " +len);
		System.out.println("�ݺ� Ƚ�� : " +cnt);
		System.out.println("��� �迭 ����");
		for (int i = 0  ; i < test.length ; i++) {
			System.out.print(test[i]);
			if(i != test.length-1) {
				System.out.print(",");
			}
		}
		System.out.println("");
		System.out.println("��� �迭 ����");
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
