package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.dh.BiddingDAO;
import kosta.mvc.dao.dh.BiddingDAOImpl;
import kosta.mvc.dto.BiddingDTO;

public class BiddingServiceImpl implements BiddingService {

	private BiddingDAO biddingDAO = new BiddingDAOImpl();
	
	@Override
	public void insertBid(BiddingDTO biddingDTO) throws SQLException {
		int result = biddingDAO.insertBid(biddingDTO);
		if(result==0) throw new SQLException("응찰에 실패했습니다.");
	}

	@Override
	public List<BiddingDTO> selectAll() throws SQLException {
		return biddingDAO.selectAll();
	}

	@Override
	public BiddingDTO checkByAucCodeId(int aucCode, String loginUser) throws SQLException {
		BiddingDTO biddingDTO = biddingDAO.checkByAucCodeId(aucCode, loginUser);
		//if(biddingDTO==null) throw new SQLException("해당 경매에 응찰 가능한 사용자입니다.");
		return biddingDTO;
	}
	
	@Override
	public List<BiddingDTO> searchBidArtState(String id) throws SQLException {
		List<BiddingDTO> list = biddingDAO.searchBidArtState(id);
		if(list==null) throw new SQLException("응찰 정보가 존재하지 않습니다.");
		return list;
	}
	
	@Override
	public BiddingDTO selectByBidCode(int bidCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BiddingDTO> selectBidByAucCode(int aucCode) throws SQLException {
		List<BiddingDTO> list = biddingDAO.selectBidByAucCode(aucCode);
		if(list==null) throw new SQLException("해당 경매에 응찰 정보가 존재하지 않습니다.");
		return list;
	}

	@Override
	public List<BiddingDTO> selectBidByUserId(String id) throws SQLException {
		List<BiddingDTO> list = biddingDAO.selectBidByUserId(id);
		if(list==null) throw new SQLException("ID에 해당하는 응찰 정보가 존재하지 않습니다.");
		return list;
	}

	//낙찰자 1인 찾기
	@Override
	public BiddingDTO selectTopBid(int aucCode) throws SQLException {
		BiddingDTO topBid = biddingDAO.selectTopBid(aucCode);
		if(topBid==null) throw new SQLException("해당 경매에 응찰 정보가 존재하지 않습니다.");
		return topBid;
	}
	
	@Override
	public List<BiddingDTO> selectBidByArtCode(int artCode) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBid(BiddingDTO biddingDTO) throws SQLException {
		int result = biddingDAO.updateBid(biddingDTO);
		if(result==0) throw new SQLException("응찰 정보 수정에 실패했습니다.");

	}

	@Override
	public void deleteBid(int bidCode, String id) throws SQLException {
		int result = biddingDAO.deleteBid(bidCode, id);
		if(result==0) throw new SQLException("응찰 내역 삭제에 실패했습니다.");

	}

	
}
