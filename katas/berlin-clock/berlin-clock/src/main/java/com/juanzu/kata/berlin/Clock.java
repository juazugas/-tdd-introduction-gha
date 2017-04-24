package com.juanzu.kata.berlin;

/**
 * @author jzuriaga
 *
 */
public class Clock {

	private int second;
	
	public Clock(int second) {
		this.second = second;
	}

	public Led getFirstRow() {
		return second % 2 == 0 ? Led.OFF : Led.YELLOW;
	}
	
}
