package chap07.card.stub;

import chap07.card.validate.CardNumberValidator;
import chap07.card.validate.CardValidity;

/*
 * 스텁 : 구현을 단순한 것으로 대체한다. 테스트에 맞게 단순히 원하는 동작을 수행한다. StubCardNumberValidator가 스텁 대역에 해당한다.
 * 가짜(Fake) : 제품에는 적합하지 않지만, 실제 동작하는 구현을 제공한다. DB 대신에 메모리를 이용해서 구현한 MemoryAutoDebitInfoRepository가 가짜 대역에 해당한다.
 * 스파이(Spy) : 호출된 내역을 기록한다. 기록한 내용은 테스트 결과를 검증할 때 사용한다. 스텁이기도 하다.
 * 모의(Mock) : 기대한 대로 상호작용하는지 행위를 검증한다. 기대한 대로 동작하지 않으면 익셉션을 발생할 수 있다. 모의 객체는 스텁이자 스파이도 된다.
 */
public class StubCardNumberValidator extends CardNumberValidator {
	private String invalidNo;
	private String theftNo;
	
	public void setInvalidNo(String invalidNo) {
		this.invalidNo = invalidNo;
	}
	
	public void setTheftNo(String theftNo) {
		this.theftNo = theftNo;
	}
	
	@Override
	public CardValidity validate(String cardNumber) {
		if(invalidNo != null && invalidNo.equals(cardNumber)) {
			return CardValidity.INVALID;
		}
		if(theftNo != null && theftNo.equals(cardNumber)) {
			return CardValidity.THEFT;
		}
		return CardValidity.VALID;
	}

}
