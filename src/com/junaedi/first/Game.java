package com.junaedi.first;

import com.junaedi.first.TTTConsoleNonOO2P;

public class Game {
	TTTConsoleNonOO2P game = new TTTConsoleNonOO2P();
	public Game(int cols, int rows) {
		game.set_board_size(cols, rows);
	}
	
	public void updatePosition(String position) {
		String[] splt = position.split(" ");
		int col = Integer.parseInt(splt[0]);
		int row = Integer.parseInt(splt[1]);
		game.playerMove(theSeed);
	}
	
	public static void main(String Args[]) {
		Game a = new Game(4,4);
		game.playerMove(currentPlayer); // update currentRow and currentCol
        game.updateGame(currentPlayer, currntRow, currentCol); // update currentState
        game.get_board();
		String b = "2 2";
		a.updatePosition(b);
	}
}
