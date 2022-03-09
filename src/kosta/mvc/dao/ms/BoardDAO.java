package kosta.mvc.dao.ms;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.BoardDTO;

public interface BoardDAO {
	/**
	 * 전체조회
	 * */
	List<BoardDTO> selectAll(int pageNo) throws SQLException;
	
	
	
	/**
	 * 상세보기(코드번호)
	 * */
	BoardDTO selectByBoardCode(int boardCode) throws SQLException;
	
	/**
	 * keyField에 다른 조회
	 * (제목, 분류, 작성자,내용 검색)
	 * */
	List<BoardDTO> searchByKeyField(String keyField, String keyWord) throws SQLException;
	
	/**
	 * 카테고리마다 다른 조회
	 * */
	List<BoardDTO> searchByCategory(int boardCategory) throws SQLException;
		
	/**
	 * 등록하기
	 * */
	int insert(BoardDTO boardDTO) throws SQLException;
	
	/**
	 * 코드번호에 해당하는 레코드 수정하기
	 * */
	int update(BoardDTO boardDTO)throws SQLException;
	
	/**
	 * 코드번호, id 해당하는 레코드 삭제하기
	 * */
	int delete(int boardCode,String id)throws SQLException;
	
	/**
	 * 조회수 증가하는 기능
	 * */
	int increamentByViews(int boardCode) throws SQLException;
	
	/**
	 * 코드번호, id 해당하는 레코드 삭제하기(관리자)
	 * */	
	int deleteAdmin(int boardCode,String id)throws SQLException;
	
	
	
	
}
