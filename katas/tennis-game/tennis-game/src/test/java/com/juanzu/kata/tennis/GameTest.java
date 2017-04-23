/**
 * 
 */
package com.juanzu.kata.tennis;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import static com.juanzu.kata.tennis.GameScore.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jzuriaga
 *
 */
public class GameTest {
	
	private Game match;
	
	@Before
	public void setUp() throws Exception {
		match = new Game(new Player("dummy"), new Player("tummy"));
	}

	@Test
	public void should_score_advantage_for_player_lead() {
		String punctuation = null;
		_given:
			match.getPlayer1().annotate();
			IntStream.range(0,3).forEach(i-> {
				match.getPlayer1().annotate();
				match.getPlayer2().annotate();
			});
			
		_when:
			punctuation = match.getScore();
			
		_then:
			assertThat(punctuation, equalTo(ADVANTAGE));		
	}

	@Test
	public void should_score_deuce_for_draw() {
		String punctuation = null;
		_given:
			IntStream.range(0,3).forEach(i-> {
				match.getPlayer1().annotate();
				match.getPlayer2().annotate();
			});
			
		_when:
			punctuation = match.getScore();
			
		_then:
			assertThat(punctuation, equalTo(DEUCE));		
	}
	
	@Test
	public void should_score_won_when_player_has_win() {
		String punctuation = null;
		_given:
			IntStream.range(0,2).forEach(i-> {
				match.getPlayer1().annotate();
				match.getPlayer1().annotate();
				match.getPlayer2().annotate();
			});
			
		_when:
			punctuation = match.getScore();
			
		_then:
			assertThat(punctuation, equalTo("dummy WON!"));		
	}
}
