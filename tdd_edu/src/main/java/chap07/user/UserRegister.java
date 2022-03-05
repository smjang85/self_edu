package chap07.user;

import chap07.user.exception.DupIdException;
import chap07.user.exception.WeakPasswordException;
import chap07.user.model.User;
import chap07.user.notifier.EmailNotifier;
import chap07.user.repository.UserRepository;
import chap07.user.validate.WeakPasswordChecker;

public class UserRegister {
	private WeakPasswordChecker passwordChecker;
	private UserRepository userRepository ;
	private EmailNotifier emailNotifier;
	
	public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository, EmailNotifier emailNotifier) {
		this.passwordChecker = passwordChecker;
		this.userRepository = userRepository;
		this.emailNotifier = emailNotifier;
	}
	
	public void register(String id, String pw, String email) {
		if(passwordChecker.checkPasswordWeak(pw)) {
			throw new WeakPasswordException();
		}
		
		User user = userRepository.findById(id);
		if(user != null) {
			throw new DupIdException();
		}
		
		userRepository.save(new User(id, pw, email));
		
		emailNotifier.sendRegisterEmail(email);
	}
}
