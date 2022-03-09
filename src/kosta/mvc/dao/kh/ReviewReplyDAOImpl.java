package kosta.mvc.dao.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ReviewBoardReplyDTO;
import kosta.mvc.util.DbUtil;

public class ReviewReplyDAOImpl implements ReviewReplyDAO {

	@Override
	public List<ReviewBoardReplyDTO> selectByReviewCode(int reviewCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewBoardReplyDTO> replyList = new ArrayList<ReviewBoardReplyDTO>();
		String sql="SELECT REVIEW_CODE, ID, REVIEW_REPLY_CONTENT, TO_CHAR(REVIEW_REPLY_DATE, 'YYYY-MM-DD HH24:MI:SS'), REVIEW_REPLY_CODE FROM REVIEW_BOARD_REPLY WHERE REVIEW_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewCode);
			rs= ps.executeQuery();
			while(rs.next()) {
				ReviewBoardReplyDTO reply = new ReviewBoardReplyDTO(rs.getInt(5), rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				replyList.add(reply);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return replyList;
	}

	@Override
	public int insert(ReviewBoardReplyDTO reply) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql="INSERT INTO REVIEW_BOARD_REPLY VALUES(REVIEW_R_SEQ.nextval,?,?,?,SYSDATE)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reply.getReviewCode());
			ps.setString(2, reply.getId());
			ps.setString(3, reply.getReviewReplyContents());
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(ReviewBoardReplyDTO reply) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE REVIEW_BOARD_REPLY SET REVIEW_REPLY_CONTENT = ? WHERE REVIEW_REPlY_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getReviewReplyContents());
			ps.setInt(2, reply.getReviewReplyCode());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

	@Override
	public int delete(String id, int replyCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM REVIEW_BOARD_REPLY WHERE REVIEW_REPLY_CODE=? AND ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, replyCode);
			ps.setString(2, id);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

	@Override
	public int deleteAll(int reviewCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM REVIEW_BOARD_REPLY WHERE REVIEW_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewCode);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

}
