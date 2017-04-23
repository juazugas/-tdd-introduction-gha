package com.juanzu.kata.tennis;

/**
 * @author jzuriaga
 *
 */
public class Player {
	
	private String name;
	private int score;
	
	public Player(String name) {
		this.score = 0;
		this.name = name;
	}

	public void annotate() {
		score++;
	}

	public int getScore() {
		return score;
	}

	public String getScoreText() {
		return Score.from(score).name();
	}

	public String getName() {
		return name;
	} 

}
