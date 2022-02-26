package com.testdome;

public class Palindrome {

	public static boolean isPalindrome(String word) {
		boolean result = false;
		StringBuilder input1 = new StringBuilder(); 
		  
        // append a string into StringBuilder input1 
        input1.append(word); 
  
        // reverse StringBuilder input1 
        input1 = input1.reverse(); 
        String reversedWord = input1.toString();
        
        reversedWord = reversedWord.toLowerCase();
        word = word.toLowerCase();
        
        if(word.equals(reversedWord)) {
        	result = true;
        }
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Palindrome.isPalindrome("Deleveled"));
	}

}
