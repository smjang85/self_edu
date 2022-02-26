package com.codility.lesson7;

import java.util.Stack;

public class Brackets {
	public static void main(String[] args) {
	    
	    System.out.println(solution("{}("));
	}

	public static int solution(String S){
	    Stack<Character> stack = new Stack<Character>();
	    for(char c : S.toCharArray()) {
	        if(c == '(' || c == '{' || c == '[') {
	            stack.push(c);
	        }else {
	            if(stack.empty()) return 0;
	            char lastChar = stack.pop();
	            if(c == ')' && lastChar != '(') return 0;
	            if(c == '}' && lastChar != '{') return 0;
	            if(c == ']' && lastChar != '[') return 0;
	        }
	    }

	    return stack.empty() ? 1 : 0;
	}
}
