package agiletdd.asserts;

import static org.junit.Assert.*;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AssertTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void assert_truthy() {
		assertTrue(true);
		assertFalse(false);
	}
	
	@Test
	public void assert_equals() {
		String foo = "foo";
		int one = 1;
		List<Integer> integers = asList(1,2,3);
		
		assertEquals(foo,"foo");
		assertEquals(one,1);
		assertEquals(integers, asList(1,2,3));
		
		assertNotEquals(foo,"bar");
		assertNotEquals(one,2);
		assertNotEquals(integers, asList(1,2,3,4));
	}
	
	@Test
	public void assert_same() {
		List<Integer> integers = asList(1,2,3);
		List<Integer> integersReference = integers;		
		
		assertSame(integers,integersReference);
		assertNotSame(integers,asList(1,2,3));
	}
	
	@Test
	public void assert_null() {
		String foo = "foo";
		String nullString = null;
		
		assertNull(nullString);
		assertNotNull(foo);
	}
	
	@Test
	public void assert_that_strings() {
		String phrase = "Agile rules";
		
		assertThat(phrase, containsString("rules"));
		assertThat(phrase, endsWith("rules"));
	}
	
	@Test
	public void assert_that_collections() {
		List<Integer> integers = asList(1,2,3);
		
		assertThat(integers, hasItem(1));
		assertThat(integers, hasItems(1,2,3));
	}
	
	@Test(expected = RuntimeException.class)
	public void assert_expected_exception() {

		throw new RuntimeException("This test throws an exception.");
		
	}
}
