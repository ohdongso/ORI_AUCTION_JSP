package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dto.BoardReplyDTO;


public interface BoardReplyService {
	
	
	
	/**
	 * 게시판글 에 댓글 작성하기
	 * 
	 * */
	void insert(BoardReplyDTO boardReplyDTO)throws SQLException;
	
	/**
	 * 작성한 댓글 수정하기
	 * */
	void update(BoardReplyDTO boardReplyDTO)throws SQLException;
	
	/**
	 * 작성한 댓글 삭제하기
	 * */
	void delete(String id, int BoardReplyCode)throws SQLException;
}
