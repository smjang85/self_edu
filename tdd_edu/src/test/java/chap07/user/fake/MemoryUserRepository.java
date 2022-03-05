package chap07.user.fake;

import java.util.HashMap;
import java.util.Map;

import chap07.user.model.User;
import chap07.user.repository.UserRepository;

public class MemoryUserRepository implements UserRepository {
	private Map<String, User> users = new HashMap<>();

	@Override
	public void save(User user) {
		users.put(user.getId(), user);
	}

	@Override
	public User findById(String id) {
		return users.get(id);
	}
}
