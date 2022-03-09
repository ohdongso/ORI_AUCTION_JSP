package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.kh.FAQDAO;
import kosta.mvc.dao.kh.FAQDAOImpl;
import kosta.mvc.dto.FaqDTO;

public class FaqServiceImpl implements FaqService {
	private FAQDAO dao = new FAQDAOImpl();
	@Override
	public List<FaqDTO> selectAll() throws SQLException {
		return dao.selectAll();
	}
	@Override
	public List<FaqDTO> searchByCategory(int category) throws SQLException {
		return dao.searchByCategory(category);
	}
	@Override
	public void delete(int faqCode) throws SQLException {
		int result = dao.delete(faqCode);
		if(result==0) throw new SQLException("삭제실패");
	}
	@Override
	public void insert(FaqDTO faq) throws SQLException {
		int result = dao.insert(faq);
		if(result==0) throw new SQLException("등록실패");
	}

}
