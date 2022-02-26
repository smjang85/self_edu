package com.leetcode;
public class Reverse {
	public static int reverse(int x) {
        String words = String.valueOf(x);
        
        String wordsReverse = new StringBuilder(words).reverse().toString();
        if(x < 0) {
        	wordsReverse = wordsReverse.substring(0, wordsReverse.length()-1);
        	wordsReverse = "-" + wordsReverse;
        }
        int result = 0;
        try {
        	result = Integer.parseInt(wordsReverse);
        }catch(Exception e) {
        	
        }
        
        return result;
    }
    
	
	public static void main(String[] args) throws Exception {
		
		//System.out.println(reverse(9646324351));
	}
}
