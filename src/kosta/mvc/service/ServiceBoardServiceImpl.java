package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.sh.ServiceBoardDAO;
import kosta.mvc.dao.sh.ServiceBoardDAOImpl;
import kosta.mvc.dto.ServiceBoardDTO;

public class ServiceBoardServiceImpl implements ServiceBoardService {
	private ServiceBoardDAO serviceBoardDAO = new ServiceBoardDAOImpl();

	@Override
	public List<ServiceBoardDTO> selectAll() throws SQLException {
		return serviceBoardDAO.selectAll();
	}

	@Override
	public ServiceBoardDTO selectByServiceBoardCode(int serviceBoardCode) throws SQLException {
		ServiceBoardDTO serviceBoardDTO = serviceBoardDAO.selectByServiceBoardCode(serviceBoardCode);
		if(serviceBoardDTO==null) {
			throw new SQLException("정보를 검색하지 못했습니다.");
		}
		return serviceBoardDTO;
	}

	@Override
	public List<ServiceBoardDTO> searchByServiceBoardCategory(int serviceBoardCategory) throws SQLException {
		
		return serviceBoardDAO.searchByServiceBoardCategory(serviceBoardCategory);
	}

	@Override
	public List<ServiceBoardDTO> searchByServiceBoardKeyField(String serviceBoardKeyField, String serviceBoardKeyword)
			throws SQLException {
		List<ServiceBoardDTO> list = serviceBoardDAO.searchByServiceBoardKeyField(serviceBoardKeyField, serviceBoardKeyword);
		if(list.size()==0) {
			throw new SQLException("검색결과가 없습니다.");
		}
		return list;
	}

//	@Override
//	public List<ServiceBoardDTO> selectByServiceBoardCode(String id) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void insert(ServiceBoardDTO serviceBoardDTO) throws SQLException {
		int result = serviceBoardDAO.insert(serviceBoardDTO);
		if(result==0) throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public void updateByServiceBoardState(ServiceBoardDTO serviceBoardDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ServiceBoardDTO serviceBoardDTO) throws SQLException {
		int result = serviceBoardDAO.update(serviceBoardDTO);
		if(result==0) throw new SQLException("수정 실패했습니다.");
	}
		

	@Override
	public void delete(int serviceBoardCode,String id) throws SQLException {
		serviceBoardDAO.deleteAll(serviceBoardCode);
		int result = serviceBoardDAO.delete(serviceBoardCode, id);
		if(result==0) throw new SQLException("삭제 실패했습니다.");
	}

}
