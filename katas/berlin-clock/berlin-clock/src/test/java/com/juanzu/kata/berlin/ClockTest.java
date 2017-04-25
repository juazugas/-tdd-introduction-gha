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
	public void should_2nd_row_first_lamp_turn_on_after_5_hours () {
		_given: _when: _then: {
			for (int i = 0; i < 24; i++) {
				Clock dayClock = new Clock(0, 0, i);
				List<Led> secondRow = dayClock.getSecondRow();
				if(i<5){
					assertThat(secondRow.get(0)).isEqualTo(Led.OFF);
				} else {
					assertThat(secondRow.get(0)).isEqualTo(Led.RED);
				}
			}
		}
	}
	
	@Test 
	public void should_2nd_row_2nd_lamp_turn_on_after_10_hours () {
		_given: _when: _then: {
			for (int i = 0; i < 24; i++) {
				Clock dayClock = new Clock(0, 0, i);
				List<Led> secondRow = dayClock.getSecondRow();
				if(i<10){
					assertThat(secondRow.get(1)).isEqualTo(Led.OFF);
				} else {
					assertThat(secondRow.get(1)).isEqualTo(Led.RED);
				}
			}
		}	
	}

	@Test 
	public void should_2nd_row_3rd_lamp_turn_on_after_15_hours () {
		_given: _when: _then: {
			for (int i = 0; i < 24; i++) {
				Clock dayClock = new Clock(0, 0, i);
				List<Led> secondRow = dayClock.getSecondRow();
				if(i<15){
					assertThat(secondRow.get(2)).isEqualTo(Led.OFF);
				} else {
					assertThat(secondRow.get(2)).isEqualTo(Led.RED);
				}
			}
		}	
	}

	@Test 
	public void should_2nd_row_4th_lamp_turn_on_after_20_hours () {
		_given: _when: _then: {
			for (int i = 0; i < 24; i++) {
				Clock dayClock = new Clock(0, 0, i);
				List<Led> secondRow = dayClock.getSecondRow();
				if(i<20){
					assertThat(secondRow.get(3)).isEqualTo(Led.OFF);
				} else {
					assertThat(secondRow.get(3)).isEqualTo(Led.RED);
				}
			}
		}	
	}
	
	@Test
	public void should_3rd_row_1st_lamp_turn_on_after_1_hour () {
		_given: _when: _then: {
			for (int i = 0; i < 24; i++) {
				Clock dayClock = new Clock(0, 0, i);
				List<Led> thirdRow = dayClock.getThirdRow();
				if(i%5==0){
					assertThat(thirdRow.get(0)).isEqualTo(Led.OFF);
				} else {
					assertThat(thirdRow.get(0)).isEqualTo(Led.RED);
				}
			}
		}	
	}	

	@Test
	public void should_3rd_row_2nd_lamp_turn_on_after_2_hour () {
		_given: _when: _then: {
			for (int i = 0; i < 24; i++) {
				Clock dayClock = new Clock(0, 0, i);
				List<Led> thirdRow = dayClock.getThirdRow();
				if(i%5<2){
					assertThat(thirdRow.get(1)).isEqualTo(Led.OFF);
				} else {
					assertThat(thirdRow.get(1)).isEqualTo(Led.RED);
				}
			}
		}	
	}

	@Test
	public void should_3rd_row_3rd_lamp_turn_on_after_3_hour () {
		_given: _when: _then: {
			for (int i = 0; i < 24; i++) {
				Clock dayClock = new Clock(0, 0, i);
				List<Led> thirdRow = dayClock.getThirdRow();
				if(i%5<3){
					assertThat(thirdRow.get(2)).isEqualTo(Led.OFF);
				} else {
					assertThat(thirdRow.get(2)).isEqualTo(Led.RED);
				}
			}
		}	
	}

	@Test
	public void should_3rd_row_4th_lamp_turn_on_after_4_hour () {
		_given: _when: _then: {
			for (int i = 0; i < 24; i++) {
				Clock dayClock = new Clock(0, 0, i);
				List<Led> thirdRow = dayClock.getThirdRow();
				if(i%5<4){
					assertThat(thirdRow.get(3)).isEqualTo(Led.OFF);
				} else {
					assertThat(thirdRow.get(3)).isEqualTo(Led.RED);
				}
			}
		}	
	}

}
