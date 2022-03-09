package kosta.mvc.dao.ms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import kosta.mvc.dto.BoardReplyDTO;
import kosta.mvc.dto.ReviewBoardReplyDTO;
import kosta.mvc.util.DbUtil;

public class BoardReplyDAOImpl implements BoardReplyDAO {

	@Override
	public List<BoardReplyDTO> selectByBoardCode(int boardCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardReplyDTO> boardList = new ArrayList<BoardReplyDTO>();
		String sql="SELECT BOARD_REPLY_CODE, ID, BOARD_CODE,BOARD_REPLY_CONTENT,TO_CHAR(BOARD_REPLY_RDATE, 'YYYY-MM-DD HH24:MI:SS')  FROM BOARD_REPLY WHERE BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardCode);
			rs= ps.executeQuery();
			while(rs.next()) {
				BoardReplyDTO board = new BoardReplyDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
				boardList.add(board);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return boardList;
	}
	
	

	



	@Override
	public int insert(BoardReplyDTO boardReplyDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql="INSERT INTO BOARD_REPLY VALUES(BOARD_R_SEQ.nextval,?,?,?,SYSDATE)";
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, boardReplyDTO.getId());
			ps.setInt(2, boardReplyDTO.getBoardCode()); 
			ps.setString(3, boardReplyDTO.getBoardReplyContent()); 
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(BoardReplyDTO boardReplyDTO) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE board_reply SET board_reply_content = ? WHERE board_REPlY_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, boardReplyDTO.getBoardReplyContent());
			ps.setInt(2, boardReplyDTO.getBoardReplyCode());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

	@Override
	public int delete(String id,int BoardReplyCode ) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM BOARD_REPLY WHERE BOARD_REPLY_CODE=? AND ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, BoardReplyCode);
			ps.setString(2, id);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
		
		
	}

	@Override
	public int deleteAll(int boardCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM BOARD_REPLY WHERE BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardCode);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

}
