package co.kr.programmers.greed;

public class Test01 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int total = n - lost.length;
        
        for(int i = 0; i < lost.length; i++) {
        	int lostNo = lost[i];
        	for(int j = 0; j < reserve.length; j++) {
        		int reserveNo = reserve[j];
        		if(lostNo == reserveNo) {
        			reserve[j] = -1;
        			lost[i] = -1;
        			total++;
        			break;
        		}
        	}
        }
        
        for(int i = 0; i < lost.length; i++) {
        	int lostNo = lost[i];
        	if(lostNo != -1) {
            	for(int j = 0; j < reserve.length; j++) {
            		int reserveNo = reserve[j];
            		if(reserveNo != -1 && (lostNo == (reserveNo+1) || lostNo == (reserveNo-1))) {
            			total += 1;
            			reserve[j] = -1;
            			break;
            		}
            	}
        	}
        }
        
        return total;
    }
	
	public static void main(String[] args) throws Exception {
		int n = 5;
		int[] lost = {2,4}; 
		int[] reserve = {1,3,5};
		System.out.println(solution(n,lost, reserve));
	}
}
