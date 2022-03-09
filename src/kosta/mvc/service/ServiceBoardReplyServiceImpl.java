package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dao.sh.ServiceBoardDAO;
import kosta.mvc.dao.sh.ServiceBoardDAOImpl;
import kosta.mvc.dao.sh.ServiceBoardReplyDAO;
import kosta.mvc.dao.sh.ServiceBoardReplyDAOImpl;
import kosta.mvc.dto.ServiceBoardReplyDTO;

public class ServiceBoardReplyServiceImpl implements ServiceBoardReplyService {
	ServiceBoardReplyDAO serviceBoardReplyDAO =new ServiceBoardReplyDAOImpl();
	ServiceBoardDAO serviceBoardDAO = new ServiceBoardDAOImpl();
		// TODO Auto-generated constructor stub


	@Override
	public void insert(ServiceBoardReplyDTO serviceBoardReplyDTO) throws SQLException {
		int result = serviceBoardReplyDAO.insert(serviceBoardReplyDTO);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
		
		serviceBoardDAO.setState(serviceBoardReplyDTO.getServiceBoardCode());
	}
	

	@Override
	public void update(ServiceBoardReplyDTO serviceBoardReplyDTO) throws SQLException {
		int result = serviceBoardReplyDAO.update(serviceBoardReplyDTO);
		
		if(result==0) throw new SQLException("수정되지 않았습니다.");

	}

	@Override
	public void delete(String id, int serviceReplyCode) throws SQLException {
		// TODO Auto-generated method stub

	}

}
