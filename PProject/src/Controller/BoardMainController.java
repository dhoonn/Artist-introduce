package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BoardDTO;
import Service.BoardMainService;

@WebServlet("/boardmain")
public class BoardMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardMainController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardMainService bMainService = new BoardMainService();
    	
    	//클릭한 페이지에 필요한 글만 가져오기 위한 메소드 호출                                                                              
    	List<BoardDTO> boardList = bMainService.boardList(request, response);
    	
    	request.setAttribute("boardList", boardList);  //?
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("BoardMain.jsp");
		dispatcher.forward(request, response);
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
