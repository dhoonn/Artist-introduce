package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.FollowDTO;
import Service.BoardFollowListService;
import Service.BoardFollowService;

@WebServlet("/followlist")
public class BoardFollowListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFollowListController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardFollowListService bFollowListService = new BoardFollowListService();
    	HttpSession session = request.getSession();
    	String mid = (String) session.getAttribute("loginId");
    	FollowDTO memberFollow = new FollowDTO();
    	memberFollow = bFollowListService.followList(mid);
    	System.out.println(mid+"ssss");
    	System.out.println(memberFollow.getMid()+"55");
    	request.setAttribute("memberFollow", memberFollow);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("BoardFollowList.jsp");
    	dispatcher.forward(request, response);

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
