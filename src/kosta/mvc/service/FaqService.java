package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.FaqDTO;

public interface FaqService {
	
	/**
	 * 화면에 모든 FAQ를 띄우는
	 * */
	public List<FaqDTO> selectAll() throws SQLException;
	
	public List<FaqDTO> searchByCategory(int category) throws SQLException;
	
	public void delete(int faqCode) throws SQLException;
	
	public void insert(FaqDTO faq) throws SQLException;
}
