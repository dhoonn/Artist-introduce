package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBConnection;
import DTO.FollowDTO;
import DTO.MemberDTO;

public class MemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void dbConnection() {
		con = DBConnection.getConnection();
	}

	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void pstmtClose() {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rsClose() {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int boardJoin(MemberDTO member) {
		String sql = "INSERT INTO MEMBER(MID,MPASSWORD,MNAME,MEMAIL,MPHONE,MFILE)" + "VALUES(?,?,?,?,?,?)";
		int joinResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpassword());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMemail());
			pstmt.setString(5, member.getMphone());
			pstmt.setString(6, member.getMfile());
			joinResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return joinResult;
	}

	public boolean boardLogin(String mid, String mpassword) {
		String sql = "SELECT * FROM MEMBER WHERE MID=? AND MPASSWORD=?";
		boolean loginresult = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpassword);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				loginresult = true;
			} else {
				loginresult = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
			pstmtClose();
		}
		return loginresult;
	}

	public int memberFollow(FollowDTO follow) {
		String sql = "INSERT INTO FOLLOW(FNUMBER,MFOLLOW,MID)" + "VALUES(FOLLOW_SEQ.NEXTVAL,?,?)";
		int followResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, follow.getMfollow());
			pstmt.setString(2, follow.getMid());
			followResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return followResult;
	}

	public FollowDTO followList(String mid) {
		/* String sql = "SELECT DISTINCT MID FROM FOLLOW WHERE MFOLLOW=?"; */
		String sql = "SELECT MID FROM FOLLOW GROUP BY MID";
		FollowDTO memberFollow = null;
		System.out.println(mid+"midmid");
		try {
			pstmt = con.prepareStatement(sql);
			/* pstmt.setString(1, mid); */
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberFollow = new FollowDTO();
				memberFollow.setMid(rs.getString("MID"));
				System.out.println(memberFollow.getMid()+"dao");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return memberFollow;
	}
}
