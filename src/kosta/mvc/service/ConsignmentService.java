package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ArtDTO;
import kosta.mvc.dto.ConsignmentDTO;

public interface ConsignmentService {
	
	/**
	 * 로그인한 유저가 남긴 위탁신청 보기
	 * */
	List<ConsignmentDTO> selectById(String id) throws SQLException;
	
	List<ArtDTO> selectArtById(String id) throws SQLException;
	
	/**
	 * 사용자 위탁신청
	 * */
	void insert(ConsignmentDTO consign) throws SQLException;
	
	
	/**
	 * 관리자가 모든 위탁신청을 보기
	 * */
	List<ConsignmentDTO> selectAll(int state) throws SQLException;
	
	ConsignmentDTO selectByCode(int consignCode) throws SQLException;

	void delete(int consignCode) throws SQLException;
	
	int check(int artCode) throws SQLException;
}
