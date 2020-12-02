package Service;


import DAO.MemberDAO;
import DTO.FollowDTO;

public class BoardFollowService {

	public int memberfollow(String mid, String bwriter) {
		FollowDTO follow = new FollowDTO();
		follow.setMfollow(mid);
		follow.setMid(bwriter);
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int followResult = mDAO.memberFollow(follow);
		mDAO.dbClose();
		return followResult;
	}

	

}
