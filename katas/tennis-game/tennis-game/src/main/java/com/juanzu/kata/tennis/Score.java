package com.juanzu.kata.tennis;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author jzuriaga
 *
 */
public enum Score {
	
	LOVE(0), FIFTEEN(1), THIRTY(2), FORTY(3);
	
	private static final Set<Score> scores = EnumSet.<Score>allOf(Score.class);
	
	private int points;

	private Score(int punctuation) {
		this.points = punctuation;
	}
	
	public int getPoints() {
		return points;
	}
	
	public static Stream<Score> getScores() {
		return scores.stream();
	}

	public static Score from(int points) {
		return getScores().filter(score -> points == score.getPoints()).findFirst().orElseThrow(IllegalArgumentException::new);
	}

}
