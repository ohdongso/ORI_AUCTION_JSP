package kosta.mvc.dao.sh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.DonationDTO;
import kosta.mvc.util.DbUtil;

public class DonationDAOImpl implements DonationDAO {
	
	// 전체 검색
	@Override
	public List<DonationDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<DonationDTO> list = new ArrayList<DonationDTO>();
		
		String sql = "SELECT DON_CODE, DON_TITLE, DON_CONTENTS, DON_DATE, to_char(DON_RDATE, 'YYYY-MM-DD') FROM DONATION ORDER BY DON_CODE";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				DonationDTO donationDTO = new DonationDTO(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5));
				
				list.add(donationDTO);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	//상세보기
	@Override
	public DonationDTO selectByDonCode(int donCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		DonationDTO donationDTO =null;
		
		String sql="SELECT DON_CODE, DON_TITLE, DON_CONTENTS, to_char(DON_DATE, 'YYYY-MM-DD'), to_char(DON_RDATE, 'YYYY-MM-DD') FROM DONATION WHERE DON_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, donCode);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				donationDTO =new DonationDTO(rs.getInt(1), rs.getString(2),rs.getString(3), 
						rs.getString(4), rs.getString(5));
			}			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return donationDTO;
	}

	//글 등록하기
	@Override
	public int insert(DonationDTO donationDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "INSERT INTO DONATION VALUES(DON_SEQ.NEXTVAL,?,?,?, sysdate)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, donationDTO.getDonTitle());
			ps.setString(2, donationDTO.getDonContent());
			ps.setString(3, donationDTO.getDonDate());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

	//글 수정하기
	@Override
	public int update(DonationDTO donationDTO) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE DONATION SET DON_TITLE = ?, DON_CONTENTS=?, DON_DATE=? WHERE DON_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, donationDTO.getDonTitle());
			ps.setString(2, donationDTO.getDonContent());
			ps.setString(3, donationDTO.getDonDate());
			ps.setInt(4, donationDTO.getDonCode());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

	//글 삭제하기
	@Override
	public int delete(int donCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM DONATION WHERE DON_CODE=?";		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, donCode);

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
}