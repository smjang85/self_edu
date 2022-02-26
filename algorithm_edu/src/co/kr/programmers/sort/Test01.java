package co.kr.programmers.sort;

import java.util.Arrays;

/*
 * K¹øÂ°¼ö
 */
public class Test01 {
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int cnt=0; cnt<commands.length; cnt++) {
        	int[] command = commands[cnt];
        	int i = command[0];
        	int j = command[1];
        	int k = command[2];
        	
        	int[] temp = new int[j-i+1];
        	System.arraycopy(array, i-1, temp, 0, j-i+1);
        	Arrays.sort(temp);
        	answer[cnt] = temp[k-1];
        }
        return answer;
    }
	
	public static void main(String[] args) throws Exception {
		int[] array= {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(solution(array, commands));
	}
}
