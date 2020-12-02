package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.BoardFollowService;

@WebServlet("/boardfollow")
public class BoardFollowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public BoardFollowController() {
        super();
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardFollowService bFollowService = new BoardFollowService();
    	HttpSession session = request.getSession();
    	
    	String bnum = request.getParameter("bnumber");
    	String mid = (String) session.getAttribute("loginId");
    	String bwriter = request.getParameter("bwriter");
    	int followResult = bFollowService.memberfollow(mid, bwriter);
    	System.out.println(mid);
    	System.out.println(bwriter);
    	if(followResult>0) {
    		response.sendRedirect("boardview?bnumber="+bnum);
    	}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
