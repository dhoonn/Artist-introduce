package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BoardDTO;
import Service.BoardLikeService;

@WebServlet("/boardlike")
public class BoardLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardLikeController() {
        super();
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardLikeService bLikeService = new BoardLikeService();
    	BoardDTO boardLike = new BoardDTO();
    	boardLike = bLikeService.boardLike(request, response);
    	request.setAttribute("boardView", boardLike);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("BoardView.jsp");
    	dispatcher.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doProcess(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
