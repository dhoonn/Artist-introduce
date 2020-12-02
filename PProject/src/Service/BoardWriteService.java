package Service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.BoardDAO;
import DTO.BoardDTO;

public class BoardWriteService {

	public int boardwrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savePath = "C:\\Users\\owner\\git\\repository\\PProject\\WebContent\\images";
		MultipartRequest multi = new MultipartRequest(request, savePath, 10 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());
		String bwriter = multi.getParameter("bwriter");
		String btitle = multi.getParameter("btitle");
		String bcategory = multi.getParameter("bcategory");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		
		BoardDTO board = new BoardDTO();
		board.setBwriter(bwriter);
		board.setBtitle(btitle);
		board.setBcategory(bcategory);
		board.setBcontent(bcontent);
		board.setBfile(bfile);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int writeResult = bDAO.boardWrite(board);
		bDAO.dbClose();
		
		
		return writeResult; 
	}

}