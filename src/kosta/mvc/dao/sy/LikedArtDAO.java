package kosta.mvc.dao.sy;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.LikedArtDTO;

public interface LikedArtDAO {
	
	//갑자기 든 의문 - 일반 사용자는 작품 목록을 못볼텐데 관심 경매 등록이 맞지 않나...?
	
	/**
	 * 관심 작품 등록하기
	 */
	int registInterest(LikedArtDTO likedArt)throws SQLException;
	
	/**
	 * 관심 작품목록 조회하기
	 */
	List<LikedArtDTO> selectAll(String id)throws SQLException;
	
	/**
	 * 관심 작품 삭제하기
	 */
	int deleteInterest(int aucCode, String id)throws SQLException;
	
	/**
	 * 아트코드에 해당하는 아트 정보 받아오기
	 */
	ArtDTO getArt(int actCode)throws SQLException;

	boolean check(String id, int aucCode)throws SQLException;

}
