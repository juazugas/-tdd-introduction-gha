package agiletdd.doubles;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

	private final List<User> users = new ArrayList();
	
	@Override
	public User findByName(String name) {
		return users.stream()
				.filter(user -> user.getName().equals(name))
				.findFirst()
				.orElse(null);
	}

	@Override
	public void persist(User user) {
		users.add(user);
	}

}
