package agiletdd.doubles;

public interface UserRepository {
	
	User findByName(String name);
	
	void persist(User user);
}
