package ticTacToeAi;

public enum Player {
	X('X'), O('O');
	
	private char player;
	
	Player(char player) {
		this.player = player;
	}

	public char getPlayer() {
		return player;
	}
	public void setPlayer(char player) {
		this.player = player;
	}
}