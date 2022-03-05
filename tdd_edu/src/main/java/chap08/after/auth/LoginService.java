package chap08.after.auth;

import chap08.after.auth.dto.LoginResult;
import chap08.after.auth.model.Customer;
import chap08.after.auth.repository.CustomerRepository;

/*
 * 외부 라이브러리는 직접 사용하지 말고 감싸서 사용하기
 */
public class LoginService {
	private String authKey = "somekey";
	private CustomerRepository customerRepo;
	private AuthService authService = new AuthService();
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	public LoginService() {
		this.customerRepo = customerRepo;
	}
	
	public void setCustomerRepository(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	public LoginResult login(String id, String pw) {
		int resp = authService.authenticate(id, pw);
		if(resp == -1) return LoginResult.badAuthKey();
		
		if(resp == 1) {
			Customer c = customerRepo.findOne(id);
			return LoginResult.authenticated(c);
		} else {
			return LoginResult.fail(resp);
		}
	}
}
