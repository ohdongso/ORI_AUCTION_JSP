package kosta.mvc.dao.sy;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArtistDTO;
import kosta.mvc.dto.MemberDTO;

public interface ArtistDAO {
	/**
	 * 작가등록하기 ( 회원 ) 
	 */
	int registArtist(ArtistDTO artistdto)throws SQLException;
	/**
	 * 상태변경해주기
	 */
	int changeState(String id, int state)throws SQLException;
	
	/**
	 * 작가정보 수정하기 ( 회원 ) -- detail, career 수정하기 --> artistCode는 관리자와 해당 아티스트만 조회가능하게 해서...
	 */
	int updateArtist(ArtistDTO artistdto)throws SQLException;
	
	/**
	 * 등록된 작가 리스트 조회하기 ( 관리자, 회원 ) -- memState가 작가인 사람들의 artist 소개만 조회 (artist-->id로 member와 join --memState가 2인 mem만 조회)
	 */
	List<ArtistDTO> selectAllArtist()throws SQLException;
	
	/**
	 * 작가에 대한 기본 정보 받아오기 - id로 name 가져오기
	 */
	MemberDTO getInform (String id)throws SQLException;
	
	/**
	 * 등록되어있는 작가 삭제하기 ( 관리자 ) -->  memState변경 2에서 1로 -> artist테이블에서 삭제
	 */
	int deleteArtist(String id)throws SQLException;
	
	/**
	 * 키워드로 아티스트 조회하기
	 */
	List<ArtistDTO> selectByState(String keyField, String keyWord)throws SQLException;
	
	
	
}
