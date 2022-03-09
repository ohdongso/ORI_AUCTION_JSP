package kosta.mvc.dao.sh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.FaqDTO;
import kosta.mvc.dto.ServiceBoardDTO;
import kosta.mvc.dto.ServiceBoardReplyDTO;
import kosta.mvc.util.DbUtil;

public class ServiceBoardDAOImpl implements ServiceBoardDAO {

	@Override
	public List<ServiceBoardDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ServiceBoardDTO> list = new ArrayList<ServiceBoardDTO>();
		String sql = 
				"SELECT * FROM SERVICE_BOARD ORDER BY S_BOARD_DATE DESC";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ServiceBoardDTO ServiceBoard = new ServiceBoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
				list.add(ServiceBoard);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public ServiceBoardDTO selectByServiceBoardCode(int serviceBoardCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ServiceBoardDTO result = null;
		String sql = "SELECT * FROM SERVICE_BOARD WHERE S_BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, serviceBoardCode);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = new ServiceBoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7));
				result.setReply(this.getReply(rs.getInt(1)));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

	@Override
	public List<ServiceBoardDTO> searchByServiceBoardCategory(int serviceBoardCategory) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ServiceBoardDTO> list = new ArrayList<ServiceBoardDTO>();
		String sql = "SELECT * FROM SERVICE_BOARD WHERE S_BOARD_CATEGORY=?  ORDER BY S_BOARD_DATE DESC ";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, serviceBoardCategory);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ServiceBoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7)));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ServiceBoardDTO> searchByServiceBoardKeyField(String serviceBoardKeyField, String serviceBoardKeyword)
			throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ServiceBoardDTO> list = new ArrayList<ServiceBoardDTO>();
		String sql = "SELECT * FROM SERVICE_BOARD ";
		try {
			switch (serviceBoardKeyField) {
			case "title":
				sql += "WHERE S_BOARD_TITLE like ?";
				break;
			case "content":
				sql += "WHERE S_BOARD_CONTENT like ?";
				break;
			case "writer":
				sql += "WHERE ID like ?";
				break;
			}
			sql += " ORDER BY S_BOARD_DATE DESC";
			System.out.println(sql);

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + serviceBoardKeyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ServiceBoardDTO ServiceBoard = new ServiceBoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
				list.add(ServiceBoard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int insert(ServiceBoardDTO serviceBoardDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO SERVICE_BOARD VALUES(SERVICE_SEQ.NEXTVAL,?,?,?,?,sysdate,0)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, serviceBoardDTO.getId());
			ps.setString(2, serviceBoardDTO.getServiceBoardTitle());
			ps.setString(3, serviceBoardDTO.getServiceBoardContent());
			ps.setInt(4, serviceBoardDTO.getServiceBoardCategory());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(ServiceBoardDTO serviceBoardDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = 
		"UPDATE SERVICE_BOARD SET S_BOARD_TITLE  = ? , S_BOARD_CONTENT = ? ,S_BOARD_CATEGORY=?  WHERE S_BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, serviceBoardDTO.getServiceBoardTitle());
			ps.setString(2, serviceBoardDTO.getServiceBoardContent());
			ps.setInt(3, serviceBoardDTO.getServiceBoardCategory());
			ps.setInt(4, serviceBoardDTO.getServiceBoardCode());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete( int serviceBoardCode,String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM SERVICE_BOARD WHERE S_BOARD_CODE=? AND ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, serviceBoardCode);
			ps.setString(2, id);

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	

	@Override
	public int updateByServiceBoardState(ServiceBoardDTO serviceBoardDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(int serviceBoardCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ServiceBoardReplyDTO getReply(int serviceBoardCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ServiceBoardReplyDTO reply = null;
		String sql = 
		"SELECT S_BOARD_REPLY_CODE, S_BOARD_CODE, ID, S_BOARD_REPLY_CONTENT, TO_CHAR(S_BOARD_REPLY_DATE, 'YYYY-MM-DD HH24:MI:SS') FROM SERVICE_BOARD_REPLY WHERE S_BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, serviceBoardCode);
			rs = ps.executeQuery();
			if (rs.next()) {
				reply = new ServiceBoardReplyDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return reply;
	}

	@Override
	public void setState(int serviceBoardCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE SERVICE_BOARD SET S_BOARD_STATE=1 WHERE S_BOARD_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, serviceBoardCode);
			ps.executeUpdate();

			
		} finally {
			DbUtil.dbClose(ps, con);
		}
	}

	
}
