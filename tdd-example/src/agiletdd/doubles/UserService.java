package agiletdd.doubles;

public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void createNewUser(String name){
		User newUser = new User(name);
		
		userRepository.persist(newUser);
	}
	
	public User findUserByName(String name){
		return userRepository.findByName(name);
	}
	
}
