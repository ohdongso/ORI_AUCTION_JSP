package kosta.mvc.dao.sy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ArtistDTO;
import kosta.mvc.dto.MemberDTO;
import kosta.mvc.util.DbUtil;

public class ArtistDAOImpl implements ArtistDAO {
	/**
	 * 작가 등록
	 */
	@Override
	public int registArtist(ArtistDTO artistDTO) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO ARTIST VALUES (ARTIST_SEQ.NEXTVAL,?,?,?,?,?)";
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, artistDTO.getId());
			ps.setString(2, artistDTO.getArtistImg());
			ps.setString(3, artistDTO.getCareer());
			ps.setString(4, artistDTO.getArtistDetail());
			ps.setString(5, artistDTO.getProfileLink());
			this.changeState(artistDTO.getId(), 2);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	/**
	 * 상태변경
	 */
	@Override
	public int changeState(String id, int state) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "UPDATE MEMBER SET MEM_STATE=? WHERE ID=?";
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(2, id);		
			ps.setInt(1, state);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	

	/**
	 * 아티스트 정보 수정
	 */
	@Override
	public int updateArtist(ArtistDTO artistDTO) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "UPDATE ARTIST SET CAREER=?, ARTIST_DETAIL=?, PROFILE_LINK=?, ARTIST_IMG=? WHERE ID=?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, artistDTO.getCareer());
			ps.setString(2, artistDTO.getArtistDetail());
			ps.setString(3, artistDTO.getProfileLink());
			ps.setString(4, artistDTO.getArtistImg());
			ps.setString(5, artistDTO.getId());
			System.out.println(artistDTO.getArtistImg());
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * 전체 작가 목록 조회
	 */
	@Override
	public List<ArtistDTO> selectAllArtist() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="SELECT ARTIST_IMG, CAREER, ARTIST_DETAIL, PROFILE_LINK, ID"
				+" FROM ARTIST ORDER BY ARTIST_CODE";
		List<ArtistDTO> artistList = new ArrayList<ArtistDTO>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString(5);
				ArtistDTO artistDTO = new ArtistDTO(0,rs.getString(5), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				artistDTO.setMember(this.getInform(id));
				artistList.add(artistDTO);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		System.out.println(artistList);
		return artistList;
	}
	/**
	 * 작가에 대한 기본 정보 가져오기(id로 name 가져오기)
	 */
	@Override
	public MemberDTO getInform(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="SELECT NAME FROM MEMBER WHERE ID=?";
		MemberDTO memberDTO = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				memberDTO = new MemberDTO(null, null, rs.getString(1), null, null, null, null,1, null);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return memberDTO;
	}

	/**
	 * 작가 정보 삭제 - 관리자
	 */
	@Override
	public int deleteArtist(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql ="DELETE FROM ARTIST WHERE ID=?";
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			this.changeState(id, 1);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
		
	}
	/**
	 * 키워드로 작가 검색
	 */
	@Override
	public List<ArtistDTO> selectByState(String keyField, String keyWord) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ArtistDTO> list = new ArrayList<ArtistDTO>();
		String sql = "SELECT ARTIST_IMG, CAREER, ARTIST_DETAIL, PROFILE_LINK, ID, NAME FROM ARTIST JOIN MEMBER USING(ID) WHERE ";
		
		switch(keyField) {
			case	"id": sql += "ID LIKE ?"; break;
			case	"name": sql += "UPPER(NAME) LIKE UPPER(?)"; break;
			case	"career": sql += "UPPER(CAREER) LIKE UPPER(?)"; break;
			case	"artistDetail": sql += "UPPER(ARTIST_DETAIL) LIKE UPPER(?)"; break;
			case	"profileLink": sql += "UPPER(PROFILE_LINK) LIKE UPPER(?)"; break;
		}
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyWord + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				ArtistDTO artist = new ArtistDTO(0,null, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				artist.setMember(this.getInform(rs.getString(5)));
				list.add(artist);
			}
		}finally{
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	

	
	

	

}
