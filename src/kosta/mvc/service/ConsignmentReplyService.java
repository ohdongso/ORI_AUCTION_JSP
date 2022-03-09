package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dto.ConsignmentReplyDTO;

public interface ConsignmentReplyService {
	void insertReply(ConsignmentReplyDTO reply) throws SQLException;
	
}
