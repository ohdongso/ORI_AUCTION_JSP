package kosta.mvc.dao.dh;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArtDTO;

public interface ArtDAO {
	
	/**
	 * 작품 등록(일반)
	 * */
	int insertArt(ArtDTO artDTO) throws SQLException;
	
	/**
	 * 작품 등록(제로베이스)
	 * */
	int insertArtZB(ArtDTO artDTO) throws SQLException;
	
	/**
	 * 작품 전체 검색  --by 관리자
	 * */
	List<ArtDTO> selectAll() throws SQLException;
	
	/**
	 * 작품 코드로 검색
	 * */
	ArtDTO searchByArtCode(int code) throws SQLException;
	
	/**
	 * keyField와 keyword로 검색(관리자)
	 * */
	List<ArtDTO> searchByKeyField(String keyField, String keyWord) throws SQLException;
	
	/**
	 * keyField와 keyword로 검색(일반회원)
	 * */
	List<ArtDTO> searchByKeyWordUser(String keyField, String keyWord, String id) throws SQLException;
	
	/**
	 * 작품 사이즈로 검색 (회화, 사진)
	 *  - 인수 : height, width
	 * */
	List<ArtDTO> searchBySize(int minHeight, int maxHeight, int minWidth, int maxWidth) throws SQLException;
	
	/**
	 * 작품 사이즈로 검색 (조각, 공예)
	 *  - 인수 : height, width, vol
	 * */
	List<ArtDTO> searchBySize(int minHeight, int maxHeight, int minWidth, int maxWidth, int minVol, int maxVol) throws SQLException;
	
	/**
	 * 작품 코드에 해당하는 작품 수정 -- by관리자(작품 상태 변경할 때)
	 * */
	int updateArt(ArtDTO artDTO) throws SQLException;
	
	/**
	 * 작품 코드에 해당하는 작품 삭제 -- by관리자
	 * */
	int deleteArt(int code) throws SQLException;

	
}
