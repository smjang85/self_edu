package com.codility.lesson3;

public class FrogJmp {
	public static void main(String[] args) {
		System.out.println(solution(10,85,30));
	}

	public static int solution(int X, int Y, int D) {
		int result = X;
		
		int cnt = 0;
		while(result < Y) {
			result = result + D;
			cnt++;
		}
		System.out.println("result : " + result);
		return cnt;
	}
	
    /*public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int distance = Y - X;
        return distance%D == 0 ? distance/D : distance/D + 1;
    }*/
}
