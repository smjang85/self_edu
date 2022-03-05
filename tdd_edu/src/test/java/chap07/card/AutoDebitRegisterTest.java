package chap07.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chap07.card.dto.AutoDebitReq;
import chap07.card.dto.RegisterResult;
import chap07.card.repository.AutoDebitInfoRepository;
import chap07.card.stub.StubAutoDebitInfoRepository;
import chap07.card.validate.CardNumberValidator;
import chap07.card.validate.CardValidity;

public class AutoDebitRegisterTest {
	private AutoDebitRegister register;
	
	@BeforeEach
	void setUp() {
		CardNumberValidator validator = new CardNumberValidator();
		AutoDebitInfoRepository repository = new StubAutoDebitInfoRepository();
		register = new AutoDebitRegister(validator, repository);
	}
	
	@Test
	void validCard() {
		AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
		RegisterResult result = this.register.register(req);
		assertEquals(CardValidity.VALID, result.getValidity());
	}
	
	@Test
	void theftCard() {
		AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
		RegisterResult result = this.register.register(req);
		assertEquals(CardValidity.THEFT, result.getValidity());
	}
}
