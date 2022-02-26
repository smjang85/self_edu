package com.test.case3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/*
ex
wadizian, wadiz, wadiz, reward, equity
wa
 */

/*
Ŀ�ӽ� ����Ʈ ���� �� ������������ ���� ������� �Ʒ��� ���� �����͸� �����޶�� ��û�� ���Խ��ϴ�.
����� Email(ID)
����� �̸�
����� Profile Image Url
�Ϸ� �Ǽ�
����� �Ǽ�
�غ��� �Ǽ�
�ش� API����� ����� ���Ͽ� Select SQL�� ������� �մϴ�. �̶�, ����ũ���� ���������� ������ ��ȸ �ϴ� ������ �ۼ��Ͻÿ�.


����
����ũ���� ID : imstillhungry@wadiz.kr
���� ���� : 2018-12-31 23:59:59
������ �˻� ���� : ���� ���� 90�� �� 00:00:00 ���� ���� ��������

���� ����
���̺� ������ ���� �Ʒ��� �����ϴ�.
1. �ֹ�(PRODUCT_ORDER)
  - �ֹ���ȣ(ORDER_NO)
  - �ֹ� ����(ORDER_STATUS) : �غ�(READY), �����(SHIPPING), �Ϸ�(COMPLETE)
  - �ֹ� �Ͻ�(REGISTERED_AT)
  - �����ID(USER_ID)

2. �����(USER)
  - �����ID(USER_ID)
  - ����� �̸�(USER_NM)

3. ����� ������ �̹���(USER_PROFILE_IMG)
  - �����ID(USER_ID)
  - Image Url(IMG_URL)

����� ������ �̹����� �����Ͱ� ���� �� �ֽ��ϴ�.

�������
USER_ID    USER_NM    IMG_URL    COMPLETE_CNT    SHIPPING_CNT    READY_CNT
imstillhungry@wadiz.kr    ����ũ    null	3	2	1
 */
class Keyword {
	String word;
	Integer cnt;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
}

public class FindKeyword {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();

		String[] wordArr = input1.split("[,]");
		ArrayList<Keyword> list = new ArrayList<Keyword>();

		HashMap<String, Integer> cntMap = new HashMap<String, Integer>();
		for (String word : wordArr) {
			word = word.trim();
			if (word.startsWith(input2)) {
				Integer cnt = 0;
				if (cntMap.get(word) != null) {
					Integer beforeCnt = cntMap.get(word);
					cnt = beforeCnt + 1;
				} else {
					cnt = 1;
				}
				cntMap.put(word, cnt);
			}
		}

		for (String key : cntMap.keySet()) {
			Keyword keyword = new Keyword();
			keyword.setWord(key);
			keyword.setCnt(cntMap.get(key));
			list.add(keyword);
		}

		Collections.sort(list, new Comparator<Keyword>() {
			@Override
			public int compare(Keyword s1, Keyword s2) {
				if (s1.getCnt() < s2.getCnt()) {
					return 1;
				} else if (s1.getCnt() > s2.getCnt()) {
					return -1;
				}
				return 0;
			}
		});

		for (int i = 0; i < list.size(); i++) {
			Keyword keyword = (Keyword) list.get(i);
			String word = keyword.getWord();
			System.out.print(word);
			if(i != list.size() -1) {
				System.out.print(",");
			}
		}
	}
}
