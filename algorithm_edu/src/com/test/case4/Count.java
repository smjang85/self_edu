package com.test.case4;

/*
A non-negative integer variable V is given. There are tow action available that modify its value :

if V is odd , subtract 1 from it;
if V is even, divide it by 2

given a zero-indexed string S consisting of N characters conting a binary representation of the initial value
of variable V, returns the number of steps after whichi

For exepmle, given string S = "011100" the function should return 7, because string S represents the number 28
and 28 becomes 0 after seven step, as explained above.
 */
public class Count {
	public static int solution(String S) {
        // write your code in Java SE 8
		boolean flag = true;
		int cnt = 0;
		int V = Integer.parseInt(S,2);
		
		while(flag) {
			if(V % 2 == 0) {
				V = V/2;
			}else {
				V = V-1;
			}
			cnt++;
			if(V == 0 ) {
				flag = false;
			}
		}
		return  cnt;
    }
	public static void main(String[] args) {
		String V = "011100";
		System.out.println(solution(V));
	}

}
