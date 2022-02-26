package co.kr.programmers.two;

public class Test01 {
    public static long solution(int n, int[] times) {
        int max = 0;
        for(int time : times) {
        	if(max < time) {
        		max = time;
        	}
        }
        
        long low = 1;
        long high = (long)max * n;
        
        while(low+1 < high) {
        	long mid = (low+high)/2;
        	
        	long cnt = countTimes(times,mid);
        	
        	if(cnt < n) {
        		low = mid;
        	}else {
        		high = mid;
        	}
        }
        
        if(countTimes(times,low) >= n) {
        	return low;
        }else {
        	return high;
        }
    }
    
    public static long countTimes(int[] times,long expectedTime) {
    	long cnt = 0;
    	for(int time: times) {
    		if(time > expectedTime) {
    			continue;
    		}
    		cnt = cnt + (expectedTime/time); 
    	}
    	
    	return cnt;
    }
	
	public static void main(String[] args) throws Exception {
		int n = 6;
		int[] times = {7,10};
		
		System.out.println(solution(n, times));
	}
}
