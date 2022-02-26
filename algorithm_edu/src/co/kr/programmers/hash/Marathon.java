package co.kr.programmers.hash;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 완주하지 못한 선수
 * 1) 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * 
 * 2) 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 * 
 * 3) 입출력 예
 * participant	completion	return
 * [leo, kiki, eden]	[eden, kiki]	leo
 * [marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
 * [mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
 * 
 * 4) 입출력 예 설명
 *  예제 #1
 *  leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 * 
 *  예제 #2
 *  vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 * 
 *  예제 #3
 *  mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
 */
public class Marathon {
/*	
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        // getOrDefault 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
*/
    
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		 
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		boolean start = true;
		if(null == participant || participant.length < 1 ||  participant.length > 100000) {
			start = false;
		}else {
			if(null == completion || (participant.length -1 == completion.length) == false ) {
				start = false;	
			}
		}
		
		if(start == true) {
			for(int i = 0; i < participant.length; i++) {
				if(data.containsKey(participant[i])) {
					Integer cnt = data.get(participant[i]);
					data.put(participant[i],cnt+1);	
				}else {
					data.put(participant[i],1);	
				}
			}
			
			for(int i = 0; i < completion.length; i++) {
				Integer cnt = data.get(completion[i]);
				if(cnt == 1) {
					data.remove(completion[i]);
				}else {
					data.put(completion[i],cnt-1);	
				}
			}
	       
	        Iterator<String> keys = data.keySet().iterator();
	        while( keys.hasNext() ){
	            String key = keys.next();
	            answer = key;
	        }
		}
		

        
        return answer;
    }
	
	public static void main(String[] args) throws Exception {
		//String[] participant = {"leo", "kiki", "eden"};
		//String[] completion =  {"eden", "kiki"};
		
		//String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		//String[] completion =  {"josipa", "filipa", "marina", "nikola"};
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion =  {"stanko", "ana", "mislav"};
		System.out.println(solution(participant,completion));
	}
}
