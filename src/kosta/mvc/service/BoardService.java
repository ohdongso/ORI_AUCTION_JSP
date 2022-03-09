package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.BoardDTO;

public interface BoardService {
	
	/**
	 * BoardDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
	List<BoardDTO> selectAll(int pageNo) throws SQLException;
	 

	/**
	 * BoardDAOImpl의 코드번호에 해당하는 레코드 검색하는 메소드 호출
	 * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	 * */
	BoardDTO selectByBoardCode(int boardCode, boolean flag) throws SQLException;
	
	/**
	 * 키워드에 해당하는 board 검색 
	 * */
	List<BoardDTO> searchBykeyField(String keyField, String keyWord) throws SQLException;
	
	/**
	 * 카테고리에 해당하는 board 검색 (공지는 무조건 가져온다)
	 * */
	List<BoardDTO> searchByCategory(int boardCategory) throws SQLException;
	
	/**
	 * BoardDAOImpl의 레코드 삽입하는 메소드 호출
	 * */
	  void insert(BoardDTO boardDTO) throws SQLException;  
	  
	/**
	 * BoardDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	* */
	   void update(BoardDTO boardDTO) throws SQLException;
	    
	/**
	 * BoardDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	* */
	    void delete(int boardCode,String id ) throws SQLException;
	  
	    /**
		 * BoardDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출(관리자)
		* */
		    void deleteAdmin(int boardCode,String id ) throws SQLException;
	  
	  
	  
	  
}
