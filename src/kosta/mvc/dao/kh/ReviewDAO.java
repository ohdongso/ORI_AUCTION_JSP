package kosta.mvc.dao.kh;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ReviewBoardDTO;
import kosta.mvc.dto.ReviewBoardReplyDTO;

public interface ReviewDAO {
	
	/**
	 * 리뷰 전체 검색
	 * */
	List<ReviewBoardDTO> selectAll(int pageNo) throws SQLException;
	
	/**
	 * 리뷰글 상세보기
	 * */
	ReviewBoardDTO selectByReviewCode(int reviewCode) throws SQLException;
	
	/**
	 * 항목 + 키워드에 해당하는 리뷰 검색 (작가명 + 이 / 작품명 + kosta)
	 * */
	List<ReviewBoardDTO> searchBykeyField(String keyField, String keyWord) throws SQLException;
	
	/**
	 * 조회수 증가하는 기능
	 * UPDATE REVIEW_BOARD SET REVIEW_VIEWS = REVIEW_VIEWS+1 WHERE REVIEW_CODE =?
	 * @return : 1-조회수증가, 0-조회수증가안함
	 * */
	int increamentViews(int reviewCode)throws SQLException;
	
	/**
	 * 리뷰 글 작성
	 * id : session storage를 통해 가져옴
	 * artCode : 작품 선택창을 통해 가져옴
	 * @return : 1-작성성공, 0-작성실패
	 * */
	int insert(ReviewBoardDTO review)throws SQLException;
	
	/**
	 * 글 수정
	 * @return : 1-수정성공, 0-수정실패
	 * */
	int update(ReviewBoardDTO review) throws SQLException;
	
	/**
	 * 글 삭제
	 * @return : 1-삭제성공, 0-삭제실패
	 * */
	int delete(String id, int reviewCode)throws SQLException;
	
	/**
	 * 리뷰에 해당하는 작품 정보 가져오기
	 * */
	ArtDTO getArt(int artCode) throws SQLException;

	List<ArtDTO> getArtList(String id) throws SQLException;
	
}
