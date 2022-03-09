package kosta.mvc.dao.sy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.LikedArtDTO;
import kosta.mvc.dto.MemberDTO;
import kosta.mvc.util.DbUtil;

public class LikedArtDAOImpl implements LikedArtDAO {
	
	/**
	 * 관심 경매 등록
	 */
	@Override
	public int registInterest(LikedArtDTO likedArtDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO LIKED_ART VALUES(LIKED_SEQ.NEXTVAL,?,?)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, likedArtDTO.getId());
			ps.setInt(2, likedArtDTO.getAucCode());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * 관심 경매 조회
	 */
	@Override
	public List<LikedArtDTO> selectAll(String id) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<LikedArtDTO> list = new ArrayList<LikedArtDTO>();
		String sql = "SELECT LIKED_CODE, ID, AUC_CODE, ART_CODE FROM AUCTION JOIN LIKED_ART USING(AUC_CODE) WHERE ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				LikedArtDTO likedArtDTO = new LikedArtDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
				likedArtDTO.setArtDTO(this.getArt(rs.getInt(4)));
				list.add(likedArtDTO);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	/**
	 * 관심 경매 삭제
	 */
	@Override
	public int deleteInterest(int aucCode, String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql ="DELETE FROM LIKED_ART WHERE AUC_CODE=? AND ID=?";
		int result=0;
		System.out.println(aucCode);
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aucCode);
			ps.setString(2, id);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * 아트코드에 해당하는 아트 정보 받아오기
	 */
	@Override
	public ArtDTO getArt(int artCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArtDTO artDTO = null;
		String sql = "SELECT ART_CODE, ID, ARTIST_CODE, ART_NAME, ARTIST_NAME, "
				+ "ART_CATEGORY, ART_STATE, ART_SIZE_HEIGHT, ART_SIZE_WIDTH, ART_SIZE_VOL, "
				+ "ESTIMATE_COST, TO_CHAR(PRD_YEAR, 'YYYY'), ART_DETAIL, ART_IMG FROM ARTS WHERE ART_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, artCode);
			rs = ps.executeQuery();
			while(rs.next()) {
				artDTO = new ArtDTO(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6), 
						rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getString(12), 
						rs.getString(13), rs.getString(14));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return artDTO;
	}

	@Override
	public boolean check(String id,int aucCode) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result=false;
		String sql = "SELECT*FROM LIKED_ART WHERE ID=? AND AUC_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, aucCode);
			rs = ps.executeQuery();
			if(rs.next()) {
				result=true;
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}
	
}
