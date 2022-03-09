package kosta.mvc.dao.sh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto. ServiceBoardReplyDTO;
import kosta.mvc.util.DbUtil;

public class ServiceBoardReplyDAOImpl implements ServiceBoardReplyDAO {
	 
	@Override
	public List<ServiceBoardReplyDTO> selectByServiceReplyCode(int serviceReplyCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ServiceBoardReplyDTO> sReplyList = new ArrayList<ServiceBoardReplyDTO>();
		String sql="SELECT S_BOARD_CODE, ID, S_BOARD_REPLY_CONTENT, TO_CHAR(S_BOARD_REPLY_DATE, 'YYYY-MM-DD HH24:MI:SS'), S_BOARD_REPLY_CODE FROM SERVICE_BOARD_REPLY WHERE S_BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, serviceReplyCode);
			rs= ps.executeQuery();
			while(rs.next()) {
				ServiceBoardReplyDTO serviceBoardReplyDTO = new ServiceBoardReplyDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				sReplyList.add(serviceBoardReplyDTO);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return sReplyList;
	}


	@Override
	public int insert(ServiceBoardReplyDTO serviceBoardReplyDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql="INSERT INTO SERVICE_BOARD_REPLY VALUES(SERVICE_R_SEQ.nextval,?,?,?,SYSDATE)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, serviceBoardReplyDTO.getServiceBoardCode());
			ps.setString(2, serviceBoardReplyDTO.getId());
			ps.setString(3, serviceBoardReplyDTO.getServiceReplyContent());
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}


	@Override
	public int update(ServiceBoardReplyDTO serviceBoardReplyDTO) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE SERVICE_BOARD_REPLY SET S_BOARD_REPLY_CONTENT = ? WHERE S_BOARD_REPLY_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, serviceBoardReplyDTO.getServiceReplyContent());
			ps.setInt(2, serviceBoardReplyDTO.getServiceReplyCode());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}
	

	@Override
	public int delete(int serviceReplyCode, String id) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM SERVICE_BOARD_REPLY WHERE S_BOARD_REPLY_CODE=? AND ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, serviceReplyCode);
			ps.setString(2, id);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}


	@Override
	public int deleteAll(int serviceReplyCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM SERVICE_BOARD_REPLY WHERE S_BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, serviceReplyCode);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}
}	
