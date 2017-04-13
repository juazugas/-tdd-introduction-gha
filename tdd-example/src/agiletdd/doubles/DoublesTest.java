package agiletdd.doubles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class DoublesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void dummyTest() {
		List<String> listOfStrings = new ArrayList();

		listOfStrings.add(null);

		assertEquals(1, listOfStrings.size());
	}

	@Test
	public void fakeTest() {
		UserRepository userRepository = new InMemoryUserRepository();
		UserService userService = new UserService(userRepository);

		userService.createNewUser("agileTdd");

		assertNotNull(userRepository.findByName("agileTdd"));
	}

	@Test
	public void stubTest() {
		UserRepository userRepository = mock(UserRepository.class);
		UserService userService = new UserService(userRepository);
		User agileTddUser = new User("agileTdd");
		doReturn(agileTddUser).when(userRepository).findByName("agileTdd");

		User returnedUser = userService.findUserByName("agileTdd");

		assertNotNull(returnedUser);
	}

	@Test
	public void spyTest() {
		UserRepository userRepository = mock(UserRepository.class);
		UserService userService = new UserService(userRepository);

		userService.createNewUser("agileTdd");

		verify(userRepository).persist(any(User.class));
	}

	@Test
	public void mockTest() {
		ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
		UserRepository userRepository = mock(UserRepository.class);
		UserService userService = new UserService(userRepository);
		doReturn(new User("agileTdd")).when(userRepository).findByName("agileTdd");

		userService.createNewUser("agileTdd");

		verify(userRepository).persist(userCaptor.capture());
		assertEquals("agileTdd", userCaptor.getValue().getName());
	}

}
