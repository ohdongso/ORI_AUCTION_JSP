package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.sy.MemberDAO;
import kosta.mvc.dao.sy.MemberDAOImpl;
import kosta.mvc.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO = new MemberDAOImpl();

	/**
	 * 회원가입
	 */
	@Override
	public void memberJoin(MemberDTO memberDTO) throws SQLException {
		int result = memberDAO.memberJoin(memberDTO);
		if(result==0)throw new SQLException("회원가입 실패. 다시 시도해주세요");
		
	}

	/**
	 * 로그인
	 */
	@Override
	public MemberDTO loginCheck(MemberDTO memberDTO) throws SQLException {
		MemberDTO memberdto = memberDAO.loginCheck(memberDTO);
		if(memberdto==null)throw new SQLException("입력하신 회원정보가 존재하지 않습니다. 다시 확인해주세요");
		return memberdto;
		
	}

	

	/**
	 * id에 해당하는 회원정보 검색
	 */
	@Override
	public MemberDTO myInform(String id, boolean flag) throws SQLException {
		MemberDTO memberDTO = memberDAO.myInform(id);
		if(memberDTO==null) throw new SQLException("회원정보 조회 오류. 다시 시도해주세요");
		return memberDTO;
	}
	
	/**
	 * 회원 정보 수정
	 */
	@Override
	public void updateMemberInfo(MemberDTO memberDTO) throws SQLException {
	int result = memberDAO.updateMemberInfo(memberDTO);
	if(result==0)throw new SQLException("정보 수정 오류. 다시 시도해주세요");
	}

	/**
	 * 회원탈퇴
	 */
	@Override
	public void deleteMember(String id, String pw) throws SQLException {
	int result = memberDAO.deleteMember(id, pw);
		if(result==0)throw new SQLException("회원탈퇴 실패. 다시 시도해주세요");
	}

	@Override
	public List<MemberDTO> selectByState(String keyField, String keyWord) throws SQLException {
		List<MemberDTO> list = memberDAO.selectByState(keyField, keyWord);
		if(list==null)throw new SQLException("검색 키워드에 해당하는 회원이 존재하지 않습니다.");
		return list;
	}

	/**
	 * 회원 강퇴
	 */
	@Override
	public void exile(String id) throws SQLException {
		int result = memberDAO.exile(id);
		if(result==0)throw new SQLException("회원정보 삭제 실패. 다시 시도해주세요");
	}

	/**
	 * 전체 회원 검색 - 관리자
	 */
	@Override
	public List<MemberDTO> selectAllMember() throws SQLException {
		return memberDAO.selectAllMember(); 
	}

	@Override
	public int getArtistCode(String id) throws SQLException {
		return memberDAO.getArtistCode(id);
	}

}
