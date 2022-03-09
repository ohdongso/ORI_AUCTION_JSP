package kosta.mvc.dao.sy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.MemberDTO;
import kosta.mvc.util.DbUtil;

public class MemberDAOImpl implements MemberDAO {

	
	/**
	 * 회원가입
	 */
	@Override
	public int memberJoin(MemberDTO member) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,1, default)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPw());
			ps.setString(3, member.getName());
			ps.setString(4, member.getAccount());
			ps.setString(5, member.getAddr());
			ps.setString(6, member.getContact());
			ps.setString(7, member.getEmail());
			
			result = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * 아이디중복체크
	 */
	@Override
	public boolean idCheck(String id){
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT ID FROM MEMBER WHERE ID =?";
		boolean result = false;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {////////////////////////////// 여기 모르겠음...
				result=true;}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}
	
	/**
	 * 로그인
	 */
	@Override
	public MemberDTO loginCheck(MemberDTO memberDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT ID, PW, NAME, MEM_STATE FROM MEMBER WHERE ID=? AND PW=?";
		MemberDTO member = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, memberDTO.getId());
			ps.setString(2, memberDTO.getPw());
			rs = ps.executeQuery();
			if(rs.next()) {
				
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3));
				member.setMemState(rs.getInt(4));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return member;
	}
	
	
	/**
	 * id에 해당하는 회원정보 검색
	 */
	@Override
	public MemberDTO myInform(String id) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO memberDTO = null;
		String sql = "SELECT*FROM MEMBER WHERE ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				memberDTO = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return memberDTO;
	}
	
	/**
	 * 회원정보수정
	 */
	@Override
	public int updateMemberInfo(MemberDTO member) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "UPDATE MEMBER SET PW=?, ACCOUNT=?, ADDR=?, CONTACT=?, EMAIL=? WHERE ID=?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getPw());
			ps.setString(2, member.getAccount());
			ps.setString(3, member.getAddr());
			ps.setString(4, member.getContact());
			ps.setString(5, member.getEmail());
			ps.setString(6, member.getId());
			
			result = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	/**
	 * 회원탈퇴
	 */
	@Override
	public int deleteMember(String id, String pw) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql ="DELETE FROM MEMBER WHERE ID=? AND PW=?";
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * 여러 조건별 회원 검색 ( 관리자 ) 
	 */
	@Override
	public List<MemberDTO> selectByState(String keyField, String keyWord) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "SELECT ID, NAME, ACCOUNT, ADDR, CONTACT, EMAIL, MEM_STATE, to_char(MEM_RDATE, 'YYYY.MM.DD') FROM MEMBER WHERE ";
		
		switch(keyField) {
			case	"id": sql += "ID LIKE ?"; break;
			case	"name": sql += "NAME LIKE ?"; break;
		//	case	"memState": sql += "MEM_STATE LIKE ?"; break;
			case	"email": sql += "EMAIL LIKE ?"; break;
			case	"contact": sql += "CONTACT LIKE ?"; break;
			case	"account": sql += "ACCOUNT LIKE ?"; break;
			case	"addr": sql += "ADDR LIKE ?"; break;
		}
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyWord + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6),rs.getInt(7),rs.getString(8));
				list.add(member);
			}
		}finally{
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	/**
	 * 회원 강제 탈퇴 기능 ( 관리자 ) 
	 */
	@Override
	public int exile(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql ="DELETE FROM MEMBER WHERE ID=?";
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	/**
	 * 전체 회원 조회 ( 관리자 )
	 */
	@Override
	public List<MemberDTO> selectAllMember() throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="SELECT ID, NAME, ACCOUNT, ADDR, CONTACT, EMAIL, MEM_STATE, to_char(MEM_RDATE, 'YYYY.MM.DD') FROM MEMBER";
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				MemberDTO member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6),rs.getInt(7),rs.getString(8));
				list.add(member);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	/**
	 * id에 해당하는 artistCode 받아오기
	 */
	@Override
	public int getArtistCode(String id) throws SQLException {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="SELECT ARTIST_CODE FROM ARTIST JOIN MEMBER USING(ID) WHERE ID=?";
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

	

	

}
