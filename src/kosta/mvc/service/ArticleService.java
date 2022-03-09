package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArticleDTO;

public interface ArticleService {
	
	/**
	 * ArticleDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
	List<ArticleDTO> selectAll(int pageNo) throws SQLException;
	
	

	/**
	 * BoardDAOImpl의 코드번호에 해당하는 레코드 검색하는 메소드 호출
	 * */
	ArticleDTO selectByAtcCode(int atcCode) throws SQLException;
	/**
	 * ArticleDAOImpl의 레코드 삽입하는 메소드 호출
	 * */
	void insert(ArticleDTO articleDTO) throws SQLException; 
	
	/**
	 * ArticleDAOImpl의  해당하는 레코드 수정  메소드 호출
	 * */
	void update(ArticleDTO articleDTO) throws SQLException;
	
	/**
	 * ArticleDAOImpl의  해당하는 레코드 삭제  메소드 호출
	 * */
	void delete(int atcCode)throws SQLException;


}
