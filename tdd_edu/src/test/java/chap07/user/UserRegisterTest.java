package chap07.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chap07.user.exception.WeakPasswordException;
import chap07.user.fake.MemoryUserRepository;
import chap07.user.model.User;
import chap07.user.spy.SpyEmailNotifier;
import chap07.user.stub.StubWeakPasswordChecker;

public class UserRegisterTest {
	private UserRegister userRegister;
	private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
	private MemoryUserRepository fakeRepository = new MemoryUserRepository();
	private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();
	
	@BeforeEach
	void setUp() {
		userRegister = new UserRegister(stubPasswordChecker, fakeRepository, spyEmailNotifier);
	}
	
	@DisplayName("약한 암호면 가입 실패")
	@Test
	void weakPassword() {
		stubPasswordChecker.setWeak(true); // 암호가 약하다고 응답하도록 설정
		
		assertThrows(WeakPasswordException.class, () -> {
			userRegister.register("id","pw","email");
		});
	}
	
	@DisplayName("같은 ID가 없으면 가입 성공함")
	@Test
	void noDupId_RegisterSuccess() {
		userRegister.register("id", "pw", "email@somedomain.com");
		
		User savedUser = fakeRepository.findById("id"); // 가입 결과 확인
		assertEquals("id" , savedUser.getId());
		assertEquals("email@somedomain.com", savedUser.getEmail());
	}
	
	@DisplayName("가입하면 메일을 전송함")
	@Test
	void whenRegisterThenSendMail() {
		userRegister.register("id", "pw", "email@email.com");
		
		assertTrue(spyEmailNotifier.isCalled());
		assertEquals("email@email.com", spyEmailNotifier.getEmail());
	}
}