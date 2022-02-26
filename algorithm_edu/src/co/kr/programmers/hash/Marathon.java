package co.kr.programmers.hash;

import java.util.HashMap;
import java.util.Iterator;

/**
 * �������� ���� ����
 * 1) ���� ����
 * ������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
 * 
 * �����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 2) ���ѻ���
 * ������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
 * completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
 * �������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
 * ������ �߿��� ���������� ���� �� �ֽ��ϴ�.
 * 
 * 3) ����� ��
 * participant	completion	return
 * [leo, kiki, eden]	[eden, kiki]	leo
 * [marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
 * [mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
 * 
 * 4) ����� �� ����
 *  ���� #1
 *  leo�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.
 * 
 *  ���� #2
 *  vinko�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.
 * 
 *  ���� #3
 *  mislav�� ������ ��ܿ��� �� ���� ������, ������ ��ܿ��� �� ��ۿ� ���� ������ �Ѹ��� �������� ���߽��ϴ�.
 */
public class Marathon {
/*	
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        // getOrDefault ã�� Ű�� �����Ѵٸ� ã�� Ű�� ���� ��ȯ�ϰ� ���ٸ� �⺻ ���� ��ȯ�Ѵ�.
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
