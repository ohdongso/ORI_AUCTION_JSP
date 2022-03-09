package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dao.kh.ReviewReplyDAO;
import kosta.mvc.dao.kh.ReviewReplyDAOImpl;
import kosta.mvc.dto.ReviewBoardReplyDTO;

public class ReviewReplyServiceImpl implements ReviewReplyService {
	ReviewReplyDAO dao = new ReviewReplyDAOImpl();
	@Override
	public void insert(ReviewBoardReplyDTO reply) throws SQLException {
		int result = dao.insert(reply);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public void update(ReviewBoardReplyDTO reply) throws SQLException {
		int result = dao.update(reply);
		if(result==0) throw new SQLException("수정 실패했습니다.");
	}

	@Override
	public void delete(String id, int replyCode) throws SQLException {
		int result = dao.delete(id, replyCode);
		if(result==0) throw new SQLException("삭제 실패했습니다.");
	}

}
