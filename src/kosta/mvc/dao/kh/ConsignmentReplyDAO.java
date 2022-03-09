package kosta.mvc.dao.kh;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ConsignmentReplyDTO;

public interface ConsignmentReplyDAO {
	
	int insertReply(ConsignmentReplyDTO reply)throws SQLException;
	
	void updateState(int consignCode) throws SQLException;
}