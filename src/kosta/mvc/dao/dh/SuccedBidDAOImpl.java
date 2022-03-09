package kosta.mvc.dao.dh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.SuccedBidDTO;
import kosta.mvc.util.DbUtil;

public class SuccedBidDAOImpl implements SuccedBidDAO {

	//낙찰 경매 등록
	@Override
	public int insert(SuccedBidDTO succedBidDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	//낙찰 경매 전체 검색
	@Override
	public List<SuccedBidDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SuccedBidDTO> list = new ArrayList<SuccedBidDTO>();
		
		String sql = "SELECT * FROM SUCCED_BID ORDER BY SUC_BID_CODE";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				SuccedBidDTO succedBidDTO = new SuccedBidDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
				list.add(succedBidDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}		
		return list;
	}

	//결제된 경매 상태 변경
	@Override
	public int changeState(int sucBidCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "UPDATE SUCCED_BID SET SUC_BID_STATE=2 WHERE SUC_BID_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, sucBidCode);
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
	
	//낙찰코드로 낙찰경매 검색
	@Override
	public SuccedBidDTO searchBySucBidCode(int sucBidCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	//경매코드로 낙찰경매 검색
	@Override
	public SuccedBidDTO searchByAucCode(int aucCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 사용자ID로 낙찰경매 검색
	@Override
	public List<SuccedBidDTO> searchByUserId(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SuccedBidDTO> list = new ArrayList<SuccedBidDTO>();
		
		String sql = "SELECT * FROM SUCCED_BID WHERE ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				SuccedBidDTO succedBidDTO = new SuccedBidDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
				list.add(succedBidDTO);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}		
		return list;
	}
	
	
	@Override
	public SuccedBidDTO searchByArtCode(int artCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SuccedBidDTO> searchBySucBidCost(int minSucBidCost, int maxSucBidCost) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	//낙찰결과 수정
	@Override
	public int updateSucBid(SuccedBidDTO succedBidDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	//낙찰경매 삭제
	@Override
	public int deleteSucBid(int sucBidCode, String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "DELETE SUCCED_BID WHERE SUC_BID_CODE=? AND ID=?"; 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, sucBidCode);
			ps.setString(2, id);

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

}
