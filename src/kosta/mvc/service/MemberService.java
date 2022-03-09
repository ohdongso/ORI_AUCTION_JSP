package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.MemberDTO;

public interface MemberService {
	/**
	 * 회원가입
	 */
	void memberJoin(MemberDTO memberdto)throws SQLException;
	
	
	/**
	 * 로그인
	 */
	MemberDTO loginCheck(MemberDTO memberdto)throws SQLException;
	
	
	/**
	 * 회원정보수정
	 */
	void updateMemberInfo(MemberDTO memberdto)throws SQLException;
	
	/**
	 * 아이디에 해당하는 레코드 검색
	 */
	MemberDTO myInform(String id, boolean flag)throws SQLException;
	
	/**
	 * 회원탈퇴
	 */
	void deleteMember(String id, String pw)throws SQLException;
	
	/**
	 * 여러 조건별 회원 검색 ( 관리자 ) 
	 */
	List<MemberDTO> selectByState(String keyField, String keyWord)throws SQLException;
	
	/**
	 * 회원 강제 탈퇴 기능 ( 관리자 ) 
	 */
	void exile (String id)throws SQLException;
	
	/**
	 * 전체 회원 조회 ( 관리자 )
	 */
	List<MemberDTO> selectAllMember()throws SQLException;

	/**
	 * 아티스트코드 가져오기
	 */
	int getArtistCode(String id)throws SQLException;
}
