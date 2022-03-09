package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.SuccedBidDTO;

public interface SuccedBidService {

	/**
	 * 낙찰된 경매 등록
	 *  - 종료된 경매 중에서 낙찰자가 있는 경매를 낙찰된 경매에 등록
	 *  - 경매 기간 만료 -> 응찰버튼 비활성화 -> 관리자가 수동으로 낙찰 경매에 등록
	 * */
	void insert(SuccedBidDTO succedBidDTO) throws SQLException;
	
	/**
	 * 낙찰된 경매들 전체 검색
	 * */
	List<SuccedBidDTO> selectAll() throws SQLException;
	
	/**
	 * 결재 완료시 상태 변경
	 * */
	void changeState(int sucBidCode) throws SQLException;
	
	/**
	 * 낙찰 코드로 검색
	 * */
	SuccedBidDTO searchBySucBidCode(int sucBidCode) throws SQLException;
	
	/**
	 * 경매 코드로 검색
	 * */
	SuccedBidDTO searchByAucCode(int aucCode) throws SQLException;
	
	/**
	 * 회원 ID로 낙찰 결과들 검색
	 *  - '나의 낙찰 결과' 페이지에서 활용
	 * */
	List<SuccedBidDTO> searchByUserId(String id) throws SQLException;
	
	/**
	 * 작품 코드로 검색
	 * */
	SuccedBidDTO searchByArtCode(int artCode) throws SQLException;
	
	/**
	 * 낙찰가로 검색
	 * */
	List<SuccedBidDTO> searchBySucBidCost(int minSucBidCost, int maxSucBidCost) throws SQLException;
	
	/**
	 * 낙찰 정보 수정
	 * */
	void updateSucBid(SuccedBidDTO succedBidDTO) throws SQLException;
	
	/**
	 * 낙찰 정보 삭제 -- by관리자
	 *  ex) 낙찰 받은 회원의 낙찰 취소시
	 * */
	void deleteSucBid(int sucBidCode, String id) throws SQLException;

	
}
