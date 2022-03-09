package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.ds.AuctionDAO;
import kosta.mvc.dao.ds.AuctionDAOImpl;
import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.AuctionDTO;

public class AuctionServiceImpl implements AuctionService{
	private AuctionDAO auctionDAO = new AuctionDAOImpl();
	
	/**
	 * 전체경매
	 * */
	@Override
	public List<AuctionDTO> selectAll() throws SQLException {
		List<AuctionDTO> auctionList = auctionDAO.selectAll();
		return auctionList;
	}
	
	/**
	 * 경매중인 작품조회
	 * */
	@Override
	public ArtDTO auctionArtSearch(AuctionDTO auctionDTO) throws SQLException {
		ArtDTO artDTO =  auctionDAO.auctionArtSearch(auctionDTO);
		return artDTO;
	}
	
	/**
	 * (일반, 제로베이스, 자선)경매 검색
	 * */
	@Override
	public List<AuctionDTO> selectAuction(int aucCategory) throws SQLException {
		List<AuctionDTO> auctionList = auctionDAO.selectAuction(aucCategory);
		return auctionList;
	}
	
	/**
	 * 조건 경매검색
	 * */
	@Override
	public List<ArtDTO> searchByAuction(String keyField, String keyWord) throws SQLException {
		List<ArtDTO> artDTOList = auctionDAO.searchByAuction(keyField, keyWord);
		return artDTOList;
	}
	
	/**
	 * 조건 경매검색 min, max
	 * */
	@Override
	public List<ArtDTO> searchMinMax(int min, int max) throws SQLException {
		List<ArtDTO> artDTOList = auctionDAO.searchMinMax(min, max);
		return artDTOList;
	}

	/**
	 * 작품 상세보기
	 * */
	@Override
	public ArtDTO selectDetailArt(int artCode) throws SQLException {
		ArtDTO artDTO = auctionDAO.selectDetailArt(artCode);	
		return artDTO;
	}
	
	/**
	 * 작품에 해당하는 경매코드 가져오기
	 * */
	@Override
	public int selectDetailAucCode(int artCode) throws SQLException {
		int aucCode = auctionDAO.selectDetailAucCode(artCode);
		return aucCode;
	}
	
	/**
	 * 경매관리 페이지를 클릭했을 때, 경매에 대한 정보를 보여주는 메소드
	 * */
	@Override
	public List<AuctionDTO> adminSelectAll() throws SQLException {
		List<AuctionDTO> auctionDtoList = auctionDAO.adminSelectAll();
		return auctionDtoList;
	}
	
	/**
	 * 경매 카테고리 검색
	 * */
	@Override
	public List<AuctionDTO> searchByState(int state) throws SQLException {
		List<AuctionDTO> auctionDtoList = auctionDAO.searchByState(state);
		return auctionDtoList;
	}
	
	/**
	 * 경매종료
	 * */
	@Override
	public List<AuctionDTO> endAuction(int aucCode, int state) throws SQLException {
		List<AuctionDTO> auctionDTOList = auctionDAO.endAuction(aucCode, state);
		return auctionDTOList;
	}
	
	/**
	 * 예정경매 개시하는 기능
	 */
	@Override
	public List<AuctionDTO> startAuction(int aucCode, int state) throws SQLException {
		List<AuctionDTO> auctionDtoList = auctionDAO.startAuction(aucCode, state);
		return auctionDtoList;
	}
	
	/**
	 * 경매 수정시, updateAuction.jsp까지 정보를 전달 하는 기능
	 * */
	@Override
	public AuctionDTO updateForm(int aucCode, int aucState, int artCode) throws SQLException {
		AuctionDTO auctionDTO = auctionDAO.updateForm(aucCode, aucState, artCode);
		return auctionDTO;
	}
	
	/**
	 * 경매수정
	 * */
	@Override
	public List<AuctionDTO> updateAuction(int aucCode, int aucState, int artCode, int updateStartCose) throws SQLException {
		List<AuctionDTO> auctionDtoList = auctionDAO.updateAuction(aucCode, aucState, artCode, updateStartCose);
		return auctionDtoList;
	}
	
	/**
	 * 경매삭제
	 * */
	@Override
	public List<AuctionDTO> deleteAuction(int aucCode, int aucState, int artCode) throws SQLException {
		List<AuctionDTO> auctionDtoList = auctionDAO.deleteAuction(aucCode, aucState, artCode);
		return auctionDtoList;
	}
	
	/**
	 * 종료된 경매, 낙찰하는기능
	 * */
	@Override
	public int insertSuccedBid(int aucCode, int aucState, int artCode, String id, int maxCost) throws SQLException {
		int result = auctionDAO.insertSuccedBid(aucCode, aucState, artCode, id, maxCost);
		
		if(result == 0) {
			throw new SQLException("낙찰되지 않았습니다.");
		}
		
		return result;
	}

	/**
	 * 낙찰버튼을 클릭했을 때, 최고 낙찰가에 대한 id를 반환해주는 메소드
	 * */
	@Override
	public String getMaxCostId(int aucCode) throws SQLException {
		String id = auctionDAO.getMaxCostId(aucCode);
		return id;
	}
	
	/**
	 * 관리자가 최종 승인한, 위탁신청을 예정경매에 등록하는 기능
	 * */
	@Override
	public int insertScheduledAuction(int artCode, int startCost, int aucCategory) throws SQLException {
		int result = auctionDAO.insertScheduledAuction(artCode, startCost, aucCategory);
		
		if(result == 0) {
			throw new SQLException("예정경매에 등록되지 않았습니다.");
		}
		
		return result;
	}
}