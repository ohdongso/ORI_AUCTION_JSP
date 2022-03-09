package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.DonationDTO;

public interface DonationService {
	/**
	 * 전체 검색
	 */
	List<DonationDTO> selectAll() throws SQLException;

	/**
	 * 글 상세보기
	 */
	DonationDTO selectByDonCode(int donCode) throws SQLException;

	/**
	 * 글 작성
	 */
	void insert(DonationDTO donationDTO) throws SQLException;

	/**
	 * 글 수정
	 */
	void update(DonationDTO donationDTO) throws SQLException;

	/**
	 * 글 삭제
	 */
	void delete(int donCode) throws SQLException;

}
