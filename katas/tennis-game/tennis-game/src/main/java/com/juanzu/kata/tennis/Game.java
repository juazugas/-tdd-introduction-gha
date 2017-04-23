package com.juanzu.kata.tennis;

public class Game {
	
	private Player player1;
	private Player player2;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public String getScore() {
		
		if (isEnded()) {
			return ( player1.getScore() > player2.getScore() ? player1.getName() : player2.getName() ) + " WON!";
		} else if (player1.getScore()>=3&&player2.getScore()>=3) {
			if (player1.getScore()==player2.getScore()) {
				return GameScore.DEUCE;
			} else {
				return GameScore.ADVANTAGE;
			}
		}
		return player1.getScoreText() + " - " + player2.getScoreText();
	}
	
	private boolean isEnded () {
		return  (player1.getScore()>3 || player2.getScore()>3) && Math.abs(player1.getScore() - player2.getScore()) > 1; 
	}
	
}
