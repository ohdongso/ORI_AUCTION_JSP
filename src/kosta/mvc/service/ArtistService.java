package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArtistDTO;
import kosta.mvc.dto.MemberDTO;

public interface ArtistService {
	/**
	 * 작가 등록
	 */
	void registArtist(ArtistDTO artistDTO)throws SQLException;

	/**
	 * 전체 작가 조회
	 */
	public List<ArtistDTO> selectAllArtist()throws SQLException;


	/**
	 * 키워드로 작가 검색
	 */
	List<ArtistDTO> selectByState(String keyField, String keyWord)throws SQLException ;

	/**
	 * 아티스트 정보 수정
	 */
	void updateArtist(ArtistDTO aritstDTO)throws SQLException ;

	/**
	 * 아티스트 삭제
	 */
	void deleteArtist(String id)throws SQLException ;
}
