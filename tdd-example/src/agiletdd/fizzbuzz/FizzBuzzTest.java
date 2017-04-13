package agiletdd.fizzbuzz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void should_return_0_when_ask_0() {
		// Arrange
		FizzBuzz fizbuzz = new FizzBuzz();
		// Act
		String result = fizbuzz.ask(0);
		// Assert
		assertEquals("00" , result);
	}

}
