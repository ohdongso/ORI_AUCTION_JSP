package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dao.kh.ConsignmentReplyDAO;
import kosta.mvc.dao.kh.ConsignmentReplyDAOImpl;
import kosta.mvc.dto.ConsignmentReplyDTO;

public class ConsignmentReplyServiceImpl implements ConsignmentReplyService {
	ConsignmentReplyDAO dao = new ConsignmentReplyDAOImpl();
	@Override
	public void insertReply(ConsignmentReplyDTO reply) throws SQLException {
		int result = dao.insertReply(reply);
		if(result==0)throw new SQLException("답변달기 실패");
	}

}
