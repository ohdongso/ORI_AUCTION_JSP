package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.dto.SuccedBidDTO;
import kosta.mvc.service.SuccedBidService;
import kosta.mvc.service.SuccedBidServiceImpl;

public class SucBidController implements Controller {

	private SuccedBidService sucBidService = new SuccedBidServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	/**
	 * 낙찰된 경매들 전체 검색
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SuccedBidDTO> sucBidList = sucBidService.selectAll();
		request.setAttribute("sucBidList", sucBidList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("succedbid/succedbidlist.jsp");
		
		return mv;
	}
	
	/**
	 * 결제 완료 된 경매 상태 변경
	 * */
	public ModelAndView changeState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sucBidCode = request.getParameter("sucBidCode");
		
		sucBidService.changeState(Integer.parseInt(sucBidCode));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("payment/paySuccess.jsp");
		
		return mv;
	}
	
	/**
	 * 경매 코드로 검색
	 * */
	
	
	
	/**
	 * 회원 ID로 낙찰 결과들 검색
	 *  - '나의 낙찰 결과' 페이지에서 활용
	 * */
	public ModelAndView searchByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userId");
		
		List<SuccedBidDTO> sucBidList = sucBidService.searchByUserId(userId);
		request.setAttribute("sucBidList", sucBidList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("succedbid/succedbidlist.jsp");
		
		return mv;
	}
	
	
	
	/**
	 * 작품 코드로 검색
	 * */
	
	
	
	/**
	 * 낙찰가로 검색
	 * */
	
	
	
	/**
	 * 낙찰 정보 수정
	 * */
	
	
	
	/**
	 * 낙찰 정보 삭제 -- by관리자
	 *  ex) 낙찰 받은 회원의 낙찰 취소시
	 * */
	public ModelAndView deleteSucBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sucBidCode = request.getParameter("sucBidCode");
		String id = request.getParameter("userId");
		
		sucBidService.deleteSucBid(Integer.parseInt(sucBidCode), id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("succedbid/succedbidlist.jsp");
		return mv;
	}
	

}
