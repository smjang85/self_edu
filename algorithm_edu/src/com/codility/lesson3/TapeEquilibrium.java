package com.codility.lesson3;

public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] test = { -1, 1 };
        System.out.println(solution(test));
    }

    public static int solution(int[] A) {
        int left = 0;
        for (int i = 0; i < A.length; i++) {
            left = left + A[i];
        }

        int right = 0;

        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            right = right + A[i];
            left = left - A[i];
            
            int temp = Math.abs(left - right);
            if(temp < dif) {
                dif = temp;
            }
            
        }
        return dif;
    }

}
