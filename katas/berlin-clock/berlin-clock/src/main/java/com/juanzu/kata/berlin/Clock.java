package com.juanzu.kata.berlin;

import java.util.Arrays;
import java.util.List;

/**
 * @author jzuriaga
 *
 */
public class Clock {

	private static final int THIRD_ROW_RANGE = 5;
	private static final int HOUR_FIVE = 5;
	private static final int HOUR_TEN = 10;
	private static final int HOUR_FIFTEEN = 15;
	private static final int HOUR_TWENTY = 20;

	private int second;
	private int minute;
	private int hour;
	
	public Clock(int second, int minute, int hour) {
		this.second = second;
		this.minute = minute;
		this.hour = hour;
	}

	public Led getFirstRow() {
		return second % 2 == 0 ? Led.OFF : Led.YELLOW;
	}

	public List<Led> getSecondRow() {
		List<Led> hourRow = initHourRow();
		if (hour>=HOUR_FIVE) {
			setLamp(hourRow, 0, Led.RED);
		} 
		if (hour>=HOUR_TEN) {
			setLamp(hourRow, 1, Led.RED);
		}
		if (hour>=HOUR_FIFTEEN) {
			setLamp(hourRow, 2, Led.RED);
		}
		if (hour>=HOUR_TWENTY) {
			setLamp(hourRow, 3, Led.RED);
		}
		return hourRow;
	}

	public List<Led> getThirdRow() {
		List<Led> hourRow = initHourRow();
		if (hour%THIRD_ROW_RANGE>=1) {
			setLamp(hourRow, 0, Led.RED);
		}
		if (hour%THIRD_ROW_RANGE>=2) {
			setLamp(hourRow, 1, Led.RED);
		}
		if (hour%THIRD_ROW_RANGE>=3) {
			setLamp(hourRow, 2, Led.RED);
		}
		if (hour%THIRD_ROW_RANGE>=4) {
			setLamp(hourRow, 3, Led.RED);
		}
		return hourRow;
	}
	
	private List<Led> initHourRow() {
		return Arrays.asList(Led.OFF, Led.OFF, Led.OFF, Led.OFF);
	}
	
	private void setLamp(List<Led> row, int index, Led color) {
		row.set(index, color);
	}
	
}
