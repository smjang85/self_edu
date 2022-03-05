package chap08.before.auth;

import chap08.before.auth.dto.LoginResult;
import chap08.before.auth.model.Customer;
import chap08.before.auth.repository.CustomerRepository;
import chap08.before.auth.util.AuthUtil;

/*
 * 정적인 메소드로 인해 테스트하기 어려운 코드
 * AuthUtil 클래스가 인증 서버와 통신하는 경우 이 코드를 테스트하려면 동작하고 있는 인증 서버가 필요하다.
 * 
 */
public class LoginService {
	private String authKey = "somekey";
	private CustomerRepository customerRepo;
	
	public LoginService(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	public LoginResult login(String id, String pw) {
		int resp = 0;
		boolean authorized = AuthUtil.authorize(authKey);
		if(authorized) {
			resp = AuthUtil.authenticate(id, pw);
		} else {
			resp = -1;
		}
		
		if(resp == -1) return LoginResult.badAuthKey();
		
		if(resp == 1) {
			Customer c = customerRepo.findOne(id);
			return LoginResult.authenticated(c);
		} else {
			return LoginResult.fail(resp);
		}
	}
}
