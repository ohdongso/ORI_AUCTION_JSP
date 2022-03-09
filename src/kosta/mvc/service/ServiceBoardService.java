package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ServiceBoardDTO;

public interface ServiceBoardService {
	/**
	  *전체 글 출력
	  * */
	  List<ServiceBoardDTO> selectAll() throws SQLException;
	  
	  /**
	   * 글 상세보기
	   * */
	ServiceBoardDTO selectByServiceBoardCode(int serviceBoardCode) throws SQLException;
	  
	  /**
	  * 카테고리 글 검색_1-회원정보 / 2-경매 / 3-위탁 / 4-배송 / 5-기부 / 6-기타
	  * */
	 List<ServiceBoardDTO> searchByServiceBoardCategory(int serviceBoardCategory) throws SQLException;
	 
	 /**
	  *  키워드 검색_제목, 분류, 작성자, 내용 검색
	  * */
	 List<ServiceBoardDTO> searchByServiceBoardKeyField(String serviceBoardKeyField, String serviceBoardKeyword) throws SQLException;
	 
	 /**
	  * 내 답변 모아 보기
	  * */
	// List<ServiceBoardDTO> selectByServiceBoardCode(String id) throws SQLException;
	  
	/**
	 * 글 작성
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 * */
	 void insert(ServiceBoardDTO serviceBoardDTO) throws SQLException;
	  
	  /**
	   * 글 상태_1-처리중 / 2-답변완료
	   *  @return : 1-수정성공 , 0 - 수정실패
	   * */
	 void updateByServiceBoardState(ServiceBoardDTO serviceBoardDTO) throws SQLException;
	  
	   /**
	    * 글 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	 void update(ServiceBoardDTO serviceBoardDTO) throws SQLException;
	  
	  /**
	   * 글 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	 void delete(int serviceBoardCod,String id ) throws SQLException;

	
		  
}

