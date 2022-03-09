package kosta.mvc.dao.ds;

import java.sql.SQLException;      
import java.util.List;
import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.AuctionDTO;
import kosta.mvc.dto.BiddingDTO;

public interface AuctionDAO {
	/**
	 * 전체경매 검색
	 * @param
	 * @return List<AuctionDTO>
	 * */
	List<AuctionDTO> selectAll() throws SQLException;
	
	/**
	 * 경매중인 작품조회
	 * @param AuctionDTO auctionDTO
	 * @return ArtDTO
	 * */
	ArtDTO auctionArtSearch(AuctionDTO auctionDTO) throws SQLException;
	
	/**
	 * (일반, 제로베이스, 자선)경매 검색
	 * @param int aucCategory
	 * @return List<AuctionDTO>
	 * */
	List<AuctionDTO> selectAuction(int aucCategory) throws SQLException;
	
	/**
	 * 조건 경매검색
	 * @param String keyWord, String keyField
	 * @return List<ArtDTO>
	 * */
	List<ArtDTO> searchByAuction(String keyField, String keyWord) throws SQLException;
	
	/**
	 * 조건 경매검색(min, max)
	 * @param int min, int max
	 * @return List<ArtDTO>
	 * */
	List<ArtDTO> searchMinMax(int min, int max) throws SQLException;
	
	/**
	 * 작품 상세보기
	 * @param int aucCode
	 * @return ArtDTO
	 * */
	ArtDTO selectDetailArt(int artCode) throws SQLException;
	
	/**
	 * 작품코드로 경매코드 가져오기
	 * @param
	 * */
	int selectDetailAucCode(int artCode) throws SQLException;
	
	/**
	 * 경매관리 페이지를 클릭했을 때, 경매에 대한 정보를 보여주는 메소드
	 * @param
	 * @return List<AuctionDTO>
	 * */
	List<AuctionDTO> adminSelectAll() throws SQLException;
	
	/**
	 * 경매관리 페이지를 클릭했을 때, 응찰의 최고가를 출력해주는 메소드.
	 * @param int aucCode
	 * @return int result
	 * */
	int getMaxCost(int aucCode) throws SQLException;

	/**
	 * 경매 상태별로 검색
	 * 1(진행), 2(예정), 3(종료)
	 * @param int category
	 * @return List<AuctionDTO> list
	 * */
	List<AuctionDTO> searchByState(int state) throws SQLException;
	
	/**
	 * 관리자페이지에, 진행중인경매 종료기능
	 * 1(진행), 2(예정), 3(종료)
	 * @param int aucCode
	 * @return List<AuctionDTO> auctionDTOList
	 * */
	List<AuctionDTO> endAuction(int aucCode, int state) throws SQLException;
	
	/**
	 * 예정경매 개시하는 기능
	 * @param int aucCode, int state
	 * @return List<AuctionDTO> auctionDTOList 
	 * */
	List<AuctionDTO> startAuction(int aucCode, int state) throws SQLException;
	
	/**
	 * 경매 수정시, updateAuction.jsp까지 정보를 전달 하는 기능
	 * @param AuctionDTO auctionDTO
	 * @return List<AuctionDTO> auctionDTOList 
	 * */
	AuctionDTO updateForm(int aucCode, int aucState, int artCode) throws SQLException;
	
	/**
	 * 경매 수정기능
	 * @param int aucCode, int aucState, int artCode, int updateStartCose
	 * @return List<AuctionDTO> auctionDTOList 
	 * */
	List<AuctionDTO> updateAuction(int aucCode, int aucState, int artCode, int updateStartCose) throws SQLException;
	
	/**
	 * 경매삭제
	 * @param int aucCode 
	 * @return List<AuctionDTO> auctionDTOList 
	 * */
	List<AuctionDTO> deleteAuction(int aucCode, int aucState, int artCode) throws SQLException;
	
	/**
	 * 종료된 경매, 낙찰하는기능
	 * @param int aucCode, int aucState, int artCode, String id, int maxCost
	 * @return List<AuctionDTO> auctionDTOList 
	 * */
	int insertSuccedBid(int aucCode, int aucState, int artCode, String id, int maxCost) throws SQLException;
	
	/**
	 * 낙찰된 경매의 상태를 5번 낙찰진행 상태로 변경하는 기능
	 * @param int updateAuctionState
	 * @return List<AuctionDTO> auctionDTOList 
	 * */
	List<AuctionDTO> updateAuctionState(int aucCode, int artCode, int aucState) throws SQLException;
	
	/**
	 * 경매코드에 해당하는 작품 정보가져오기
	 * @param int artCode
	 * @return ArtDTO artDTO
	 * */
	ArtDTO getArt(int artCode) throws SQLException;
	
	/**
	 * 경매코드에 해당하는 응찰 정보가져오기
	 * @param int artCode
	 * @return List<BiddingDTO> list
	 * */
	List<BiddingDTO> getBid(int artCode) throws SQLException;
	
	/**
	 * 낙찰버튼을 클릭했을 때, 최고 낙찰가에 대한 id를 반환해주는 메소드
	 * @param int aucCode
	 * @return int result
	 * */
	String getMaxCostId(int aucCode) throws SQLException;
	
	/**
	 * 관리자가 최종 승인한, 위탁신청을 예정경매에 등록하는 기능
	 * @param int artCode, int startCost, int aucCategory
	 * @return int result
	 * */
	int insertScheduledAuction(int artCode, int startCost, int aucCategory) throws SQLException;
	
	
}