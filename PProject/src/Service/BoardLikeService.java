package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardDTO;

public class BoardLikeService {

	public BoardDTO boardLike(HttpServletRequest request, HttpServletResponse response) {
int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		bDAO.boardLike(bnumber);
		BoardDTO boardView = bDAO.boardView(bnumber);
		bDAO.dbClose();
		
		
		return boardView;
	}

}
