package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ReviewBoardDTO;
import kosta.mvc.dto.ReviewBoardReplyDTO;

public interface ReviewReplyService {
	
	/**
	 * 리뷰글에 댓글 작성하기
	 * @return : 1-작성성공, 0-작성실패
	 * */
	void insert(ReviewBoardReplyDTO reply)throws SQLException;
	
	/**
	 * 작성한 댓글 수정하기
	 * */
	void update(ReviewBoardReplyDTO reply)throws SQLException;
	
	/**
	 * 작성한 댓글 삭제하기
	 * */
	void delete(String id, int replyCode)throws SQLException;
}
