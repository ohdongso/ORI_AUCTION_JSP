package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.BiddingDTO;

public interface BiddingService {

	/**
	 * 응찰하기 (insertBid)
	 *  - 회원아이디, 옥션코드, 작품코드, 금액, 응찰시간을 전달받아서 DB등록.
	 * */
	void insertBid(BiddingDTO biddingDTO) throws SQLException;
	
	/**
	 * 전체 응찰 검색
	 * */
	List<BiddingDTO> selectAll() throws SQLException;
	
	/**
	 * 경매코드와 ID로 응찰 검색
	 *  - 중복 응찰 확인
	 * */
	BiddingDTO checkByAucCodeId(int parseInt, String loginUser) throws SQLException;
	
	/**
	 * 응찰코드로 응찰 내역 검색하기
	 */
	BiddingDTO selectByBidCode(int bidCode) throws SQLException;
	
	/**
	 * 경매코드로 해당 경매에 가장 많은 금액을 먼저 응찰한 사용자를 찾기
	 **/
	BiddingDTO selectTopBid(int parseInt) throws SQLException;
	
	/**
	 * 경매 코드로 응찰 리스트 검색해서 정렬해서 전달 (응찰가, 시간)
	 *  - 경매에 몇 명의 회원들이 응찰했는지 확인할 때 
	 * */
	List<BiddingDTO> selectBidByAucCode(int aucCode) throws SQLException;
	
	/**
	 * 회원 ID로 응찰 리스트 검색
	 *  - 로그인한 회원이 응찰한 작품을 찾아서 '나의 응찰 내역'에 리스트 전송할 때
	 * */
	List<BiddingDTO> selectBidByUserId(String id) throws SQLException;
	
	/**
	 * 회원 ID로 응찰 리스트에 작품 상태를 포함하여 가져올 때
	 * */
	List<BiddingDTO> searchBidArtState(String id) throws SQLException;
	
	/**
	 * 작품 코드로 응찰 리스트 검색
	 *  - 작품 상세에서 응찰 현황 파악할 때 
	 * */
	List<BiddingDTO> selectBidByArtCode(int artCode) throws SQLException;
	
	/**
	 * 응찰 정보 수정 -- by관리자
	 *  - 회원의 요청에 따라 부득이하게 응찰 정보를 수정 해야할 때
	 *    ex) 금액을 잘못 입력했을 때
	 * */
	void updateBid(BiddingDTO biddingDTO) throws SQLException;
	
	/**
	 * 응찰내역 삭제 -- by관리자
	 *  - 회원의 요청에 따라 부득이하게 응찰 취소를 해야할 때
	 *    ex) 작품 정보를 잘 못 이해한 상태에서 응찰을 했을 때
	 * */
	void deleteBid(int bidCode, String id) throws SQLException;

}
