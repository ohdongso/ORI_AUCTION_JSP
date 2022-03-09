package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.MemberDTO;
import kosta.mvc.service.MemberService;
import kosta.mvc.service.MemberServiceImpl;

public class MemberController implements Controller {

	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 회원가입
	 */
	public ModelAndView memberJoin(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwc = request.getParameter("pwc");
		String name = request.getParameter("name");
		String bank = request.getParameter("bank");
		String accountNum = request.getParameter("accountNum");
		String account = bank +" " +accountNum;
		String addr = request.getParameter("addr1");
		String con1 = request.getParameter("con1");
		String con2 = request.getParameter("con2");
		String con3 = request.getParameter("con3");
		String contact = con1+"-"+con2+"-"+con3;
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email = email1+"@"+email2;
		MemberDTO memberDTO = new MemberDTO(id, pw, name, account, addr, contact, email,0, null);
		
		memberService.memberJoin(memberDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		
		return mv;
	}
	
	/**
	 * 아이디 중복체크
	 */
	public ModelAndView idCheck(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String id = request.getParameter("id");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join.jsp");
		
		return null;
	}
	
	
	/**
	 * 로그인
	 */
	public ModelAndView loginCheck(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDTO member = memberService.loginCheck(new MemberDTO(id, pw));
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", member.getId());
		session.setAttribute("loginName", member.getName());
		session.setAttribute("loginState", member.getMemState());
		int artistCode = memberService.getArtistCode(id);
		if(artistCode!=0) {
			session.setAttribute("loginCode", artistCode);
		}
		ModelAndView mv = new ModelAndView("index.jsp", true);
		
		return mv;
	}
	
	/**
	 * 로그아웃
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("index.jsp", true);
	}
	
	/**
	 * id에 해당하는 회원 정보 조회하기
	 */
	public ModelAndView myInform(HttpServletRequest request, HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		String id = String.valueOf(session.getAttribute("loginUser"));
		MemberDTO memberDTO = memberService.myInform(id, true);
		request.setAttribute("memberDTO", memberDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberInform.jsp");
		return mv;
	}
	
	
	/**
	 * 회원정보수정
	 */
	public ModelAndView updateMemberInfo(HttpServletRequest request, HttpServletResponse response)throws Exception { 
		String id= request.getParameter("id");
		String pw = request.getParameter("pw");
		String account = request.getParameter("account");
		String addr = request.getParameter("addr");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		MemberDTO memberDTO = new MemberDTO(id, pw, account, addr, contact, email);
		memberService.updateMemberInfo(memberDTO);
		
		memberDTO = memberService.myInform(id, false);
		request.setAttribute("memberDTO", memberDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberInform.jsp");
		
		return mv;
	}
	
	/**
	 * 회원탈퇴
	 */
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		memberService.deleteMember(id, pw);
		ModelAndView mv = new ModelAndView("index.jsp", true);
		HttpSession session = request.getSession();
		session.invalidate();
		return mv;
	}
	
	/** 
	 * 회원검색 - 관리자
	 */
	public ModelAndView selectByState(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		List<MemberDTO> memberList = memberService.selectByState(keyField, keyWord);
		request.setAttribute("memberList", memberList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberList.jsp");
		return mv;
	}
	
	/**
	 * 회원 강제 탈퇴 기능 ( 관리자 ) 
	 */
	public ModelAndView exile(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String id = request.getParameter("id");
		memberService.exile(id);
		List<MemberDTO> memberList = memberService.selectAllMember();
		request.setAttribute("memberList", memberList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberList.jsp");
		return mv;
	}
	
	/**
	 * 전체 회원 조회 ( 관리자 )
	 */
	public ModelAndView selectAllMember(HttpServletRequest request, HttpServletResponse response)throws Exception {
		List<MemberDTO> memberList = memberService.selectAllMember();
		request.setAttribute("memberList", memberList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberList.jsp");
		
		return mv;
	}
	
	
}
