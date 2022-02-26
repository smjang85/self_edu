package com.codility.lesson2;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencelsInArray {
	public static void main(String[] args) {
		int aa[] = {9,3,9,3,9,7,9};
		System.out.println(solution(aa));
		
		//System.out.println( 9 ^ 9 );
	}
	
	public static int solution(int[] n) {
		int result = 0;
		
		for(int i = 0; i <n.length; ++i) {
			result = result ^ n[i];
		}
		return result;
	}
	
	/*public static int solution(int[] n) {
		int result = 0;
		Set<Integer> set = new HashSet();
		for(int i : n) {
			if(set.contains(i)) {
				set.remove(i);
			}else {
				set.add(i);
			}
		}
		
		if(set != null) {
			result = set.iterator().next();
		}
		
		return result;
	}*/
	
}
