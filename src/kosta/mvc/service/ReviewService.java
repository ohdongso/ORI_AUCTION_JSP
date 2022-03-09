package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ReviewBoardDTO;

public interface ReviewService {
	
	/**
	 * 리뷰의 모든 레코드 검색하는 메소드
	 * */
	List<ReviewBoardDTO> selectAll(int pageNo) throws SQLException;
	
	/**
	 * 리뷰글 상세보기
	 * */
	ReviewBoardDTO selectByReviewCode(int reviewCode, boolean flag) throws SQLException;
	
	/**
	 * 항목 + 키워드에 해당하는 리뷰 검색 (작가명 + 이 / 작품명 + kosta)
	 * */
	List<ReviewBoardDTO> searchBykeyField(String keyField, String keyWord) throws SQLException;
	
	
	/**
	 * 리뷰 글 작성
	 * id : session storage를 통해 가져옴
	 * artCode : 작품 선택창을 통해 가져옴
	 * */
	void insert(ReviewBoardDTO review)throws SQLException;
	
	/**
	 * 글 수정
	 * */
	void update(ReviewBoardDTO review) throws SQLException;
	
	/**
	 * 글 삭제
	 * */
	void delete(String id, int reviewCode)throws SQLException;

	List<ArtDTO> getArtList(String id) throws SQLException;
	
}
