package com.codility.lesson7;

import java.util.Stack;

public class StoneWall {
	public static void main(String[] args) {
	    System.out.println(solution(new int[] {8,8,5,7,9,8,7,4,8}));
	    System.out.println(solution(new int[] {1,1,1}));
	}

	public static int solution(int[] H){
        Stack<Integer> blocks = new Stack<Integer>();
        int count = 0;
        for(int height : H) {
            while(!blocks.isEmpty()) {
                Integer block = blocks.peek();
                if(block < height) {
                    break;
                }else if(block > height) {
                    blocks.pop();
                }
                
                if(block == height) {
                    blocks.pop();
                    count--;
                    break;
                }
            }
            
            blocks.push(height);
            count++;
        }
        return count;
	}
}
