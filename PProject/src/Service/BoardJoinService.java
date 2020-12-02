package Service;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.MemberDAO;
import DTO.BoardDTO;
import DTO.MemberDTO;

public class BoardJoinService {

	public int boardJoin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savePath = "C:\\Users\\owner\\git\\repository\\PProject\\WebContent\\images";

		MultipartRequest multi = new MultipartRequest(request, savePath, 10 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());
		MemberDTO member = new MemberDTO();
		String mid = multi.getParameter("mid");
		String mpassword = multi.getParameter("mpassword");
		String mname = multi.getParameter("mname");
		String memail = multi.getParameter("memail");
		String mphone = multi.getParameter("mphone");
		String mfile = multi.getOriginalFileName((String) multi.getFileNames().nextElement());

		member.setMid(mid);
		member.setMpassword(mpassword);
		member.setMname(mname);
		member.setMemail(memail);
		member.setMphone(mphone);
		member.setMfile(mfile);

		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int joinResult = mDAO.boardJoin(member);
		mDAO.dbClose();

		return joinResult;
	}

}