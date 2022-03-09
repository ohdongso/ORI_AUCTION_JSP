package kosta.mvc.dao.dh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.util.DbUtil;

public class ArtDAOImpl implements ArtDAO {

	/**
	 * 작품 등록(일반)
	 * */
	@Override
	public int insertArt(ArtDTO artDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "INSERT INTO ARTS VALUES (arts_seq.nextval, ?, null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, artDTO.getId());
			ps.setString(2, artDTO.getArtName());
			ps.setString(3, artDTO.getArtistName());
			ps.setInt(4, artDTO.getArtCategory());
			ps.setInt(5, artDTO.getArtState());
			ps.setInt(6, artDTO.getArtSizeHeight());
			ps.setInt(7, artDTO.getArtSizeWidth());
			ps.setInt(8, artDTO.getArtSizeVol());
			ps.setInt(9, artDTO.getEstimateCost());
			ps.setString(10, artDTO.getPrdYear());
			ps.setString(11, artDTO.getArtDetail());
			ps.setString(12, artDTO.getArtImg());

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
	
	/**
	 * 작품 등록(제로베이스)
	 * */
	@Override
	public int insertArtZB(ArtDTO artDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "INSERT INTO ARTS VALUES (arts_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, artDTO.getId());
			ps.setInt(2, artDTO.getArtistCode());
			ps.setString(3, artDTO.getArtName());
			ps.setString(4, artDTO.getArtistName());
			ps.setInt(5, artDTO.getArtCategory());
			ps.setInt(6, artDTO.getArtState());
			ps.setInt(7, artDTO.getArtSizeHeight());
			ps.setInt(8, artDTO.getArtSizeWidth());
			ps.setInt(9, artDTO.getArtSizeVol());
			ps.setInt(10, artDTO.getEstimateCost());
			ps.setString(11, artDTO.getPrdYear());
			ps.setString(12, artDTO.getArtDetail());
			ps.setString(13, artDTO.getArtImg());

			//System.out.println("ArtDAO에서 ArtistCode 확인 : "+artDTO.getArtistCode());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * 작품 코드로 검색
	 * */
	@Override
	public ArtDTO searchByArtCode(int code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArtDTO art = null;
		String sql = "SELECT ART_CODE, ID, ARTIST_CODE, ART_NAME, ARTIST_NAME, "
				+ "ART_CATEGORY, ART_STATE, ART_SIZE_HEIGHT, ART_SIZE_WIDTH, ART_SIZE_VOL, "
				+ "ESTIMATE_COST, to_char(PRD_YEAR, 'YYYY'), "
				+ "ART_DETAIL, ART_IMG FROM ARTS WHERE ART_CODE LIKE ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				art = new ArtDTO(rs.getInt(1), rs.getString(2), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14));
				art.setArtistCode(rs.getInt(3));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return art;
	}
	
	/**
	 * 전체 작품 검색
	 * */
	@Override
	public List<ArtDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ArtDTO> list = new ArrayList<ArtDTO>();
		
		String sql = "SELECT ART_CODE, ID, ARTIST_CODE, ART_NAME, ARTIST_NAME, "
				+ "ART_CATEGORY, ART_STATE, ART_SIZE_HEIGHT, ART_SIZE_WIDTH, ART_SIZE_VOL, "
				+ "ESTIMATE_COST, to_char(PRD_YEAR, 'YYYY'), "
				+ "ART_DETAIL, ART_IMG FROM ARTS ORDER BY ART_CODE";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ArtDTO art = new ArtDTO(rs.getInt(1), rs.getString(2), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14));
				art.setArtistCode(rs.getInt(3));
				list.add(art);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}		
		return list;
	}

	/**
	 * KeyField와 KeyWord로 검색
	 *  - ART_CODE, ID, ARTIST_CODE, ART_NAME, ARTIST_NAME,
	 *    ART_CATEGORY, ART_STATE, ESTIMATE_COST, ART_DETAIL
	 * */
	@Override
	public List<ArtDTO> searchByKeyField(String keyField, String keyWord) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ArtDTO> list = new ArrayList<ArtDTO>();
		String sql = "SELECT ART_CODE, ID, ARTIST_CODE, ART_NAME, ARTIST_NAME, "
				+ "ART_CATEGORY, ART_STATE, ART_SIZE_HEIGHT, ART_SIZE_WIDTH, ART_SIZE_VOL, "
				+ "ESTIMATE_COST, to_char(PRD_YEAR, 'YYYY'), "
				+ "ART_DETAIL, ART_IMG FROM ARTS WHERE ";

		switch (keyField) {
			case "artCode": sql += "ART_CODE LIKE ?"; break;
			case "id": sql += "ID LIKE ?"; break;
			case "artistCode": sql += "ARTIST_CODE LIKE ?"; break;
			case "artName": sql += "UPPER(ART_NAME) LIKE UPPER(?)"; break;
			case "artistName": sql += "UPPER(ARTIST_NAME) LIKE UPPER(?)"; break;
			case "artCategory": sql += "ART_CATEGORY LIKE ?"; break;
			case "artState": sql += "ART_STATE LIKE ?"; break;
			case "estimateCost": sql += "ESTIMATE_COST LIKE ?"; break;
			case "artDetail": sql += "UPPER(ART_DETAIL) LIKE UPPER(?)"; break;
		}
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyWord + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ArtDTO art = new ArtDTO(rs.getInt(1), rs.getString(2), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14));
				art.setArtistCode(rs.getInt(3));
				list.add(art);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	/**
	 * KeyField와 KeyWord로 검색(일반회원)
	 * */
	@Override
	public List<ArtDTO> searchByKeyWordUser(String keyField, String keyWord, String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ArtDTO> list = new ArrayList<ArtDTO>();
		String sql = "SELECT ART_CODE, ID, ARTIST_CODE, ART_NAME, ARTIST_NAME, "
				+ "ART_CATEGORY, ART_STATE, ART_SIZE_HEIGHT, ART_SIZE_WIDTH, ART_SIZE_VOL, "
				+ "ESTIMATE_COST, to_char(PRD_YEAR, 'YYYY'), "
				+ "ART_DETAIL, ART_IMG FROM ARTS WHERE ";

		switch (keyField) {
			case "artCode": sql += "ART_CODE LIKE ? AND ID=?"; break;
			case "id": sql += "ID LIKE ? AND ID=?"; break;
			case "artistCode": sql += "ARTIST_CODE LIKE ? AND ID=?"; break;
			case "artName": sql += "UPPER(ART_NAME) LIKE UPPER(?) AND ID=?"; break;
			case "artistName": sql += "UPPER(ARTIST_NAME) LIKE UPPER(?) AND ID=?"; break;
			case "artCategory": sql += "ART_CATEGORY LIKE ? AND ID=?"; break;
			case "artState": sql += "ART_STATE LIKE ? AND ID=?"; break;
			case "estimateCost": sql += "ESTIMATE_COST LIKE ? AND ID=?"; break;
			case "artDetail": sql += "UPPER(ART_DETAIL) LIKE UPPER(?) AND ID=?"; break;
		}
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyWord + "%");
			ps.setString(2, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ArtDTO art = new ArtDTO(rs.getInt(1), rs.getString(2), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14));
				art.setArtistCode(rs.getInt(3));
				list.add(art);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ArtDTO> searchBySize(int minHeight, int maxHeight, int minWidth, int maxWidth) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArtDTO> searchBySize(int minHeight, int maxHeight, int minWidth, int maxWidth, int minVol, int maxVol)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 작품 정보 수정
	 * */
	@Override
	public int updateArt(ArtDTO artDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "UPDATE ARTS SET ART_NAME=?, ARTIST_NAME=?, ART_CATEGORY=?,"
				+ " ART_STATE=?, ART_SIZE_HEIGHT=?, ART_SIZE_WIDTH=?, ART_SIZE_VOL=?,"
				+ " ESTIMATE_COST=?, PRD_YEAR=?, ART_DETAIL=?, ART_IMG=? WHERE ART_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, artDTO.getArtName());
			ps.setString(2, artDTO.getArtistName());
			ps.setInt(3, artDTO.getArtCategory());
			ps.setInt(4, artDTO.getArtState());
			ps.setInt(5, artDTO.getArtSizeHeight());
			ps.setInt(6, artDTO.getArtSizeWidth());
			ps.setInt(7, artDTO.getArtSizeVol());
			ps.setInt(8, artDTO.getEstimateCost());
			ps.setString(9, artDTO.getPrdYear());
			ps.setString(10, artDTO.getArtDetail());
			ps.setString(11, artDTO.getArtImg());
			ps.setInt(12, artDTO.getArtCode());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * 작품 정보 삭제
	 * */
	@Override
	public int deleteArt(int code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "DELETE ARTS WHERE ART_CODE=?"; 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, code);

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}


}
