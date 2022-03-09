package kosta.mvc.dao.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ConsignmentDTO;
import kosta.mvc.dto.ConsignmentReplyDTO;
import kosta.mvc.dto.ReviewBoardDTO;
import kosta.mvc.util.DbUtil;

public class ConsignmentDAOImpl implements ConsignmentDAO {

	@Override
	public int insert(ConsignmentDTO consignmentDTO) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "INSERT INTO CONSIGNMENT VALUES(CONSIGN_SEQ.NEXTVAL, ?,?, SYSDATE, 1, ?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, consignmentDTO.getUserId());
			ps.setInt(2, consignmentDTO.getArtCode());
			ps.setInt(3, consignmentDTO.getConsignCategory());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public List<ConsignmentDTO> selectById(String id) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<ConsignmentDTO> list = new ArrayList<ConsignmentDTO>();
		String sql = "SELECT CONSIGN_CODE, ID, ART_CODE, TO_CHAR(CONSIGN_DATE, 'YYYY-MM-DD HH24:MI:SS'), CONSIGN_STATE, CONSIGN_CATEGORY FROM CONSIGNMENT WHERE ID=? ORDER BY CONSIGN_DATE DESC";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs= ps.executeQuery();
			while(rs.next()) {
				ConsignmentDTO cons = new ConsignmentDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				list.add(cons);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ConsignmentDTO> selectAll() throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<ConsignmentDTO> list = new ArrayList<ConsignmentDTO>();
		String sql = "SELECT CONSIGN_CODE, ID, ART_CODE, TO_CHAR(CONSIGN_DATE, 'YYYY-MM-DD HH24:MI:SS'), CONSIGN_STATE, CONSIGN_CATEGORY FROM CONSIGNMENT  ORDER BY CONSIGN_DATE DESC";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				ConsignmentDTO cons = new ConsignmentDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				list.add(cons);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int updateConsignState() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ArtDTO> selectArtById(String id) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<ArtDTO> list = new ArrayList<ArtDTO>();
		String sql = "SELECT ART_CODE, ART_NAME, ARTIST_NAME, ART_CATEGORY, ART_STATE, ART_SIZE_HEIGHT, ART_SIZE_WIDTH, ART_SIZE_VOL, ESTIMATE_COST, TO_CHAR(PRD_YEAR, 'YYYY'),ART_DETAIL, ART_IMG FROM ARTS WHERE ID=? AND ART_STATE=1";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs= ps.executeQuery();
			while(rs.next()) {
				ArtDTO art = new ArtDTO(rs.getInt(1), id, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
				list.add(art);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public ConsignmentDTO selectByCode(int consignCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		ConsignmentDTO consign = null;
		String sql = "SELECT CONSIGN_CODE, ID, ART_CODE, TO_CHAR(CONSIGN_DATE,'YYYY-MM-DD HH24:MI:SS'), CONSIGN_STATE, CONSIGN_CATEGORY FROM CONSIGNMENT WHERE CONSIGN_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, consignCode);
			rs= ps.executeQuery();
			if(rs.next()) {
				consign = new ConsignmentDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				consign.setArt(this.getArt(rs.getInt(3)));
				consign.setReply(this.getReply(consignCode));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return consign;
	}
	@Override
	public ArtDTO getArt(int artCode)throws SQLException{
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		ArtDTO art = null;
		String sql = "SELECT ART_CODE, ART_NAME, ARTIST_NAME, ART_CATEGORY, ART_STATE, ART_SIZE_HEIGHT, ART_SIZE_WIDTH, ART_SIZE_VOL, ESTIMATE_COST, TO_CHAR(PRD_YEAR, 'YYYY'),ART_DETAIL, ART_IMG FROM ARTS WHERE ART_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, artCode);
			rs= ps.executeQuery();
			if(rs.next()) {
				art = new ArtDTO(rs.getInt(1), null, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return art;
		
	}

	@Override
	public int delete(int consignCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "DELETE FROM CONSIGNMENT WHERE CONSIGN_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, consignCode);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public ConsignmentReplyDTO getReply(int consignCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		ConsignmentReplyDTO reply = null;
		String sql = "SELECT CONSIGN_REPLY_CODE, CONSIGN_CODE, ID, CONSIGN_REPLY_CONTENTS, TO_CHAR(CONSIGN_REPLY_RDATE, 'YYYY-MM-DD HH24:MI:SS') FROM CONSIGNMENT_REPLY WHERE CONSIGN_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, consignCode);
			rs= ps.executeQuery();
			if(rs.next()) {
				reply = new ConsignmentReplyDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5) );
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return reply;
	}

	@Override
	public boolean check(int artCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		boolean result = false;
		String sql = "SELECT * FROM AUCTION WHERE ART_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, artCode);
			rs= ps.executeQuery();
			if(rs.next()) {
				result=true;
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

}
