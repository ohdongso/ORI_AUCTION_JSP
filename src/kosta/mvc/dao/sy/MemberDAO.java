package kosta.mvc.dao.sy;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.MemberDTO;

public interface MemberDAO {
	
	/**
	 * 회원가입
	 */
	int memberJoin(MemberDTO memberdto)throws SQLException;
	
	/**
	 * 아이디중복체크
	 */
	boolean idCheck(String id);
	
	/**
	 * 로그인
	 */
	MemberDTO loginCheck(MemberDTO memberdto)throws SQLException;
	
	
	/**
	 * id에 해당하는 회원정보 검색
	 */
	MemberDTO myInform(String id)throws SQLException;
	
	/**
	 * 회원정보수정
	 */
	int updateMemberInfo(MemberDTO memberdto)throws SQLException;
	
	/**
	 * 회원탈퇴
	 */
	int deleteMember(String id, String pw)throws SQLException;
	
	/**
	 * 여러 조건별 회원 검색 ( 관리자 ) 
	 */
	List<MemberDTO> selectByState(String keyField, String keyWord)throws SQLException;
	
	/**
	 * 회원 강제 탈퇴 기능 ( 관리자 ) 
	 */
	int exile (String id)throws SQLException;
	
	/**
	 * 전체 회원 조회 ( 관리자 )
	 */
	List<MemberDTO> selectAllMember()throws SQLException;
	
	/**
	 * 아티스트 정보 가져오기
	 */
	int getArtistCode(String id)throws SQLException;
}
