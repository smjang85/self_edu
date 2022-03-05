package chap08.after.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import chap08.after.auth.dto.LoginResult;
import chap08.after.auth.model.Customer;
import chap08.after.auth.repository.CustomerRepository;

/*
 * 외부 라이브러리는 직접 사용하지 말고 감싸서 사용하기
 */
public class LoginServiceTest {
	private AuthService authService = mock(AuthService.class);
	private CustomerRepository customerRepository = mock(CustomerRepository.class);
	private LoginService loginService = new LoginService();
	
	
	@Test
	void loginTest() {
		BDDMockito.given(authService.authenticate("id","pw")).willReturn(-1);
		loginService.setAuthService(authService);
		
		LoginResult resp = loginService.login("id", "pw");
		assertEquals(-1,resp.getResp());
	}
	
	@Test
	void customerRepoTest() {
		BDDMockito.given(authService.authenticate("id","pw")).willReturn(1);
		loginService.setAuthService(authService);
		
		BDDMockito.given(customerRepository.findOne("id")).willReturn(new Customer());
		loginService.setCustomerRepository(customerRepository);
		
		LoginResult resp = loginService.login("id", "pw");
		assertEquals(-2,resp.getResp());
	}
}
