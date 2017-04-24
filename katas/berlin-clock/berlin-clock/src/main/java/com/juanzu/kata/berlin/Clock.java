package com.juanzu.kata.berlin;

import java.util.Arrays;
import java.util.List;

/**
 * @author jzuriaga
 *
 */
public class Clock {

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
		return Arrays.asList(Led.OFF, Led.OFF, Led.OFF, Led.OFF);
	}
	
	public List<Led> getThirdRow() {
		return Arrays.asList(Led.OFF, Led.OFF, Led.OFF, Led.OFF);
	}
	
}
