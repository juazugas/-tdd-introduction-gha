package com.juanzu.kata.tennis;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static com.juanzu.kata.tennis.Score.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jzuriaga
 */
public class PlayerTest {

	private Player player;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = new Player("dummy");
	}

	@Test
	public void should_mark_0_points_as_love() {
		String punctuation = null;
		_given:
			
		_when:
			punctuation = player.getScoreText();
			
		_then:
			assertThat(punctuation, equalTo(LOVE.name()));
	}
	
	@Test
	public void should_mark_1_points_as_fifteen() {
		String punctuation = null;
		_given:
			player.annotate();
			
		_when:
			punctuation = player.getScoreText();
			
		_then:
			assertThat(punctuation, equalTo(FIFTEEN.name()));		
	}

	@Test
	public void should_mark_2_points_as_thirty() {
		String punctuation = null;
		_given: 
			IntStream.range(0,2).forEach(i->player.annotate());
			
		_when:
			punctuation = player.getScoreText();
			
		_then:
			assertThat(punctuation, equalTo(THIRTY.name()));		
	}

	@Test
	public void should_mark_3_points_as_forty() {
		String punctuation = null;
		_given:
			IntStream.range(0,3).forEach(i->player.annotate());
			
		_when:
			punctuation = player.getScoreText();
			
		_then:
			assertThat(punctuation, equalTo(FORTY.name()));		
	}

}
