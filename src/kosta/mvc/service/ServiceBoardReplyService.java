package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ServiceBoardDTO;
import kosta.mvc.dto.ServiceBoardReplyDTO;

public interface ServiceBoardReplyService {
	/**
	 * 1대1문의 에 답변 작성하기
	 * @return : 1-작성성공, 0-작성실패
	 * */
	void insert(ServiceBoardReplyDTO serviceBoardReplyDTO)throws SQLException;
	
	/**
	 * 작성한 답변 수정하기
	 * */
	void update(ServiceBoardReplyDTO serviceBoardReplyDTO)throws SQLException;
	
	/**
	 * 작성한 답변 삭제하기
	 * */
	void delete(String id, int serviceReplyCode)throws SQLException;
}
