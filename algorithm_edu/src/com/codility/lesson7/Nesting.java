package com.codility.lesson7;

import java.util.Stack;

public class Nesting {
	public static void main(String[] args) {
	    //System.out.println(solution("(()(())())"));
	    System.out.println(solution("())"));
	}

	public static int solution(String S){
	 // write your code in Java SE 8
        Stack<Character> data = new Stack<Character>();
        for(char c : S.toCharArray()) {
            if(c == '(') {
                data.push(c);
            }else if(c == ')'){
                if(!data.isEmpty() ) {
                    char lastChr = data.peek();
                    if(lastChr == '(') {
                        data.pop();
                    }
                }else {
                    data.push(c);
                }
            }
        }
        if(data.size() == 0) {
            return 1;
        }
        return 0;
	}
}
