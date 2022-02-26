package co.kr.programmers.dynamic;

public class Test02 {
    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        for(int i = 0;i<triangle.length;i++) {
        	dp[i] = new int[triangle[i].length];
        }
        
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
        	for(int j = 0; j < triangle[i].length; j++) {
        		if(j == 0) { //������ ��
        			dp[i][j] = dp[i-1][j] + triangle[i][j]; // ���� ������ �� + �� ������ ��
        		}else if(j == triangle[i].length -1) { //���� ��
        			dp[i][j] = dp[i-1][j-1] + triangle[i][j]; // ���� ���� �� + �� ���� ��
        		}else { // �߰�     ������ ������ + ���� , ������ ���� +���� �� ū��
        			dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
        		}
        	}
        }
        
        int max = 0;
    	for(int j = 0; j < dp[dp.length-1].length; j++) {
    		if(max < dp[dp.length-1][j]) {
    			max = dp[dp.length-1][j];
    		}
        }
        return max;
    }
	
	public static void main(String[] args) throws Exception {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}
}
