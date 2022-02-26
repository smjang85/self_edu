package co.kr.programmers.allsearch;

import java.util.ArrayList;

public class Test01 {
	public static int[]solution(int[] answers) {
        int[] type1 = {1,2,3,4,5};
        int[] type2 = {2,1,2,3,2,4,2,5};
        int[] type3 = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt = {0,0,0};
        for(int i = 0; i < answers.length; i++) {
        	if(type1[i%type1.length] == answers[i]) {
        		cnt[0]++;
        	}
        	
        	if(type2[i%type2.length] == answers[i]) {
        		cnt[1]++;
        	}
        	
        	if(type3[i%type3.length] == answers[i]) {
        		cnt[2]++;
        	}
        }
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <cnt.length; i++) {
        	if(max == cnt[i]) {
        		list.add(i+1);
        	}
        }
        
        int[] answer = new int[list.size()];
        int i = 0;
        for(int num : list)
            answer[i++] = num;
        
        
        return answer;
    }
	
	public static void main(String[] args) throws Exception {
		int[] answers= {1,2,3,4,5};
		//int[] answers= {1,3,2,4,2};
		System.out.println(solution(answers));
	}
}
