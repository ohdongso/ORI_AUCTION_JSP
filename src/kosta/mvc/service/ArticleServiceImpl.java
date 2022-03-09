package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.ms.ArticleDAO;
import kosta.mvc.dao.ms.ArticleDAOImpl;
import kosta.mvc.dto.ArticleDTO;

public class ArticleServiceImpl implements ArticleService {
	private ArticleDAO articleDAO = new ArticleDAOImpl();
	@Override
	public List<ArticleDTO> selectAll(int pageNo) throws SQLException {
		return articleDAO.selectAll(pageNo);
	}
	
	
	@Override
	public ArticleDTO selectByAtcCode(int atcCode) throws SQLException {
		
		
		
		ArticleDTO article= articleDAO.selectByAtcCode(atcCode);
		if(article==null) {
			throw new SQLException("정보를 검색하지 못했습니다..");
		}
		
		return article;
	}



	@Override
	public void insert(ArticleDTO articleDTO) throws SQLException {
		int result = articleDAO.insert(articleDTO);
		if(result==0)throw new SQLException("등록되지 않았습니다");	
	}
	
	@Override
	public void update(ArticleDTO articleDTO) throws SQLException {
		int result = articleDAO.update(articleDTO);
		if(result==0) {
			throw new SQLException("수정되지 않았습니다.");
		}
	}


	@Override
	public void delete(int atcCode) throws SQLException {
		int result = articleDAO.delete(atcCode);
		if(result==0) throw new SQLException("삭제 실패했습니다.");
		
	}
	
	
}
