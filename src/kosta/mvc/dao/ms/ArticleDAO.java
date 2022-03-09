package kosta.mvc.dao.ms;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArticleDTO;

public interface ArticleDAO {
	
	
	/**
	 * 전체 조회하기(글번호, 링크 ,제목)
	 * */	
	List<ArticleDTO> selectAll(int pageNo) throws SQLException;
	
	/**
	 * 상세보기(코드번호)
	 * */
	ArticleDTO selectByAtcCode(int atcCode) throws SQLException;
	/**
	 * 등록하기
	 * 
	 * */
	int insert(ArticleDTO articleDTO) throws SQLException;
	
	/**
	 * 수정하기 
	 * 
	 * */
	int update(ArticleDTO articleDTO) throws SQLException;
	
	/**
	 * 삭제하기(코드를 가져와서 삭제)
	 * 
	 * */
	int delete(int atcCode) throws SQLException;
	
	 
}
