package com.test.case4;

/*
this function when given an array A of N integers, sorted in non-decreasing order, and some integer
X, looks for X in A. if X is present in A. then the function returns position of (some) occurrence of X in A.
Otherewise, the function return -1.

A[0] = 1    A[1] = 2    A[2] = 5
  A[3] = 9    A[4] = 9

and X= 5, the function should return 2, as A[2] = 5.

the attached code is stil incorrect on some inputs. despite the error(s), the code may produce a correct answer
for the example test cases. the goal of exercise is to find and fix the bug in the implementation.
you can modify at most three lins.
 */
public class FixSort {
	
	
	static int solution(int[] A, int X) {
		int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        
        System.out.println("l :" + l);
        System.out.println("r :" + r);
        //0,4  0+4 /2 = 2   100
        //     2+ 4 = 6 /2 3
        //    3+4 = 7/2 3
        int cnt = 0;
        while (l < r) {
            int m = (l + r) / 2;
            if(cnt == 0) {
            	
            	System.out.println("m :" + m);
            }else if(cnt == 1) {
            	System.out.println("m :" + m);
            }else if(cnt == 2) {
            	System.out.println("m :" + m);
            }
        	cnt++;
            if (A[m] > X) {
                r = m - 1;
               // System.out.println("r1 :" + r);
            } else if (A[m] == X) {
            	return m;
            } else {
                l = m +1;
                // 2
                //System.out.println("l1 :" + l);
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
	public static void main(String[] args) {
		int[] A = {1,2,5,9,9,200};
		System.out.println(solution(A,200));
	}

}
