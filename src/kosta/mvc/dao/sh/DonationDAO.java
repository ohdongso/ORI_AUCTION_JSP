package kosta.mvc.dao.sh;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.DonationDTO;


public interface DonationDAO {

	/**
	 * 전체 출력
	 */
	List<DonationDTO> selectAll() throws SQLException;

	/**
	 * 글 상세보기
	 */
	DonationDTO selectByDonCode(int donCode) throws SQLException;

	/**
	 * 글 작성
	 * 
	 * @return : 1-작성성공 , 0 - 삽입실패
	 */
	int insert(DonationDTO donationDTO) throws SQLException;

	/**
	 * 글 수정
	 * 
	 * @return : 1-수정성공 , 0 - 수정실패
	 */
	int update(DonationDTO donationDTO) throws SQLException;

	/**
	 * 글 삭제
	 * 
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 */
	int delete(int donCode) throws SQLException;

}

