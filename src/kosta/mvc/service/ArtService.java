package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArtDTO;

public interface ArtService {

	/**
	 * 전체 작품 검색
	 * */
	List<ArtDTO> selectAll() throws SQLException;
	
	/**
	 * 작품 코드로 검색
	 * */
	ArtDTO searchByArtCode(int code) throws SQLException;
	
	/**
	 * KeyField와 KeyWord로 검색(관리자)
	 * */
	List<ArtDTO> searchByKeyWord(String keyField, String keyWord) throws SQLException;
	
	/**
	 * KeyField와 KeyWord로 검색(일반회원)
	 * */
	List<ArtDTO> searchByKeyWordUser(String keyField, String keyWord, String id) throws SQLException;
	
	/**
	 * 작품 사이즈로 검색 (회화, 사진)
	 * */
	List<ArtDTO> searchBySize(int minHeight, int maxHeight, int minWidth, int maxWidth) throws SQLException;
	
	/**
	 * 작품 사이즈로 검색 (조각, 공예)
	 * */
	List<ArtDTO> searchBySize(int minHeight, int maxHeight, int minWidth, int maxWidth, int minVol, int maxVol) throws SQLException;
	
	/**
	 * 작품 등록(일반)
	 * */
	void insertArt(ArtDTO artDTO) throws SQLException;
	
	/**
	 * 작품 등록(제로베이스)
	 * */
	void insertArtZB(ArtDTO artDTO) throws SQLException;
	
	/**
	 * 작품 수정
	 * */
	void updateArt(ArtDTO artDTO) throws SQLException;
	
	/**
	 * 작품 삭제
	 * */
	void deleteArt(int artCode) throws SQLException;

}
