package kosta.mvc.dao.kh;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ConsignmentDTO;
import kosta.mvc.dto.ConsignmentReplyDTO;

public interface ConsignmentDAO {
	/**
	 * 일반유저
	 */
	// 위탁등록
	int insert(ConsignmentDTO consignmentDTO) throws SQLException;

	// 위탁조회 ==> 사용자가 조회한 위탁조회.(조건있다.)
	List<ConsignmentDTO> selectById(String id) throws SQLException;
	
	/**
	 * 신청 폼에서 등록한 art 가져오기 위한 메서드
	 * */
	List<ArtDTO> selectArtById(String id) throws SQLException;
	
	ConsignmentDTO selectByCode(int consignCode)throws SQLException;
	
	public ArtDTO getArt(int artCode)throws SQLException;

///////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 관리자
	 */
	// 위탁신청목록조회 ==> 신청된 위탁 전체를 검색
	List<ConsignmentDTO> selectAll() throws SQLException;
///////////////////////////////////////////////////////////////////////////////////////
	/**
	 * (user + admin) ==> 공통
	 */
	// 수락, 거절(기능) ==> 1, 진행중 / 2, 관리자 승인 / 3, 유저 최종승인 / 4, 유저 최종거절 
	int updateConsignState() throws SQLException;

	int delete(int consignCode)throws SQLException;
	
	ConsignmentReplyDTO getReply(int consignCode)throws SQLException;

	boolean check(int artCode) throws SQLException;

}