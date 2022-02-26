package co.kr.programmers.dfsbfs;

public class Test01 {
	static int cnt = 0;
    public static int solution(int[] numbers, int target) {
    	dfs(numbers,target,0);
        return cnt;
    }
    public static void dfs(int[] numbers, int target, int idx) {
    	if(idx == numbers.length) {
    		int sum = 0;
    		for(int i : numbers) {
    			sum += i;
    		}
    		
    		if(sum == target) {
    			cnt++;
    		}
    	}else {
    		numbers[idx] *= 1;
    		dfs(numbers,target,idx+1);
    		
    		numbers[idx] *= -1;
    		dfs(numbers,target,idx+1);
    	}
    }
	
	public static void main(String[] args) throws Exception {
		int[] numbers= {1, 1, 1, 1, 1};
		int target = 3;
		//int[] answers= {1,3,2,4,2};
		System.out.println(solution(numbers, target));
	}
}
