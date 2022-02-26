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
커머스 사이트 구축 중 마이페이지에 대한 요건으로 아래와 같은 데이터를 보여달라는 요청이 들어왔습니다.
사용자 Email(ID)
사용자 이름
사용자 Profile Image Url
완료 건수
배송중 건수
준비중 건수
해당 API기능을 만들기 위하여 Select SQL을 만들려고 합니다. 이때, 히딩크님의 마이페이지 정보를 조회 하는 쿼리를 작성하시오.


조건
히딩크님의 ID : imstillhungry@wadiz.kr
기준 시점 : 2018-12-31 23:59:59
데이터 검색 범위 : 기준 시점 90일 전 00:00:00 부터 기준 시점까지

제반 사항
테이블 정보는 각각 아래와 같습니다.
1. 주문(PRODUCT_ORDER)
  - 주문번호(ORDER_NO)
  - 주문 상태(ORDER_STATUS) : 준비(READY), 배송중(SHIPPING), 완료(COMPLETE)
  - 주문 일시(REGISTERED_AT)
  - 사용자ID(USER_ID)

2. 사용자(USER)
  - 사용자ID(USER_ID)
  - 사용자 이름(USER_NM)

3. 사용자 프로필 이미지(USER_PROFILE_IMG)
  - 사용자ID(USER_ID)
  - Image Url(IMG_URL)

사용자 프로필 이미지는 데이터가 없을 수 있습니다.

출력형식
USER_ID    USER_NM    IMG_URL    COMPLETE_CNT    SHIPPING_CNT    READY_CNT
imstillhungry@wadiz.kr    히딩크    null	3	2	1
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
