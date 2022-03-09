package kosta.mvc.dao.kh;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ReviewBoardReplyDTO;

public interface ReviewReplyDAO {
	
	/**
	 * 리뷰글에 해당하는 댓글 불러오기
	 * */
	List<ReviewBoardReplyDTO> selectByReviewCode(int reviewCode) throws SQLException;
	
	/**
	 * 리뷰글에 해당하는 모든 댓글 삭제하기(글 삭제를 위해서)
	 * */
	int deleteAll(int reviewCode) throws SQLException;
	
	/**
	 * 리뷰글에 댓글 작성하기
	 * @return : 1-작성성공, 0-작성실패
	 * */
	int insert(ReviewBoardReplyDTO reply)throws SQLException;
	
	/**
	 * 작성한 댓글 수정하기
	 * */
	int update(ReviewBoardReplyDTO reply)throws SQLException;
	
	/**
	 * 작성한 댓글 삭제하기
	 * */
	int delete(String id, int replyCode)throws SQLException;
	
}
