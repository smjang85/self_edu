package com.leetcode;
public class LegthOfLongestSubstring {
    public static int legthOfLongestSubstring(String s) {
    	int answer = 0;
    	int[] index = new int[128];
    	int i = 0;
    	for(int j = 0; j < s.length(); j++) {
    		i = Math.max(index[s.charAt(j)], i);
    		
    		answer = Math.max(answer, j - i + 1);
    		
    		index[s.charAt(j)] = j + 1;
    	}
		return answer;
    	
    }
	
	public static void main(String[] args) throws Exception {
		System.out.println(legthOfLongestSubstring("abcabcbb"));
	}

}

