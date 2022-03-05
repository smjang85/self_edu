package chap07.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chap07.card.dto.AutoDebitReq;
import chap07.card.dto.RegisterResult;
import chap07.card.fake.MemoryAutoDebitInfoRepository;
import chap07.card.model.AutoDebitInfo;
import chap07.card.stub.StubCardNumberValidator;
import chap07.card.validate.CardValidity;

public class AutoDebitRegister_Stub_Test {
	private AutoDebitRegister register;
	private StubCardNumberValidator stubValidator;
	private MemoryAutoDebitInfoRepository repository;
	
	@BeforeEach
	void setUp() {
		//CardNumberValidator validator = new CardNumberValidator();
		//AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
		stubValidator = new StubCardNumberValidator();
		repository = new MemoryAutoDebitInfoRepository();
		register = new AutoDebitRegister(stubValidator, repository);
	}
	
	
	@Test
	void invalidCard() {
		stubValidator.setInvalidNo("111122223333");
		
		AutoDebitReq req = new AutoDebitReq("user1","111122223333");
		RegisterResult result = this.register.register(req);
		
		assertEquals(CardValidity.INVALID, result.getValidity());
	}
	
	@Test
	void theftCard() {
		stubValidator.setTheftNo("1234567890123456");
		
		AutoDebitReq req = new AutoDebitReq("user1","1234567890123456");
		RegisterResult result = this.register.register(req);
		
		assertEquals(CardValidity.THEFT, result.getValidity());
	}
	
	@Test
	void alreadyRegistered_InfoUpdated() {
		repository.save(new AutoDebitInfo("user1","1111222333444",LocalDateTime.now()));
		
		AutoDebitReq req = new AutoDebitReq("user1","123456789012");
		RegisterResult result = this.register.register(req);
		
		AutoDebitInfo saved = repository.findOne("user1");
		assertEquals("123456789012", saved.getCardNumber());
	}
	
	@Test
	void notYetRegistered_newInfoRegistered() {
		AutoDebitReq req = new AutoDebitReq("user1","1234123412341234");
		RegisterResult result = this.register.register(req);
		
		AutoDebitInfo saved = repository.findOne("user1");
		assertEquals("1234123412341234", saved.getCardNumber());
	}
}
