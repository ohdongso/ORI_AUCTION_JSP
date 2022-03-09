package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.dh.SuccedBidDAO;
import kosta.mvc.dao.dh.SuccedBidDAOImpl;
import kosta.mvc.dto.SuccedBidDTO;

public class SuccedBidServiceImpl implements SuccedBidService {
	
	private SuccedBidDAO succedBidDAO = new SuccedBidDAOImpl();

	@Override
	public void insert(SuccedBidDTO succedBidDTO) throws SQLException {
		int result = succedBidDAO.insert(succedBidDTO);
		if(result==0) throw new SQLException("낙찰 등록에 실패했습니다.");
	}

	@Override
	public List<SuccedBidDTO> selectAll() throws SQLException {
		return succedBidDAO.selectAll();
	}

	@Override
	public void changeState(int sucBidCode) throws SQLException {
		int result = succedBidDAO.changeState(sucBidCode);
		if(result==0) throw new SQLException("결제 상태 수정에 실패했습니다.");
	}
	
	@Override
	public SuccedBidDTO searchBySucBidCode(int sucBidCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuccedBidDTO searchByAucCode(int aucCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SuccedBidDTO> searchByUserId(String id) throws SQLException {
		List<SuccedBidDTO> list = succedBidDAO.searchByUserId(id);
		if(list==null) throw new SQLException("ID에 해당하는 낙찰 정보가 존재하지 않습니다.");
		return list;
	}

	@Override
	public SuccedBidDTO searchByArtCode(int artCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SuccedBidDTO> searchBySucBidCost(int minSucBidCost, int maxSucBidCost) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSucBid(SuccedBidDTO succedBidDTO) throws SQLException {
		int result = succedBidDAO.updateSucBid(succedBidDTO);
		if(result==0) throw new SQLException("낙잘 정보 수정에 실패했습니다.");
	}

	@Override
	public void deleteSucBid(int sucBidCode, String id) throws SQLException {
		int result = succedBidDAO.deleteSucBid(sucBidCode, id);
		if(result==0) throw new SQLException("낙잘 정보 삭제에 실패했습니다.");
	}


}
