package co.kr.programmers.hash;

import java.util.HashMap;

/**
 * 1) ���� ����
 * �����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����մϴ�.
 * 
 * ���� ��� �����̰� ���� ���� �Ʒ��� ���� ���� �����̰� ���׶� �Ȱ�, �� ��Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ� �������� û������ �߰��� �԰ų� ���׶� �Ȱ� ��� ���� ���۶󽺸� �����ϰų� �ؾ� �մϴ�.
 * 
 * ����	�̸�
 * ��	���׶� �Ȱ�, ���� ���۶�
 * ����	�Ķ��� Ƽ����
 * ����	û����
 * �ѿ�	�� ��Ʈ
 * �����̰� ���� �ǻ���� ��� 2���� �迭 clothes�� �־��� �� ���� �ٸ� ���� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 2) ���ѻ���
 * clothes�� �� ���� [�ǻ��� �̸�, �ǻ��� ����]�� �̷���� �ֽ��ϴ�.
 * �����̰� ���� �ǻ��� ���� 1�� �̻� 30�� �����Դϴ�.
 * ���� �̸��� ���� �ǻ��� �������� �ʽ��ϴ�.
 * clothes�� ��� ���Ҵ� ���ڿ��� �̷���� �ֽ��ϴ�.
 * ��� ���ڿ��� ���̴� 1 �̻� 20 ������ �ڿ����̰� ���ĺ� �ҹ��� �Ǵ� '_' �θ� �̷���� �ֽ��ϴ�.
 * �����̴� �Ϸ翡 �ּ� �� ���� �ǻ��� �Խ��ϴ�.
 * 
 * 3) ����� ��
 * clothes	return
 * [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
 * [[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3
 * 
 * 4) ����� �� ����
 * ���� #1
 * headgear�� �ش��ϴ� �ǻ��� yellow_hat, green_turban�̰� eyewear�� �ش��ϴ� �ǻ��� blue_sunglasses�̹Ƿ� �Ʒ��� ���� 5���� ������ �����մϴ�.
 * 
 * 1. yellow_hat
 * 2. blue_sunglasses
 * 3. green_turban
 * 4. yellow_hat + blue_sunglasses
 * 5. green_turban + blue_sunglasses
 * ���� #2
 * face�� �ش��ϴ� �ǻ��� crow_mask, blue_sunglasses, smoky_makeup�̹Ƿ� �Ʒ��� ���� 3���� ������ �����մϴ�.
 * 
 * 1. crow_mask
 * 2. blue_sunglasses
 * 3. smoky_makeup
 * @author SMJANG
 */
public class Transform {
	public static int solution(String[][] clothes) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			if (hm.containsKey(clothes[i][1]))
				hm.replace(clothes[i][1], hm.get(clothes[i][1]) + 1);
			else
				hm.put(clothes[i][1], 1);
		}

		int answer = 1;
		for (int value : hm.values()) {
			answer *= (value + 1);
		}
		answer -= 1;

		return answer;
	}

	public static void main(String[] args) throws Exception {
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		// String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"},
		// {"smoky_makeup", "face"}};
		System.out.println(solution(clothes));
	}
}
