package chap07.user.repository;

import chap07.user.model.User;

public interface UserRepository {
	void save(User user);
	User findById(String id);
}
