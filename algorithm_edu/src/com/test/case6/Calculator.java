package com.test.case6;

import java.util.Stack;

public class Calculator {
	public static long solution(String[] p) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < p.length; i++) {
			String str = p[i];

			if (Character.isDigit(str.charAt(0))) {
				stack.push(Integer.parseInt(str));
			} else {
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (str) {
				case "+":
					stack.push(val2 + val1);
					break;
				case "-":
					stack.push(val2 - val1);
					break;
				case "/":
					stack.push(val2 / val1);
					break;
				case "*":
					stack.push(val2 * val1);
					break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) throws Exception {
		String[] p= {"12","2","5","+","*","9","3","/","-"};
		//int[] answers= {1,3,2,4,2};
		System.out.println(solution(p));
	}
}
