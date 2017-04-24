package com.juanzu.kata.berlin;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jzuriaga
 *
 */
public class ClockTest {
	
	private Clock clock;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void should_blink_every_two_seconds_first_off () {
		Led color = null;
		_given:
			clock = new Clock(0);
			
		_when:
			color = clock.getFirstRow();
			
		_then:
			assertThat(color).isEqualTo(Led.OFF);
		
	}

	@Test
	public void should_blink_yellow_every_two_seconds () {
		Led color = null;
		_given:
			clock = new Clock(1);
			
		_when:
			color = clock.getFirstRow();
			
		_then:
			assertThat(color).isEqualTo(Led.YELLOW);
		
	}

}
