package Service;

import DAO.MemberDAO;
import DTO.FollowDTO;

public class BoardFollowListService {

	public FollowDTO followList(String mid) {
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		FollowDTO memberFollow = mDAO.followList(mid);
		mDAO.dbClose();
		return memberFollow;
	}


}
