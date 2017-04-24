package com.juanzu.kata.berlin;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

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
			clock = new Clock(0,0,0);
			
		_when:
			color = clock.getFirstRow();
			
		_then:
			assertThat(color).isEqualTo(Led.OFF);
		
	}

	@Test
	public void should_blink_yellow_every_two_seconds () {
		Led color = null;
		_given:
			clock = new Clock(1,0,0);
			
		_when:
			color = clock.getFirstRow();
			
		_then:
			assertThat(color).isEqualTo(Led.YELLOW);
		
	}
	 
	@Test
	public void should_second_row_have_four_red_lamps () {
		List<Led> row = null;
		_given:
			clock = new Clock(0,0,1);
			
		_when:
			row = clock.getSecondRow();
			
		_then:
			assertThat(row).size().isEqualTo(4);
	}
	
	 
	@Test
	public void should_third_row_have_four_red_lamps () {
		List<Led> row = null;
		_given:
			clock = new Clock(0,0,1);
			
		_when:
			row = clock.getSecondRow();
			
		_then:
			assertThat(row).size().isEqualTo(4);
	}
	
	@Test 
	public void should_second_row_represent_lamp_every_five_hours () {
		List<Led> rowFirstFive = null;
		_given: _when: _then: {
			
		}
	}

}
