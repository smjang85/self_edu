package co.kr.programmers.stack;

import java.util.LinkedList;
import java.util.Queue;
/**
    ���� ����
    �Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ��մϴ�. 
    �׷��� ������ �߿��� ������ ���߿� �μ�� �� �ֽ��ϴ�. 
    �̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����߽��ϴ�. 
    �� ���Ӱ� ������ �����ʹ� �Ʒ��� ���� ������� �μ� �۾��� �����մϴ�.
    
    1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
    2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
    3. �׷��� ������ J�� �μ��մϴ�.
    ���� ���, 4���� ����(A, B, C, D)�� ������� �μ� ����Ͽ� �ְ� �߿䵵�� 2 1 3 2 ��� C D A B ������ �μ��ϰ� �˴ϴ�.
    
    ���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. 
    ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.
    
    ���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities�� ���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��, 
    ���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
    
    ���ѻ���
    ���� ����Ͽ��� 1�� �̻� 100�� ������ ������ �ֽ��ϴ�.
    �μ� �۾��� �߿䵵�� 1~9�� ǥ���ϸ� ���ڰ� Ŭ���� �߿��ϴٴ� ���Դϴ�.
    location�� 0 �̻� (���� ����Ͽ� �ִ� �۾� �� - 1) ������ ���� ������ ������� ���� �տ� ������ 0, �� ��°�� ������ 1�� ǥ���մϴ�.
    ����� ��
    priorities  location    return
    [2, 1, 3, 2]    2   1
    [1, 1, 9, 1, 1, 1]  0   5
    ����� �� ����
    ���� #1
    ������ ���� ���� �����ϴ�.
    
    ���� #2
  6���� ����(A, B, C, D, E, F)�� �μ� ����Ͽ� �ְ� �߿䵵�� 1 1 9 1 1 1 �̹Ƿ� C D E F A B ������ �μ��մϴ�.
**/
public class Printer {
	public static int solution(int[] priorities, int location) {
		Queue<Integer> queue = new LinkedList<>();
		for (int p : priorities) {
			queue.offer(p);
		}
		
		int answer = 0;

		while (!queue.isEmpty()) {
			int item = queue.poll();

			// q�� ����item���� ū ���� �ִ��� Ȯ��
			boolean check = true;
			for (int s : queue) {
				if (item < s) {
					check = false;
				}
			}

			// ����̵ɶ����� count++ / �ƴϸ� ���������ǳ��� �ִ´�.
			if (check) {
				answer++;
				if (location == 0) {
					return answer;
				}
			} else {
				queue.offer(item);
			}

			// ������ ��ġ����
			location--;
			if (location == -1) {
				location += queue.size();
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		// int[] priorities= {2, 1, 3, 2};
		// int location = 2;

		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;
		System.out.println(solution(priorities, location));
	}
}
