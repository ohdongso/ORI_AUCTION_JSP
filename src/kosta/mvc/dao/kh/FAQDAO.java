package kosta.mvc.dao.kh;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.FaqDTO;

public interface FAQDAO {
	/**
	 * 전체 FAQ 출력
	 * */
	List<FaqDTO> selectAll() throws SQLException;
	
	/**
	 * FAQ상세보기
	 * */
	FaqDTO selectByFaqCode(int faqCode) throws SQLException; 
	
	/**
	 * 카테고리에 맞는 FAQ출력
	 * */
	List<FaqDTO> searchByCategory(int category) throws SQLException;
	
	/**
	 * 관리자-FAQ 추가하기
	 * @return : 1-추가완료, 0-추가실패
	 * */
	int insert(FaqDTO faq) throws SQLException;
	
	/**
	 * 관리자-FAQ 수정하기
	 * @return : 1-수정완료, 0-수정실패
	 * */
	int update(FaqDTO faq) throws SQLException;
	
	/**
	 * 관리자-FAQ 삭제하기
	 * @return : 1-삭제완료, 0-삭제실패
	 * */
	int delete(int faqCode) throws SQLException;
	
	
}
