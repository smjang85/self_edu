package co.kr.programmers.dynamic;

public class Test03 {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] street = new int[n][m];

        // �����̴� -1
        for (int[] puddle : puddles)
          street[puddle[1] - 1][puddle[0] - 1] = -1;

        street[0][0] = 1;

        for (int i = 0; i < n; i++) { // �������� 1�� ����   3
          for (int j = 0; j < m; j++) {  //4

            if(street[i][j] == -1) { // �����̸� 0���� �ٲٰ� continue
              street[i][j] = 0;
              continue;
            }
            if(i != 0)
              street[i][j] = street[i][j] + street[i - 1][j] % 1000000007; // ���ڰ� �� ���� �ʰ��� �� �ֱ� ������ ��� �������� ������ ���ϱ�

            if(j != 0)
              street[i][j] = street[i][j] + street[i][j - 1] % 1000000007; // ����
          }
        }

        return street[n - 1][m - 1] % 1000000007;
    }
	
	public static void main(String[] args) throws Exception {
		int[][] puddles = {{2, 2}};
		System.out.println(solution(4,3,puddles));
	}
}
