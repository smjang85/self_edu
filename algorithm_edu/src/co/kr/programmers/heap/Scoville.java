package co.kr.programmers.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Scoville {
    public static int solution(int[] scoville, int K) {
        int answer = -1;
        Queue<Integer> pq = new PriorityQueue<Integer>(scoville.length);
        
        for(int i=0; i < scoville.length; i++) {
        	pq.offer(scoville[i]);
        }
        
        int cnt = 0;
        while(pq.size() > 1) {
        	if(K < pq.peek()) {
        		//answer = cnt;
        		break;
        	}else {
        		int s1 = pq.poll();
        		int s2 = pq.poll();
        		int newS = s1 + (s2 * 2);
        		pq.offer(newS);
        		cnt++;
        	}
        }
        if(K < pq.poll()) {
        	answer = cnt;
        }
        return answer;
    }
	public static void main(String[] args) throws Exception {
		int[] scoville= {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
}
