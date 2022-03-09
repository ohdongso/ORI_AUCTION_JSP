package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dao.ms.BoardReplyDAO;
import kosta.mvc.dao.ms.BoardReplyDAOImpl;
import kosta.mvc.dto.BoardReplyDTO;

public class BoardReplyServiceImpl implements BoardReplyService {
	BoardReplyDAO dao = new BoardReplyDAOImpl();


	@Override
	public void insert(BoardReplyDTO boardReplyDTO) throws SQLException {
		int result = dao.insert(boardReplyDTO);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}
	
	
	@Override
	public void update(BoardReplyDTO boardReplyDTO) throws SQLException {
		int result = dao.update(boardReplyDTO);		
		if(result==0) throw new SQLException("수정되지 않았습니다.");
	}

	@Override
	public void delete(String id, int BoardReplyCode) throws SQLException {
		int result = dao.delete(id, BoardReplyCode);
		if(result==0) throw new SQLException("삭제 실패했습니다.");
	}
	
	
}
