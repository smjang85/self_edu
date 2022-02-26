import java.util.*;

public class Test {

	public static void main(String[] args) {
		int[] numbers = {2, 7, 8, 5, 1, 6, 3, 9, 4};
		deleteMinimalPeaks(numbers);
	}
	
	public static int[] deleteMinimalPeaks(int[] numbers) {
		int len = numbers.length;
		int[] answer = new int[len];
		int cnt = 0;
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		for(int i = 0; i < len ; i++) {
			numbersList.add(numbers[i]);
		}
		
		while(cnt < len) {
			int peek = Integer.MAX_VALUE;
			int peekIdx = -1;
			if(numbersList.size() > 2) {
				int current = numbersList.get(0);
				int post = numbersList.get(1);
				if(current > post) {
					peek = current;
					peekIdx = 0;
				}
			}
			
			for(int i = 1 ; i < numbersList.size()-1 ; i++) {
				int pre = numbersList.get(i-1);
				int current = numbersList.get(i);
				int post = numbersList.get(i+1);
				if(pre < current && current > post){
					if(peek > current) {
						peek = current;
						peekIdx = i;
					}	
				}
			}
			
			if(peekIdx == -1) {
				peek = Integer.MIN_VALUE;
				for(int i = 0 ; i < numbersList.size() ; i++) {
					int current = numbersList.get(i);
					if(current > peek) {
						peek = current;
						peekIdx = i;
					}
				}
			}
			
			numbersList.remove(peekIdx);
			answer[cnt++] = peek;
		}
		
		for( int i = 0; i < answer.length ; i++) {
			System.out.println(answer[i]);
		}
		return answer;
	}



}
