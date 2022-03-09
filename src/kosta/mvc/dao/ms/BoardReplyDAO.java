package kosta.mvc.dao.ms;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.BoardReplyDTO;

public interface BoardReplyDAO {
	/**
	 * 답변 조회
	 * */
	List<BoardReplyDTO> selectByBoardCode(int boardCode) throws SQLException;
	
	 
	/**
	 * 답변 등록
	 * */
	int insert(BoardReplyDTO boardReplyDTO)throws SQLException;
	
	/**
	 * 답변 수정
	 * */
	int update(BoardReplyDTO boardReplyDTO)throws SQLException;
	
	/**
	 * 코드번호,id를 가져와 해당하는 답변 삭제
	 * */
	int delete(String id,int replyCode)throws SQLException;

	/**
	 * 게시글에 해당하는 모든 댓글 삭제하기(게시판글 삭제를 위해서)
	 * */
	int deleteAll(int boardNo) throws SQLException;
}
