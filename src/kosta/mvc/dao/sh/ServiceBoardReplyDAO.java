package kosta.mvc.dao.sh;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ServiceBoardReplyDTO;

public interface ServiceBoardReplyDAO {
	
	/**
	 *글 검색
	 * */
	List<ServiceBoardReplyDTO> selectByServiceReplyCode(int serviceReplyCode) throws SQLException;
	
	/**
	 *모든 답변 삭제하기
	 * */
	int deleteAll(int serviceReplyCode) throws SQLException;
	
	/**
	 * 답변 작성
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 * */
	  int insert(ServiceBoardReplyDTO serviceBoardReplyDTO) throws SQLException;
	  
	  /**
	   * 글 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	  int delete(int serviceReplyCode, String id) throws SQLException;
	  
	   /**
	    * 글 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	  int update(ServiceBoardReplyDTO serviceBoardReplyDTO) throws SQLException;

}
