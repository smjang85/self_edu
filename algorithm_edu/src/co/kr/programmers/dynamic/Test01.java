package co.kr.programmers.dynamic;

import java.util.TreeSet;

public class Test01 {
    public static int solution(int N, int number) {
        
        TreeSet<Integer>[] dp = new TreeSet[10];
        for(int i = 1 ; i < 9 ; i++) {
            calculate(i, N, dp);
            if(dp[i].contains(number)) return i;
        }
        return -1;
    }
    
    public static TreeSet<Integer> calculate(int n, int N, TreeSet<Integer>[] dp){
        if(dp[n] != null && dp[n].isEmpty() == false) {
            return dp[n];
        }
        
        int num = 0;
        for(int i = 0 ; i < n ; i++) {
            num = num * 10 + N; //NN 55
        }
        TreeSet<Integer> temp = new TreeSet<Integer>();
        temp.add(num);
        
        for(int i =1; i<n;i++){                          // n = 2  3    4
            TreeSet<Integer> from = calculate(i, N, dp); //     1  1,2  1,2,3
            TreeSet<Integer> to = calculate(n-i, N, dp); //     1  2,1  3,2,1
            for(int n1:from) {
                for (int n2 : to) {//d[n] = d[n-1] + d[i];
                    temp.add(n1 + n2);
                    temp.add(n1 - n2);
                    temp.add(n1 * n2);
                    if(n2 != 0) temp.add(n1 / n2);
                }
            }
        }
        return dp[n]= temp;
    }
	
	public static void main(String[] args) throws Exception {
		int N = 5;
		int number = 12;
		System.out.println(solution(N, number));
	}
}
