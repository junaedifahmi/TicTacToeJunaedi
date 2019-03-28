package com.junaedi.first;

public class Game {
	public int[][] board;
	
	public final int CIRCLE = 2;
	public final int CROSS = 1;
	public final int EMPTY = 0;
	
	public void init(int row, int col) {
		board = new int[row][col];
		int currentPlayer = CROSS;
	}
	
	public void move(int currentPlayer, int row, int col) {
		board[row][col] = currentPlayer;
	}
	
	 public boolean hasWon(int theSeed, int currentRow, int currentCol) {
	      return (board[currentRow][0] == theSeed         // 3-in-the-row
	                   && board[currentRow][1] == theSeed
	                   && board[currentRow][2] == theSeed
	              || board[0][currentCol] == theSeed      // 3-in-the-column
	                   && board[1][currentCol] == theSeed
	                   && board[2][currentCol] == theSeed
	              || currentRow == currentCol            // 3-in-the-diagonal
	                   && board[0][0] == theSeed
	                   && board[1][1] == theSeed
	                   && board[2][2] == theSeed
	              || currentRow + currentCol == 2  // 3-in-the-opposite-diagonal
	                   && board[0][2] == theSeed
	                   && board[1][1] == theSeed
	                   && board[2][0] == theSeed);
	   }
	
}
