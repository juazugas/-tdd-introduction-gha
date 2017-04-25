package com.juanzu.kata.berlin;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jzuriaga
 *
 */
public class Clock {

	private static final int DAY_HOURS = 24;
	private static final int HOUR_ROW_DIVISOR = 5;

	private int second;
	private int minute;
	private int hour;

	public Clock(int second, int minute, int hour) {
		this.second = second;
		this.minute = minute;
		this.hour = hour;
	}

	public List<Led> getFirstRow() {
		List<Led> row = initFirstRow();
		switchLamp(row, 1, Led.YELLOW, this.second % 2 != 0);
		return row;
	}

	public List<Led> getSecondRow() {
		List<Led> hourRow = initHourRow();
		IntStream.rangeClosed(1, hourRow.size())
				.forEach(lamp -> switchLamp(hourRow, lamp, Led.RED, secondRowCondition(lamp)));
		return hourRow;
	}

	public List<Led> getThirdRow() {
		List<Led> hourRow = initHourRow();
		IntStream.rangeClosed(1, hourRow.size())
				.forEach(lamp -> switchLamp(hourRow, lamp, Led.RED, thirdRowCondition(lamp)));
		return hourRow;
	}

	private List<Led> initFirstRow() {
		return initRow(1);
	}

	private List<Led> initHourRow() {
		return initRow(4);
	}

	private List<Led> initRow(int size) {
		return IntStream.range(0, size).mapToObj(i -> Led.OFF).collect(Collectors.toList());
	}

	private boolean secondRowCondition(int lamp) {
		return this.hour >= (DAY_HOURS % HOUR_ROW_DIVISOR + 1) * (lamp);
	}

	private boolean thirdRowCondition(int lamp) {
		return this.hour % HOUR_ROW_DIVISOR >= lamp;
	}

	private void setLamp(List<Led> row, int lamp, Led color) {
		row.set(lamp - 1, color);
	}

	private void switchLamp(List<Led> row, int lamp, Led color, boolean condition) {
		if (condition) {
			setLamp(row, lamp, color);
		} else {
			setLamp(row, lamp, Led.OFF);
		}
	}

}
