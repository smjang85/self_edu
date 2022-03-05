package mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;

import chap07.user.UserRegister;
import chap07.user.fake.MemoryUserRepository;
import chap07.user.notifier.EmailNotifier;
import chap07.user.spy.SpyEmailNotifier;
import chap07.user.stub.StubWeakPasswordChecker;

public class UserRegisterMockTest {
	private UserRegister userRegister;
	private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
	private MemoryUserRepository fakeRepository = new MemoryUserRepository();
	//private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();
	private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);
	
	@BeforeEach
	void setUp() {
		userRegister = new UserRegister(stubPasswordChecker, fakeRepository, mockEmailNotifier);
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
