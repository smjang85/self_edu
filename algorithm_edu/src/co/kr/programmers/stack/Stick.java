package co.kr.programmers.stack;

import java.util.ArrayList;

public class Stick {
    public static int solution(String arrangement) {
        int answer = 0;
        String copyArrangement = arrangement.replace("()", "X");
        System.out.println("copyArrangement :" + copyArrangement);
        ArrayList<Character> basicList = new ArrayList<Character>();
        for(int i = 0; i < copyArrangement.length(); i++) {
        	basicList.add(copyArrangement.charAt(i));
        }
        
        ArrayList<Character> resultList = new ArrayList<Character>();
        for(int i = 0; i < basicList.size(); i++) {
        	if(basicList.get(i) == '(') {
        		resultList.add(basicList.get(i));
        	}else if(basicList.get(i) == 'X') {
        		answer += resultList.size();
        	}else if(basicList.get(i) == ')') {
        		resultList.remove(resultList.size()-1);
        		answer += 1;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) throws Exception {
		String arrangement= "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}
}
