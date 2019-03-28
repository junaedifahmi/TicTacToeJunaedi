package com.junaedi.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.junaedi.first.TTTConsoleNonOO2P;


/**
 * Servlet implementation class ServletGame
 */
@WebServlet("/ServletGame")
public class ServletGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private int[][] board;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();

		PrintWriter out = response.getWriter();
		board = (int[][]) session.getAttribute("board");
		int player = (int) session.getAttribute("player");
		String[] poss = request.getParameter("position").split(" ");
		int row = Integer.parseInt(poss[0]);
		int col = Integer.parseInt(poss[1]);
		board[row][col] = player;
		try{
			int winner = chechkScore(row,col);
			session.setAttribute("winner", winner);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
		}
		session.setAttribute("board", board);
		player = (player == 1)? 2 : 1;
		session.setAttribute("player", player);

//		request.setAttribute("position", pos);
		request.getRequestDispatcher("gamepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private int chechkScore(int col, int row) throws ArrayIndexOutOfBoundsException {
		for(int i =0;i<col;i++) {
			for(int k=0;k<row;k++) {
				if( board[i][k] ==  board[i][k+1] && board[i][k+2] ==  board[i][k+1]) { //horizontal winer
					return  board[i][k];
				}
				else if ( board[i][k] ==  board[i][k+1] && board[i+1][k] ==  board[i+2][k]) { //vertical winer
					return    board[i][k];
				}
				else if ( board[i][k] ==  board[i+1][k+1] && board[i+2][k+2] ==  board[i+1][k+1]){ // right horizontal
					return   board[i][k];
				}
				else if( board[i][k] ==  board[i-1][k-1] && board[i-2][k-2] ==  board[i-1][k-1]) {//left horizontal
					return   board[i][k];
				}
				else {
					return 0;
				}
			}
		}
		return 0;
	}

}
