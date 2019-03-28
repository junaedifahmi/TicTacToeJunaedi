package com.junaedi.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.junaedi.first.TTTConsoleNonOO2P;


/**
 * Servlet implementation class ServletGame
 */
@WebServlet("/ServletGame")
public class ServletGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TTTConsoleNonOO2P game = new TTTConsoleNonOO2P();
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("board") == null) {
			int col = Integer.parseInt(request.getParameter("cols"));
			int row = Integer.parseInt(request.getParameter("rows"));
			game.initGame(col, row);
		}
		String pos = request.getParameter("position");
		int player = game.getPlayer();
		game.move(pos);
		int[][] board = game.get_board();
		request.setAttribute("board", board);
		request.setAttribute("player", player);
		request.setAttribute("currentState", game.getcurrentState());
		request.getRequestDispatcher("gamepage.jsp").forward(request, response);
		
		
//		PrintWriter out = response.getWriter();
//		out.println(pos);
//		
		
//		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
