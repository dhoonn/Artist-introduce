package Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardDTO;

public class BoardMainService {

	public List<BoardDTO> boardList(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO bDAO = new BoardDAO();
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		bDAO.dbConnection();
		boardList = bDAO.boardList();
		bDAO.dbClose();
		return boardList;
	}
	

}
