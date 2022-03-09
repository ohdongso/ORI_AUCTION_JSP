package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.BiddingDTO;
import kosta.mvc.service.BiddingService;
import kosta.mvc.service.BiddingServiceImpl;

public class BidController implements Controller {
	
	private BiddingService biddingService = new BiddingServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	/**
	 * 응찰 정보 등록
	 *  - 로그인한 회원아이디, 옥션코드, 작품코드, 금액을 전달받아서 DB등록.
	 * */
	public ModelAndView insertBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String aucCode = request.getParameter("aucCode");
		String id = request.getParameter("loginUser");
		String artCode = request.getParameter("artCode");
		String bidCost = request.getParameter("bidCost");
		
		if(biddingService.checkByAucCodeId(Integer.parseInt(aucCode), id) == null) {
			BiddingDTO biddingDTO = new BiddingDTO(0,Integer.parseInt(aucCode),id,
					Integer.parseInt(artCode),Integer.parseInt(bidCost),null);
			
			biddingService.insertBid(biddingDTO);
			request.setAttribute("msg", "정상적으로 응찰되었습니다.");
		}else {
			request.setAttribute("msg", "중복 응찰할 수 없습니다.");
		}
		//return new ModelAndView("auction/detailArt.jsp", true);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bidding/bidMsg.jsp");
		return mv;
	}
	
	/**
	 * 전체 응찰 내역 검색
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BiddingDTO> bidList = biddingService.selectAll();
		request.setAttribute("bidList", bidList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bidding/biddinglist.jsp");
		return mv;
	}
	
	/**
	 * 경매코드로 해당 경매에 가장 많은 금액을 먼저 응찰한 사용자를 찾기
	 *  - 동일한 금액을 응찰했을 시, 먼저 응찰한 사람이 낙찰우선순위가 된다.
	 * */
	public ModelAndView selectTopBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String aucCode = request.getParameter("aucCode");
		
		BiddingDTO topBid = biddingService.selectTopBid(Integer.parseInt(aucCode));
		request.setAttribute("topBid", topBid);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bidding/topBidView.jsp");
		
		return mv;
	}
	
	/**
	 * 경매 코드로 응찰 리스트 검색
	 *  - 경매에 몇 명의 회원들이 응찰했는지 확인할 때 
	 *  - 낙찰 우선순위를 확인할 때
	 * */
	public ModelAndView selectByAucCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String aucCode = request.getParameter("aucCode");
		
		List<BiddingDTO> bidList = biddingService.selectBidByAucCode(Integer.parseInt(aucCode));
		request.setAttribute("bidList", bidList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bidding/biddinglist.jsp");
		
		return mv;
	}
	
	/**
	 * 회원 ID로 응찰 리스트 검색
	 *  - 로그인한 회원이 응찰한 작품을 찾아서 '나의 응찰 내역'에 리스트 전송할 때
	 * */
	public ModelAndView selectByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("userId");
		
		List<BiddingDTO> bidList = biddingService.selectBidByUserId(userId);
		request.setAttribute("bidList", bidList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bidding/biddinglist.jsp");
		
		return mv;
	}
	
	/**
	 * 회원 ID로 회원이 참여한 경매의 응찰 정보와 작품 상태를 함께 가져오기
	 * */
	public ModelAndView searchBidArtState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		//String userId = request.getParameter("userId");
		String id = (String)session.getAttribute("loginUser");
		
		List<BiddingDTO> bidList = biddingService.searchBidArtState(id);
		request.setAttribute("bidList", bidList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bidding/biddinglist.jsp");
		
		return mv;
	}
	
	/**
	 * 응찰 정보 수정 -- by관리자
	 *  - 회원의 요청에 따라 부득이하게 응찰 정보를 수정 해야할 때
	 *    ex) 금액을 잘못 입력했을 때
	 * */
	
	/**
	 * 응찰내역 삭제 -- by관리자
	 *  - 회원의 요청에 따라 부득이하게 응찰 취소를 해야할 때
	 *    ex) 작품 정보를 잘 못 이해한 상태에서 응찰을 했을 때
	 * */
	public ModelAndView deleteBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String bidCode = request.getParameter("bidCode");
		String id = request.getParameter("userId");
		
		biddingService.deleteBid(Integer.parseInt(bidCode), id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bidding/biddinglist.jsp");
		return mv;
	}
}
