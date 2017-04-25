package com.juanzu.kata.berlin;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Predicate;

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
	public void should_1st_row_has_one_lamp() {
		_given: clock = new Clock(0, 0, 0);

		_when: _then: assertRowSize(clock.getFirstRow(), 1);
	}

	@Test
	public void should_blink_every_two_seconds_first_off() {
		_given: clock = new Clock(0, 0, 0);

		_when: _then: assertLedColor(clock.getFirstRow(), 0, Led.OFF);

	}

	@Test
	public void should_blink_yellow_every_two_seconds() {
		_given: clock = new Clock(1, 0, 0);

		_when: _then: assertLedColor(clock.getFirstRow(), 0, Led.YELLOW);
	}

	@Test
	public void should_second_row_have_four_red_lamps() {
		_given: clock = new Clock(0, 0, 1);

		_when: _then: assertRowSize(clock.getSecondRow(), 4);
	}

	@Test
	public void should_2nd_row_first_lamp_turn_on_after_5_hours() {
		for (int hour = 0; hour < 24; hour++) {
			assertLedTurnOn(new Clock(0, 0, hour).getSecondRow(), 0, Led.RED, hour >= 5);
		}
	}

	@Test
	public void should_2nd_row_2nd_lamp_turn_on_after_10_hours() {
		for (int hour = 0; hour < 24; hour++) {
			assertLedTurnOn(new Clock(0, 0, hour).getSecondRow(), 1, Led.RED, hour >= 10);
		}
	}

	@Test
	public void should_2nd_row_3rd_lamp_turn_on_after_15_hours() {
		for (int hour = 0; hour < 24; hour++) {
			assertLedTurnOn(new Clock(0, 0, hour).getSecondRow(), 2, Led.RED, hour >= 15);
		}
	}

	@Test
	public void should_2nd_row_4th_lamp_turn_on_after_20_hours() {
		for (int hour = 0; hour < 24; hour++) {
			assertLedTurnOn(new Clock(0, 0, hour).getSecondRow(), 3, Led.RED, hour >= 20);
		}
	}

	@Test
	public void should_third_row_have_four_red_lamps() {
		_given: clock = new Clock(0, 0, 1);

		_when: _then: assertRowSize(clock.getThirdRow(), 4);
	}

	@Test
	public void should_3rd_row_1st_lamp_turn_on_after_1_hour() {
		for (int hour = 0; hour < 24; hour++) {
			assertLedTurnOn(new Clock(0, 0, hour).getThirdRow(), 0, Led.RED, hour % 5 >= 1);
		}
	}

	@Test
	public void should_3rd_row_2nd_lamp_turn_on_after_2_hour() {
		for (int hour = 0; hour < 24; hour++) {
			assertLedTurnOn(new Clock(0, 0, hour).getThirdRow(), 1, Led.RED, hour % 5 >= 2);
		}
	}

	@Test
	public void should_3rd_row_3rd_lamp_turn_on_after_3_hour() {
		for (int hour = 0; hour < 24; hour++) {
			assertLedTurnOn(new Clock(0, 0, hour).getThirdRow(), 2, Led.RED, hour % 5 >= 3);
		}
	}

	@Test
	public void should_3rd_row_4th_lamp_turn_on_after_4_hour() {
		for (int hour = 0; hour < 24; hour++) {
			assertLedTurnOn(new Clock(0, 0, hour).getThirdRow(), 3, Led.RED, hour % 5 >= 4);
		}
	}

	private void assertRowSize(List<Led> row, int size) {
		assertThat(row).hasSize(size);
	}

	private void assertLedColor(List<Led> row, int lamp, Led color) {
		assertThat(row.get(lamp)).isEqualTo(color);
	}

	private void assertLedTurnOn(List<Led> row, int lamp, Led color, boolean onCondition) {
		if (onCondition) {
			assertLedColor(row, lamp, color);
		} else {
			assertLedColor(row, lamp, Led.OFF);
		}
	}

}
