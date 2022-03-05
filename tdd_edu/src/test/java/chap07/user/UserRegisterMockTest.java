package chap07.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;

import chap07.user.exception.WeakPasswordException;
import chap07.user.fake.MemoryUserRepository;
import chap07.user.model.User;
import chap07.user.notifier.EmailNotifier;
import chap07.user.validate.WeakPasswordChecker;

public class UserRegisterMockTest {
	private UserRegister userRegister;
	private WeakPasswordChecker mockPasswordChecker = mock(WeakPasswordChecker.class);
	private MemoryUserRepository fakeRepository = new MemoryUserRepository();
	private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);
	
	@BeforeEach
	void setUp() {
		userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
	}
	
	@DisplayName("약한 암호면 가입 실패")
	@Test
	void weakPassword() {
		BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true); // 암호가 약하다고 응답하도록 설정
		
		assertThrows(WeakPasswordException.class, () -> {
			userRegister.register("id","pw","email");
		});
	}
	
	@DisplayName("회원 가입시 암호 검사 수행함")
	@Test
	void checkPassword() {
		userRegister.register("id", "pw", "email");
		
		BDDMockito.then(mockPasswordChecker).should().checkPasswordWeak(BDDMockito.anyString());
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
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		BDDMockito.then(mockEmailNotifier).should().sendRegisterEmail(captor.capture());
		
		String realEmail = captor.getValue();
		
		assertEquals("email@email.com", realEmail);
	}
}
